//reads csv files
import java.io.*;
public class Reader{
   public static final String delimiter = ",";
   public static void read(String csvFile){
    	try{
        	File file = new File(csvFile);
        	FileReader fr = new FileReader(file);
        	BufferedReader br = new BufferedReader(fr);
        	String line = "";
        	String[]roadsArr;
        	String[]attractionsArr;
        	if(csvFile == "roads"){//if files were roads, then will read through roads and put into an adjacency list 
        		while((line = br.readLine()) != null) {
        			roadsArr = line.split(delimiter);
            		Graph g = new Graph();
					int city1 = g.addCity(roadsArr[0]);//adds to adjacency list
            		int city2 = g.addCity(roadsArr[1]);
            		int weight = Integer.parseInt(roadsArr[2]);
            		g.addEdge(city1,city2,weight);
            		System.out.println();
        		}
        		br.close();
        	}
        	if(csvFile == "attractions"){//if csv files were from attractions, put into hashtables
        		while((line = br.readLine()) != null) {
        			roadsArr = line.split(delimiter);
            		Attractions a = new Attractions(attractionsArr[0],attractionsArr[1]); //to bring location and attractions to hashtable
					int location = a.add(attractionsArr[0]);//adds upon into hashtable for location 
            		int attraction = a.add(attractionsArr[1]);//adds attractions into hashtable
            		System.out.println();
        		}
        		br.close();
        	}
        } 
        catch(IOException ioe) {
        	ioe.printStackTrace();
        }

   //}
   //public static void main(String[] args) {
      // csv file to read
      String attractions = "C:/Users/Renzel/Documents/CS245/A2/attractions.csv";
      String roads = "C:/Users/Renzel/Documents/CS245/A2/roads.csv";
      Reader.read(attractions);
      Reader.read(roads);
   }
}