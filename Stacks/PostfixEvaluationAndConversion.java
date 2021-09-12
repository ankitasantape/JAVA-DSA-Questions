package Stacks;

import java.util.Scanner;
import java.util.Stack;

/*
Sample Input: 
264*8/+3-
Sample Output:
Evaluation Value: 2
Infix: ((2+((6*4)/8))-3)
Prefix: -+2/*6483
 */
public class PostfixEvaluationAndConversion {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String exp = sc.next();
		
		solution(exp);
		sc.close();
    }

	private static void solution(String exp) {
		Stack<Integer> vst = new Stack<>();
		Stack<String> in = new Stack<>();
		Stack<String> pre = new Stack<>();
		
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				int v2 = vst.pop();
				int v1 = vst.pop();
				int res = operation(v1, v2, ch);
				vst.push(res);
				
				String pre_v2 = pre.pop();
				String pre_v1 = pre.pop();
				
				String prefix = ch + pre_v1 + pre_v2 ;
				pre.push(prefix);
				
				String in_v2 = in.pop();
				String in_v1 = in.pop();
				
				String infix = "(" + in_v1 + ch + in_v2 + ")";
				in.push(infix);
			}else {
				
				vst.push(ch - '0');
				in.push(ch + "");
				pre.push(ch + "");
			}
		}
		System.out.println("Evaluation Value: "+ vst.pop());
		System.out.println("Infix: "+ in.pop());
		System.out.println("Prefix: "+ pre.pop());
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
