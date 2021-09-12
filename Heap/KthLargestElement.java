package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*Kth largest element
Send Feedback
Given an array A of random integers and an integer k, find and return the kth largest element in the array.
Note: Try to do this question in less than O(N * logN) time.
Input Format :
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
The following contains an integer, that denotes the value of k.
Output Format :
The first and only line of output contains the kth largest element
Constraints :
1 <= N, Ai, k <= 10^5
Time Limit: 1 sec
Sample Input 1 :
6
9 4 8 7 11 3
2
Sample Output 1 :
9
Sample Input 2 :
8
2 6 10 11 13 4 1 20
4
Sample Output 2 :
10
Sample Input 3 :
10
87 79 67 15 68 68 58 89 85 30
10 
Sample Output 2 :
15
*/
public class KthLargestElement {
	public static int kthLargest(int n, int[] input, int k) {
		   // By default MinHeap and to make it MaxHeap do the reverse of MinHeap  
		   PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		   for( int i = 0; i < input.length; i++ ) {
			   pq.add(input[i]);
		   }
		   int j = 1;
		   int largest = 0;
		   while( !pq.isEmpty() ) {
			   if( j == k ) {
				  largest = pq.remove(); 
				  break;
			   }
			   pq.remove();
			   j++;
		   }
         return largest;
	}
//	public static int kthLargest(int n, int[] input, int k) {
//	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(kthLargest(n, input, k));
		System.exit(0);
	}
}
