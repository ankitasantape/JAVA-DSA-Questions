package Stacks;

import java.util.Scanner;
import java.util.Stack;

/*
Sample Input : 
9
2 5 9 3 1 12 6 8 7
Sample Output : 
5 9 12 12 12 -1 8 -1 -1
*/
public class NextGreaterElementOnTheRight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
//		Approach 1
		int nge[] = nextGreaterElement(n, arr);
		for(int i = 0; i < n; i++) {
			System.out.print(nge[i] + " ");
		}
		System.out.println();
//		Approach 2
		int nge2[] = nextGreaterElement2(n, arr);
		for(int i = 0; i < n; i++) {
			System.out.print(nge2[i] + " ");
		}
		sc.close();
	}

	private static int[] nextGreaterElement2(int n, int[] arr) {
		int nge[] = new int[n];
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int i = 1; i < n; i++ ) {
			while( st.size() > 0 && arr[i] > arr[st.peek()]) {
				int pos = st.peek();
				nge[pos] = arr[i];
				st.pop();
			}
			st.push(i);
		}
		while( st.size() > 0 ) {
			int pos = st.peek();
			nge[pos] = -1;
			st.pop();
		}
		return nge;
	}

	private static int[] nextGreaterElement(int n, int[] arr) {
		int nge[] = new int[n];
		nge[n-1] = -1;
		
		Stack<Integer> st = new Stack<>();
		for(int i = n-2; i >= 0; i--) {
//			pop all the element from the stack which is less than current element
			while( st.size() > 0 && arr[i] >= st.peek() ) {
				st.pop();
			}
//			if size of stack is zero means that element itself is greater than all the element, there is no next greater element from right to the current element
			if( st.size() == 0 ) {
				nge[i] = -1;
			}else {
//				then the stack of peek is greater than the current element 
				nge[i] = st.peek();
			}
//			push the current element into the stack
			st.push(arr[i]);
		}
		return nge;
	}

}
