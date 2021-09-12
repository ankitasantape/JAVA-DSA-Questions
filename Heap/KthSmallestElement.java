package Heap;


import java.util.PriorityQueue;
/*Kth Smallest element
Send Feedback
Given an array A of random integers and an integer k, find and return the kth largest element in the array.
Note: Try to do this question in less than O(N * logN) time.
Input Format :
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
The following contains an integer, that denotes the value of k.
Output Format :
The first and only line of output contains the kth Smallest element
Constraints :
1 <= N, Ai, k <= 10^5
Time Limit: 1 sec
Sample Input 1 :
6
9 4 8 7 11 3
2
Sample Output 1 :
4
Sample Input 2 :
8
2 6 10 11 13 4 1 20
4
Sample Output 2 :
6
Sample Input 3 :
10
87 79 67 15 68 68 58 89 85 30
10 
Sample Output 2 :

*/
public class KthSmallestElement {

	public static void main(String[] args) {
//		 int arr[] = {7, 10, 4, 3, 20, 15 };  // 3 4 7 10 15 20
//		 int k = 3;
		// o/p - 7

		int arr[] = { 7, 10, 4, 20, 15 };
		int k = 4; // o/p - 10
		System.out.println(kthSmallestElementUsingMinHeap(arr, arr.length, k));
        System.out.println(kthSmallest(arr, arr.length, k));
	}

	private static int kthSmallestElementUsingMinHeap(int arr[], int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int j = 1;
		int smallest = 0;
		while (!pq.isEmpty()) {
			if (j == k) {
				smallest = pq.remove();
				break;
			}
			pq.remove();
			++j;
		}
		return smallest;
	}
	private static int kthSmallest(int arr[], int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		for(int i = 0; i < k-2; i++ ) {
			pq.remove();
		}
		return pq.remove();
	}
}
