package Stacks;

import java.util.Scanner;
import java.util.Stack;
/*
Sample Input :
7
6 2 5 4 5 1 6
Sample Output :
12

Sample Input
7
7
8
8
7
7
9
2
Sample Output
42
*/
public class LargestAreaHistogram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
//		right boundry - nearest smaller to right 
		int rb[] = new int[n];  // nse index to right
		rb = nextSmallerElementOnRightIndex(n, arr);
		
//		left boundry - nearest smaller to left
		int lb[] = new int[n]; // nse index to left
		lb = nearestSmallerElementOnLeftIndex(n, arr);
		
		int maxArea = 0;
		for(int i = 0; i < n; i++) {
			int width = rb[i] - lb[i] - 1;
			int area = arr[i] * width;
			if( area > maxArea ) {
				maxArea = area;
			}
		}
		System.out.println(maxArea);
		sc.close();
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
