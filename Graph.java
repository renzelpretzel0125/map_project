//everything from roads.csv
import java.util.LinkedList;
public class Graph{
	private LinkedList [] adjacencyList; 
	public Graph (int vertices){ 
		adjacencyList = new LinkedList[vertices]; 
		for (int i = 0; i < vertices.length; i++){ 
			adjacencyList[i] = new LinkedList(); 
		}
	}
	// Other functions here. 
	//get - return the head.value returns null if key.value pair isnt there
	//addEdges - starting and ending points,corresponds to the neighbors, cost, and nodes, also keeping track of current node
	public get(){

	}
	public addEdges(){

	}
} 
