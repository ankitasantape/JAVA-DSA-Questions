package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
/*Code : K largest elements
Send Feedback
You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(nlogk) and space complexity should be not more than O(k).
Order of elements in the output is not important.
Input Format :
Line 1 : Size of array (n)
Line 2 : Array elements (separated by space)
Line 3 : Integer k
Output Format :
k largest elements
Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output :
12
16
20
25
*/
public class KLargestElement {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		
		   PriorityQueue<Integer> pq = new PriorityQueue<>();
		   int i = 0;
		   for( ; i < k; i++ ) {
			   pq.add( input[i] );
		   }
		   
//		   for( ; i < input.length; i++ ) {
//			   if( pq.peek() < input[i] ) {
//				   pq.remove();
//				   pq.add(input[i]);
//			   }
//		   }
		   
		   for( ; i < input.length; i++ ) {
			   int min = pq.element();
			   if( min < input[i] ) {
				   pq.remove();
				   pq.add( input[i] );
			   }
		   }
		   
		  ArrayList<Integer> largest = new ArrayList<>();
		  while( !pq.isEmpty() ) {
			   largest.add(pq.remove());
		  }
		   
		  return largest;
	}
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}

}
