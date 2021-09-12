package Heap;

import java.util.PriorityQueue;

public class SortKSorted {
    
	public static void sortKSorted( int arr[], int k ) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i = 0;
		for( ; i < k; i++ ) {
			pq.add( arr[i] );
		}
		
		for( ; i < arr.length; i++ ) {
			pq.add(arr[i]);
			arr[i - k] = pq.remove();
		}
		
		for( int j = arr.length - k; j < arr.length; j++ ) {
			arr[j] = pq.remove();
		} 
	}
	public static void main(String[] args) {
	       
		int arr[] = {2,4,1,9,6,8};
		int k = 3;
		
		sortKSorted(arr,k);
		
		for( int i : arr ) {
			System.out.print( i + " ");
		}
	}

}
