package Stacks;

import java.util.Scanner;
import java.util.Stack;

/*
Sample Input:
-+2/*6483

Sample Output:
Value: 2
Infix Expression: ((2+((6*4)/8))-3)
Postfix Expression: 264*8/+3-

*/

public class PrefixEvaluationAndConversion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp = sc.next();
		prefixConversion(exp);
		sc.close();
	}

	private static void prefixConversion(String exp) {
		Stack<Integer> operand = new Stack<Integer>(); 
	     Stack<String> infix = new Stack<String>(); 
	     Stack<String> postfix = new Stack<String>(); 
		    
	 		for (int i = exp.length()-1; i >=0 ; i--) {
	 			char ch = exp.charAt(i);
	 			
	 			if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
	 				int v1 = operand.pop();
	 				int v2 = operand.pop();
	 				int vr = operation(v1, v2, ch);
	 				operand.push(vr);
	 				
	 				String post_v1 = postfix.pop();
	 				String post_v2 = postfix.pop();
	 				String post_res = post_v1 + post_v2 + ch;
	 				postfix.push(post_res);
	 				
	 				String in_v1 = infix.pop();
	 				String in_v2 = infix.pop();
	 				String in_res = "(" +in_v1 + ch + in_v2+ ")" ;
	 				infix.push(in_res);
	 				
	 			}else {
	 				operand.push(ch - '0');
	 				postfix.push(ch + "");
	 				infix.push(ch +"");
	 			}
	 		}
	 		System.out.println("Value: " + operand.pop());
	 		System.out.println("Infix Expression: " + infix.pop());
	 		System.out.println("Postfix Expression: " + postfix.pop());

	     
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
