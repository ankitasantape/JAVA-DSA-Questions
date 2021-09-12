package Stacks;

import java.util.Scanner;
import java.util.Stack;
/*
 Sample Input 1: ((a+b)
 Sample Output 1: false
 Sample Input 2: (a+b))
 Sample Output 2: false
 Sample Input 3: [(a+b)+{(c+d)*(e/f)}]
 Sample Output 3: true
 Sample Input 4: [(a+b)+{(c+d)*(e/f)]}
 Sample Output 4: false
 Sample Input 5: [(a+b)+{(c+d)*(e/f)}
 Sample Output 5: false
 Sample Input 6: ([(a+b)+{(c+d)*(e/f)]
 Sample Output 6: false
 */
public class BalancedBracket {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str = sc.next();
		System.out.println(BalancedBrackets(str));
		sc.close();
    }

	private static boolean BalancedBrackets(String str) {
        Stack<Character> st = new Stack<>();
		boolean ans = false;
		for(int i = 0; i < str.length(); i++) {
			
			if( str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' ) {
				st.push(str.charAt(i));
			
			}else if(str.charAt(i) == ')') {
				ans = handleClosing(st, '(');
                if( ans == false ) {
                	return false;
                }
				
			}else if(str.charAt(i) == '}' ){
				ans = handleClosing(st, '{');
				 if( ans == false ) {
	                	return false;
	             }
			
			}else if(str.charAt(i) == ']' ){
				ans = handleClosing(st, '[');
				 if( ans == false ) {
	                	return false;
	             }
			}
		}
		if( st.size() == 0 ) {
			return true;
		}else {
			return false;
		}
		
    }

	private static boolean handleClosing(Stack<Character> st, char corresOpnCh) {
		if( st.isEmpty() ) {
			return false;
		}else if(st.peek() != corresOpnCh ) {
			return false;
		}else {
			st.pop();
			return true;
		}
	}
}
