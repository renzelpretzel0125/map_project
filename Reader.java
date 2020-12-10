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
        	String[] tempArr;
        	while((line = br.readLine()) != null) {
        		tempArr = line.split(delimiter);
            	for(String tempStr : tempArr) {
               		System.out.print(tempStr + " ");
               		for(String temp2Str : tempArr){
               			System.out.print(temp2Str + " ");
               		}
            	}
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