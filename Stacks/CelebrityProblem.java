package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {

	public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
	     int n = sc.nextInt();
	     int m = sc.nextInt();
	     int arr[][] = new int[n][m];
	     for (int i = 0; i < n; i++) {
	    	 for (int j = 0; j < m; j++) {
	    		 arr[i][j] = sc.nextInt();
	    	 }
	     }
	     System.out.println(findCelebrity(n, m, arr));
	     sc.close();
	}

	private static int findCelebrity(int n, int m, int[][] arr) {
		
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			st.push(i);
		}
		
		while (st.size() >= 2) {
			int i = st.pop();
			int j = st.pop();
			
//			if i does not know j then j never be a celebrity 
			if (arr[i][j] == 0) {
				st.push(i);
			} else {     //			if i knows j then i never be a celebrity becoz celebrity knows nobody
				st.push(j);
			}
//			
		}
//		Partial Potential celebrity
		int pot = st.pop();
		for (int i = 0; i < n; i++) {
//			except 1 cell ko chhodake sbko check krna hai pot ke row n column me
			if (i != pot) {
				if( arr[pot][i] == 1 || arr[i][pot] == 0 ) {
					return -1;
				}
			}
		}
		return pot;
	}

}
