package Stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/*
Sample Input:
6
22 28
1 8
25 27
14 19
27 30
5 12
Sample Output:
1 12 
14 19
22 30
 */
public class MergeOverlappingInterval {
    public static class Pair implements Comparable<Pair>{
    	int start, end;
    	
    	Pair(int start, int end){
    		this.start = start;
    		this.end = start;
    	}
//    	if this > other return 1
//    	if this = other return 0
//    	if this < other return -1
    	public int compareTo(Pair other) {
    		if(this.start != other.start) {
    			return this.start - other.start;
    		}else {
    		    return this.end - other.end;	
    		}
    	}
    	
    }
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][2];
		for (int i = 0; i < n; i++ ) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		solution(n, arr);
		sc.close();
	}

	private static void solution(int n, int[][] arr) {
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++) {
		    pairs[i] = new Pair(arr[i][0], arr[i][1]);	
		}
//		Sort objects array
		Arrays.sort(pairs);
		
		Stack<Pair> st = new Stack<>();
		
		for (int i = 0; i < pairs.length; i++) {
//			agr pehla banda hai to directly push krdo
			if (i == 0) {
				st.push(pairs[i]);
			}else {
				if (pairs[i].start > st.peek().end) {
			        st.push(pairs[i]);
			   }else {
				    st.peek().end = Math.max( pairs[i].end, st.peek().end);
			   }
		   }
	   }
		
	   Stack<Pair> rs = new Stack<>();
	   while ( st.size() > 0 ) {
		   rs.push(st.pop());
	   }
	   
	   while ( rs.size() > 0 ) {
		   Pair p = rs.pop();
		   System.out.println(p.start + " " + p.end);
	   }
	}
}
