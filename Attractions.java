//hashtables for attractions
import java.util.Array;
public class Attractions{
	public class Hashtable<K, V> {
	// Storage for items
	private ArrayList<HashNode<K, V>> bucketArray;
	// Slots / current capacity of the ArrayList
	private int numBuckets;
	// Number of items stored in Hashtable
	private int size;
	// Beyond this ratio (items / capacity), resize
	private static final float LAMBDA = 0.75;

	public Hashtable(){
 		numBuckets = 11;
 		bucketArray = newArrayList<HashNode<K, V>>();
 		// Create empty chains
 		for (int i = 0; i < numBuckets; i++){
 			bucketArray.add(null);
 		}
 	}
 	private getBucketIndex (K key) {
		// Call Java's hashCode... or another function
		int hashCode = key.hashCode();
		// Every now and again, hashCode returns a negative value
		int hashCode = Math.abs(hashCode);
		int index = hashCode % numBuckets;
		return index;
	}

	public V get (K key) {
		// Find the head of the chain
		int index = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(index);
		// Search the chain for the item with key
		while (head != null) {
			if (head.key.equals(key)){
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public V add(key,value){

	}
	public V remove(key){
		
	}



}
class HashNode<K, V> {
	K key;
	V value;
	HashNode<K, V> next;
	public HashNode<K key, V value){
		this.key = key;
		this.value = value;
	}
}
