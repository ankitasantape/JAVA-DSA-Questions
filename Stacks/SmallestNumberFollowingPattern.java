package Stacks;

import java.util.Scanner;
import java.util.Stack;
/*
Sample Input:
 ddidddid
Sample Output:
 321765498
*/
public class SmallestNumberFollowingPattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		smallestNumber(str);
		sc.close();
	}

	private static void smallestNumber(String str) {
		Stack<Integer> st = new Stack<>();
		int num = 1;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if ( ch == 'd' ) {
				st.push(num);
				num++;
			}else {
				st.push(num);
				num++;
				
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		}
		st.push(num);
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
		
	}

}
