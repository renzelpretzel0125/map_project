//everything from roads.csv
import java.util.LinkedList;
import java.util.Hashtable;
import java.lang.*;
public class Graph{
	private class Weightedg{
		int weight;
		int vertex;
		public Weightedg(int weight,int vertex){
			this.weight = weight;
			this.vertex = vertex;
		}

	}
	private LinkedList<LinkedList<Weightedg>> adjacencyList; 
	private Hashtable<String, Integer> cities;
	//private LinkedList<LinkedList<>>cityMap;
	private int count;
	public Graph(){ 
		adjacencyList = new LinkedList<LinkedList<Weightedg>>(); 
		cities = new Hashtable<String, Integer>();
		count = 0;
	}
	
	public int addCity(String city){//addVertices
		try{
			if(cities.containsKey(city)){
				//cityMap.add(city);
				cities.put(city, count++);
			}else{
				cities.put(city,count);
			}
			return cities.get(city);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	public int addEdge(int v1, int v2, int weight){
		//returns the distance
		//bidirectional 
		Weightedg w = new Weightedg(weight, v2);
		Weightedg w2 = new Weightedg(0,v1);
		LinkedList<Weightedg> innerlist = new LinkedList<Weightedg>();
		innerlist.add(w);
		innerlist.add(w2);
		LinkedList<LinkedList<Weightedg>> mainList = new LinkedList<LinkedList<Weightedg>>();
		mainList.add(innerlist);
		for(LinkedList<Weightedg> sublist : mainList) {
    		for(Weightedg o : sublist) {
        		System.out.println(o.weight+" "+o.vertex);
    		}
		}	

		return -1;  

	}

	/*public boolean hasCity(String c){
		if(c.compareTo(0)>0){
			return true;
		}else{
			return false;
		}
		
	}*/

	/*public void removeCities(){
		/*if(){

		}
	}*/

	//To Test the Graphing
	public static void main(String[]args){
		Graph g = new Graph();
		String[] tempArr = new String[]{"Abilene TX","Austin TX","217"};//line.split(delimiter);
        int city1 = g.addCity(tempArr[0]);//adds upon list
        int city2 = g.addCity(tempArr[1]);//adds upon 
        System.out.println(city1+" "+city2);
        g.addEdge(city1,city2,Integer.parseInt(tempArr[2]));
        //Abilene TX	Austin TX	217
	}
} 
