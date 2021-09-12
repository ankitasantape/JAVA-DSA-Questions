package Stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Maximum_Rectangular_Area {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(getMaxArea(arr, n));
		}
	}
	public static long getMaxArea(long hist[], long n) 
    {
		
        //		right boundry - nearest smaller to right 
		long rb[] = new long[(int) n];  // nse index to right
		rb = nextSmallerElementOnRightIndex(n, hist);
		
//		left boundry - nearest smaller to left
		long lb[] = new long[(int) n]; // nse index to left
		lb = nearestSmallerElementOnLeftIndex(n, hist);
		
		long maxArea = 0;
		for(int i = 0; i < n; i++) {
			long width = rb[i] - lb[i] - 1;
//			System.out.println(a[i]+" "+width);
			long area = hist[i] * width;
			if( area > maxArea ) {
				maxArea = area;
			}
		}
		return maxArea;
    }
    
    private static long[] nearestSmallerElementOnLeftIndex(long n, long[] arr) {
		long nsl[] = new long[(int) n];
		nsl[0] = -1;
		
		Stack<Integer> st = new Stack<>();
		st.push(0);
		
		for(int i = 1; i < n; i++) {
//			pop all the element from the stack which is less than current element
			while( st.size() > 0 && arr[i] <= arr[st.peek()] ) {
				st.pop();
			}
//			if size of stack is zero means that element itself is greater than all the element, there is no next greater element from right to the current element
			if( st.size() == 0 ) {
				nsl[i] = -1;
			}else {
//				then the stack of peek is greater than the current element 
				nsl[i] = st.peek();
			}
//			push the current element into the stack
			st.push(i);
		}
		return nsl;
	}

	
	private static long[] nextSmallerElementOnRightIndex(long n, long[] arr) {
		long nsr[] = new long[(int) n];
		nsr[(int) (n-1)] = n;
		
		Stack<Integer> st = new Stack<>();
		st.push((int) (n-1));
		for(int i = (int) (n-2); i >= 0; i--) {
//			pop all the element from the stack which is less than current element
			while( st.size() > 0 && arr[i] <= arr[st.peek()] ) {
				st.pop();
			}
//			if size of stack is zero means that element itself is greater than all the element, there is no next greater element from right to the current element
			if( st.size() == 0 ) {
				nsr[i] = n;
			}else {
//				then the stack of peek is greater than the current element 
				nsr[i] = st.peek();
			}
//			push the current element into the stack
			st.push(i);
		}
		return nsr;
	}
	
}


