import java.util.*; 
public class ShortRoute{ 
    public int dist[]; 
    public Set<Integer> settled; 
    public PriorityQueue<City> pq; 
    public int cities; // Number of cities 
    LinkedList<LinkedList<City>> adj; 
  
    public ShortRoute(int cities) 
    { 
        this.cities = cities; 
        dist = new int[cities]; 
        settled = new HashSet<Integer>(); 
        pq = new PriorityQueue<City>(cities, new City()); 
    } 
  
    // Function for Dijkstra's Algorithm 
    public void dijkstra(LinkedList<LinkedList<City>> adj, int origin) 
    { 
        this.adj = adj; 
  
        for (int i = 0; i < cities; i++) 
            dist[i] = Integer.MAX_VALUE; 
  
        // Add original city to the priority queue 
        pq.add(new City(origin, 0)); 
  
        // Distance to origin is 0 
        dist[origin] = 0; 
        while (settled.size() != cities) { 
  
            // remove the minimum distance of city from the priority queue  
            int u = pq.remove().city; 
  
            // adding the city whose distance is finalized 
            settled.add(u); 
  
            NearCity(u); 
        } 
    } 
  
    //Processes all the neighbours of the passed city 
    private void NearCity(int u) 
    { 
        int edgeDistance = -1; 
        int newDistance = -1; 
  
        //All the neighbors of a city
        for (int i = 0; i < adj.get(u).size(); i++) { 
            City c = adj.get(u).get(i); 
  
            //If current node hasn't already been processed 
            if (!settled.contains(c.city)) { 
                edgeDistance = c.dist; 
                newDistance = dist[u] + edgeDistance; 
  
                // If new distance is cheaper in cost 
                if (newDistance < dist[c.city]) 
                    dist[c.city] = newDistance; 
  
                // Add the current node to the queue 
                pq.add(new City(c.city,dist[c.city])); 
            } 
        } 
    } 
    
    public static void main(String arg[]) 
    { 
        int cities = 5; 
        int origin = 0; 
  		Graph g = new Graph();
  		Attractions a = new Attractions();
        LinkedList<LinkedList<City>> adj = new LinkedList<LinkedList<City>>(); 
  
        // Initialize LinkedList for every city  
        for (int i = 0; i < cities; i++) { 
            LinkedList<City> item = new LinkedList<City>(); 
            adj.add(item); 
        } 
  
        // Inputs for the map graph 
        adj.get(0).add(new City(g.getCity(),g.getDist())); 
  
        // Calculate the single source shortest path 
        ShortRoute sr = new ShortRoute(cities); 
        sr.dijkstra(adj, origin); 
  
        // Print the shortest path for the cities from the original city. 
        System.out.println("The shorted path between cities:"); 
        for (int i = 0; i < sr.dist.length; i++) 
            System.out.println("From City "+ origin + " to " + i + " in the shortest path would be:" + sr.dist[i]); 
    } 
} 
  
// Class to represent the city in the graph 
class City implements Comparator<City> { 
    public int city; 
    public int dist; 
  
    public City() 
    { 
    } 
  
    public City(int city, int dist) 
    { 
        this.city = city; 
        this.dist = dist; 
    } 
    public int compare(City c1, City c2) 
    { 
        if (c1.dist < c2.dist){ 
            return -1; 
        }
        if (c1.dist > c2.dist){ 
            return 1; 
        }
        return 0; 
    } 
} 