package Stacks;

import java.util.Scanner;
import java.util.Stack;
/*
Sample Input :   
9
2 5 9 3 1 12 6 8 7
 
Sample Output :
1 3 3 1 -1 6 -1 -1 -1 
*/
public class NextSmallerElementOnTheRight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int nge[] = nextSmallerElement(n, arr);
		int ngei[] = nextSmallerElementOnRightIndex(n, arr);
		for(int i = 0; i < n; i++) {
			System.out.println("At index "+ngei[i] + " the element " +nge[i] + " ");
		}
		
		
//		for(int i = 0; i < n; i++) {
//			System.out.print(ngei[i] + " ");
//		}
        sc.close();
	}

	private static int[] nextSmallerElement(int n, int[] arr) {
		int nge[] = new int[n];
		nge[n-1] = -1;
		
		Stack<Integer> st = new Stack<>();
		for(int i = n-2; i >= 0; i--) {
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
	
	private static int[] nextSmallerElementOnRightIndex(int n, int[] arr) {
		int nge[] = new int[n];
		nge[n-1] = n;
		
		Stack<Integer> st = new Stack<>();
		st.push(n-1);
		for(int i = n-2; i >= 0; i--) {
//			pop all the element from the stack which is less than current element
			while( st.size() > 0 && arr[i] <= arr[st.peek()] ) {
				st.pop();
			}
//			if size of stack is zero means that element itself is greater than all the element, there is no next greater element from right to the current element
			if( st.size() == 0 ) {
				nge[i] = n;
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
