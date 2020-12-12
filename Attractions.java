//hashtables for attractions
import java.util.Array;
public class Attractions<L,A> {
	// Storage for items
	private ArrayList<HashNode<L, A>> bucketArray;
	// Slots / current capacity of the ArrayList
	private int numBuckets;
	// Number of items stored in Hashtable
	private int size;
	// Beyond this ratio (items / capacity), resize
	private static final float LAMBDA = 0.75;

	//Constructor
	public Attractions(){
 		numBuckets = 11;
 		bucketArray = newArrayList<HashNode<L, A>>();
 		// Create empty chains
 		for (int i = 0; i < numBuckets; i++){
 			bucketArray.add(null);
 		}
 	}
 	//to ensure locations returns a valid array position
 	private getBucketIndex (L location) {
		// Call Java's hashCode... or another function
		int hashCode = location.hashCode();
		// Every now and again, hashCode returns a negative value
		int hashCode = Math.abs(hashCode);
		int index = hashCode % numBuckets;
		return index;
	}

	public A get (L location) {
		// Find the head of the chain
		int index = getBucketIndex(key);
		HashNode<L, A> head = bucketArray.get(index);
		// Search the chain for the item with key
		while (head != null) {
			if (head.location.equals(location)){
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public A add(loaction,attraction){
		//check if the key is exist, get list of attraction places, then update list with attarction
		
	}
	public A remove(location){
		//check for key, remove attract from list,

	}



}
class HashNode<L, A> {
	L location;//key
	A attraction;//value
	HashNode<L, A> next;
	public HashNode<L location, A attraction){
		this.location = location;
		this.attraction = attraction;
	}
}
