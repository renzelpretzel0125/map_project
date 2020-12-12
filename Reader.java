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
        	String[]tempArr;
        	while((line = br.readLine()) != null) {
        		tempArr = line.split(delimiter);
            	Graph g = new Graph();
				int city1 = g.addCity(tempArr[0]);//adds upon list
            	int city2 = g.addCity(tempArr[1]);
            	int weight = Integer.parseInt(tempArr[2]);
            	g.addEdge(city1,city2,weight)
            	System.out.println();
        	}
        	br.close();
        } 
        catch(IOException ioe) {
        	ioe.printStackTrace();
        }

   }
   public static void main(String[] args) {
      // csv file to read
      String attractions = "C:/Users/Renzel/Documents/CS245/A2/attractions.csv";
      String roads = "C:/Users/Renzel/Documents/CS245/A2/roads.csv";
      Reader.read(attractions);
      Reader.read(roads);
   }
}