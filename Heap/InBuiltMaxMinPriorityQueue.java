package Heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MinPQComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer arg0, Integer arg1) {
		if( arg0 < arg1 ) {
			
			return -1;
		
		} else if( arg0 > arg1 ) {
		
			return 1;
		}
		return 0;
	}
	
}
class MaxPQComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer arg0, Integer arg1) {
		if( arg0 < arg1 ) {
			
			return 1;
		
		} else if( arg0 > arg1 ) {
		
			return -1;
		}
		return 0;
	}
	
}

class MinStringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		if( o1.length() < o2.length() ) {
			return -1;
		} else if( o1.length() > o2.length() ) {
			return 1;
		}
		return 0;
	}
	
}
public class InBuiltMaxMinPriorityQueue {
	
	public static void main(String[] args) {
		
//		MaxPQComparator max = new MaxPQComparator();
		//Bydefault elements are arranged in the form of minPriorityQueue
		//PriorityQueue<Integer> pq = new PriorityQueue<>(max);
		
		PriorityQueue<Integer> pq = new PriorityQueue<> ( Collections.reverseOrder()); 
		int arr[] = {9,1,0,4,7,3};
		for( int i = 0; i < arr.length; i++ ) {
			pq.add(arr[i]);
		}
		
		while( !pq.isEmpty() ) {
			System.out.print(pq.remove() + " ");
		}
		System.out.println();
		
        MinStringLengthComparator strlencom = new MinStringLengthComparator();
        PriorityQueue<String> strpq = new PriorityQueue<> ( strlencom ); 
		
		//PriorityQueue<String> strpq = new PriorityQueue<> ( Collections.reverseOrder()); 
		String strarr[] = {"this", "at", "a", "their", "queue"};
		for( int i = 0; i < strarr.length; i++ ) {
			strpq.add(strarr[i]);
		}
		
		while( !strpq.isEmpty() ) {
			System.out.print(strpq.remove() + " ");
		}
		
	}

}
