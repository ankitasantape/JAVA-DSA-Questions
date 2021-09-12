package Stacks;

import java.util.Scanner;
import java.util.Stack;
/*
Sample Input :
9
2 5 9 3 1 12 6 8 7
Sample Output :
-1 2 5 2 -1 1 1 6 6 
*/
public class NextSmallerElementOnTheLeft {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
//		Approach 1
		int nge[] = nextSmallerElement(n, arr);
		int ngei[] = nearestSmallerElementOnLeftIndex(n, arr);
		for(int i = 0; i < n; i++) {
			System.out.println( "Index : "+ ngei[i] + " Element : " +nge[i] + " ");
		}
        sc.close();
	}

	private static int[] nextSmallerElement(int n, int[] arr) {
		int nge[] = new int[n];
		nge[0] = -1;
		
		Stack<Integer> st = new Stack<>();
		st.push(arr[0]);
		for(int i = 1; i < n; i++) {
//			pop all the element from the stack which is less than current element
			while( st.size() > 0 && arr[i] <= st.peek() ) {
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
	
	private static int[] nearestSmallerElementOnLeftIndex(int n, int[] arr) {
		int nge[] = new int[n];
		nge[0] = -1;
		
		Stack<Integer> st = new Stack<>();
		st.push(0);
		
		for(int i = 1; i < n; i++) {
//			pop all the element from the stack which is less than current element
			while( st.size() > 0 && arr[i] <= arr[st.peek()] ) {
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
			st.push(i);
		}
		return nge;
	}


}
