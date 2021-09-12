package Stacks;

import java.util.Scanner;
import java.util.Stack;
/*
Sample Input:
  2+(5-3*6/2)
Sample Output:
  -2
*/
public class InfixEvaluation {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(solution(str));
		sc.close();
	}

	private static int solution(String str) {
		Stack<Integer> opnds = new Stack<>();
		Stack<Character> optors = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if( ch == '(' ) {
				optors.push(ch);
			}else if (Character.isDigit(ch)) {
				opnds.push(ch - '0');
			}else if ( ch == ')' ) {
				while (optors.peek() != '(' ) {
					int v2 = opnds.pop();
					int v1 = opnds.pop();
					int res = operation(v1, v2, optors.pop() );
					
					opnds.push(res);
					
		        }
				optors.pop();
			}else if (ch == '+' || ch == '-' || ch == '/' || ch == '*'){
				while(optors.size() > 0 && optors.peek() != '(' 
						&& precedence(ch) <= precedence(optors.peek()) ) {
					int v2 = opnds.pop();
					int v1 = opnds.pop();
					int res = operation(v1, v2, optors.pop() );
					
					opnds.push(res);
				}
				
				optors.push(ch);
			}
			
		}
		while(optors.size() != 0) {
			int v2 = opnds.pop();
			int v1 = opnds.pop();
			int res = operation(v1, v2, optors.pop() );
			
			opnds.push(res);
		}
		return opnds.peek();
	}
	
    private static int precedence(char optor) {
		if(optor == '+') {
			return 1;
		}else if(optor == '-') {
			return 1;
		}else if(optor == '*') {
			return 2;
		}else {
			return 2;
		}
	}

    private static int operation(int v1, int v2, char optor) {
    	if(optor == '+') {
			return v1 + v2;
		}else if(optor == '-') {
			return v1 - v2;
		}else if(optor == '*') {
			return v1 * v2;
		}else {
			return v1 / v2;
		} 
    }
	
    
}
