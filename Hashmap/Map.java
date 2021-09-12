package Hashmap;

import java.util.ArrayList;

public class Map<K, V > {

	ArrayList<MapNode<K, V >> bucketArray;
	// size of hashMap
	int size;
	// size of bucketArray is the total number of entries in the bucketArray
	int numBuckets;
	
	public Map() {
        // initially, set number of bucket as 5 means the size of ArrayList becoz we are treating this arraylist as array
		numBuckets = 5;
		// create new arrayList
		bucketArray = new ArrayList<>();
		// initially, add null into buckets array of size 5
		for (int i = 0; i < numBuckets; i++) {

			bucketArray.add(null);
		}
		// buckets[5] = { null, null, null, null, null };
	}
	
	private int getBucketIndex(K key) {
        // when user enter the key it will first goes through the hash function, hash function will return the hashCode
		int hashCode = key.hashCode(); // a unique hashCode will be provided by hashCode()
		
		return hashCode % numBuckets;
	}
	
	public int size() {
		 return size;
	}
	
	public V getValue(K key) {
		int bucketIndex = getBucketIndex( key );
		MapNode<K, V> head = bucketArray.get(bucketIndex);
		while( head != null ) {
			
			if(head.key.equals(key)) {
				
			    return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex( key );
		MapNode<K, V> head = bucketArray.get(bucketIndex);
		MapNode<K, V> prev = null;
		while( head != null ) {
			
			if(head.key.equals(key)) {
				size--;
				if( prev == null ) {
					
					bucketArray.set(bucketIndex, head.next);
				} else {
					prev.next = head.next;
				}
			    return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
	
	public void put( K key, V value ) {
	    
		int bucketIndex = getBucketIndex( key );
		MapNode<K, V> head = bucketArray.get(bucketIndex);
		while( head != null ) {
			
			if(head.key.equals(key)) {
				
				head.value = value;
				return;
			}
			head = head.next;
		}
		//If element not exists
		head = bucketArray.get(bucketIndex);
		MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);
		size++;
		newElementNode.next = head;
		bucketArray.set(bucketIndex, newElementNode);
		double loadfactor = (1.0 * size) / numBuckets;
		if( loadfactor > 0.7 ) {
			rehash();
		}
	}

	public double loadfactor( ) {
		return (1.0 * size) / numBuckets; 
	}
	
	private void rehash() {
		//System.out.println(" Rehashing : buckets - "+ numBuckets + " size - "+ size);
		ArrayList<MapNode<K,V>> temp = bucketArray;
		bucketArray = new ArrayList<>();
		for( int i = 0; i < 2*numBuckets; i++ ) {
			bucketArray.add( null );
		}
		size = 0;
		numBuckets *= 2;
		for( int i = 0; i < temp.size(); i++ ) {
			MapNode<K,V> head = temp.get(i);
			while( head != null ) {
				K key = head.key;
				V value = head.value;
				put( key, value );
				head = head.next;
			}
		}
	}
} 
