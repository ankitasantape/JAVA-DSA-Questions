package Stacks;

import java.util.Scanner;
import java.util.Stack;

/*
Sample Input:
17
2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6
4
Sample Output:
9 9 8 12 12 14 14 32 32 32 32 19 19 19 
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		findLargestFromSlidingWindow(n,arr,k);
		sc.close();
	}

	private static void findLargestFromSlidingWindow(int n, int[] arr, int k) {
		
//		find next greater element's index and store it in reverse order form right side
		Stack<Integer> st = new Stack<>();
		
//		store the next greater element
		int nge[] = new int[n];
		
//		initially, insert the last index of arr element into stack
		st.push(n-1);
		
//		last element ka next greater element nhi hota so hum yha pe arr.length ko last index add kr rhe to avoid exception
		nge[n - 1] = n;
		
		
		for (int i=n-2 ; i>=0 ; i-- ) {
//			Strategy - pop() ---> add() ---> push()  -a+
//			jb tak next greater element nhi milata tb tk pop() krte jayenge
			while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
				st.pop();
			}

			if (st.size() == 0) {
				nge[i] = arr.length;
			}else {
				nge[i] = st.peek();
			}
			
			st.push(i);
		}
		
//		Actual Code
		int j = 0;
		for (int i=0; i<=n-k; i++ ) {
			if (j < i ) {
				j = i;
			}
//			apply loop to find the maximum of window starting at j
			while (nge[j] < i+k) {
				j = nge[j];
			}
			
			System.out.print(arr[j] +" ");
		}
		
	}

}
