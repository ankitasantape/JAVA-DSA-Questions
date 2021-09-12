package Stacks;

import java.util.Scanner;
import java.util.Stack;
/*
Sample Input:
2+6*4/8-3

Sample Output:
Postfix: 264*8/+3-
Prefix: -+2/*6483*/
public class InfixConversion {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str = sc.next();
		
		solution(str);
		sc.close();
	}

	private static void solution(String str) {
		Stack<String> post = new Stack<>();
		Stack<String> pre = new Stack<>();
		Stack<Character> optors = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if( ch == '(' ) {
				optors.push(ch);
			}else if ((ch >= '0' && ch <= '9' ) || (ch >= 'a' && ch <= 'z' ) || (ch >= 'A' && ch <= 'Z' ) ) {
				post.push(ch + "");
				pre.push(ch + "");
			}else if ( ch == ')' ) {
				while (optors.peek() != '(' ) {
					String pre_v2 = pre.pop();
					String pre_v1 = pre.pop();
					char op = optors.pop();
					String prefix = op + pre_v1 + pre_v2 ;
					pre.push(prefix);
					
					String post_v2 = post.pop();
					String post_v1 = post.pop();
					String postfix = post_v1 + post_v2 + op;
					post.push(postfix);
				}
				optors.pop();
			
			}else if (ch == '+' || ch == '-' || ch == '/' || ch == '*'){
				while(optors.size() > 0 && optors.peek() != '(' 
						&& precedence(ch) <= precedence(optors.peek()) ) {
					String pre_v2 = pre.pop();
					String pre_v1 = pre.pop();
					char op = optors.pop();
					String prefix = op + pre_v1 + pre_v2 ;
					pre.push(prefix);
					
					String post_v2 = post.pop();
					String post_v1 = post.pop();
					String postfix = post_v1 + post_v2 + op;
					post.push(postfix);
				}
				optors.push(ch);
			}
			
		}
		while(optors.size() > 0) {
			String pre_v2 = pre.pop();
			String pre_v1 = pre.pop();
			char op = optors.pop();
			String prefix = op + pre_v1 + pre_v2 ;
			pre.push(prefix);
			
			String post_v2 = post.pop();
			String post_v1 = post.pop();
			String postfix = post_v1 + post_v2 + op;
			post.push(postfix);
		}
		System.out.println("Postfix: " + post.peek());
		System.out.println("Prefix: " + pre.peek());
		
	}
	
    private static int precedence(char optor) {
		if(optor == '+' || optor == '-' ) {
			return 1;
		
		}else if(optor == '*' || optor == '/') {
			return 2;
		}else {
			return 0;
		}
	}
}
