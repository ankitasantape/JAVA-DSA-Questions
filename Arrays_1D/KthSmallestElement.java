package Arrays_1D;

import java.util.Arrays;
import java.util.PriorityQueue;

/*Kth smallest element 
Medium Accuracy: 41.3% Submissions: 9155 Points: 4
Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. 
It is given that all array elements are distinct.

Expected Time Complexity: O(n)

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. 
First line of each testcase contains an integer N denoting size of the array. 
Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:
For each testcase, in a newline, print the kth smallest element.

Yout Task:
Complete kthSmallest and return the kth smallest element.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4

Output:
7
15

Explanation:
Testcase 1: 3rd smallest element in the given array is 7.
Testcase 2: 4th smallest element in the given array is 15.
 */
public class KthSmallestElement {

	public static void main(String[] args) {
		  // int arr[] = {7, 10, 4, 3, 20, 15 };
		  // int k = 3;
		   
		   int arr[] =  { 7, 10, 4, 20, 15 };
		   int k = 4;
		   kthSmallestElement(arr, arr.length , k);
		  System.out.println( kthSmallestElementUsingMinHeap( arr, arr.length, k ) );
	}

	/* Time Complexity - O( N log N )*/
	private static void kthSmallestElement(int[] arr, int length, int k) {
		
		Arrays.sort( arr );
		
		System.out.println( arr[k - 1] );
		
	}
	
	private static int kthSmallestElementUsingMinHeap( int arr[], int n, int k ) {
		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		   for( int i = 0; i < arr.length; i++ ) {
			   pq.add( arr[i]);
		   }
		   int j = 1;
		   int smallest = 0;
		   while( !pq.isEmpty() ) {
			   if( j == k ) {
				  smallest = pq.remove(); 
				  break;
			   }
			   pq.remove();
			   j++;
		   }
       return smallest;
	}

}
