package Basic;
import java.util.Scanner;

/*Square Root (Integral)
Send Feedback
Given a number N, find its square root. You need to find and print only the integral part of square root of N.
For eg. if number given is 18, answer is 4.
Input format :
Integer N
Output Format :
Square root of N (integer part only)
Constraints :
0 <= N <= 10^8
Sample Input 1 :
10
Sample Output 1 :
3
Sample Input 2 :
4
Sample Output 2 :
2
*/
public class SquareRootIntegral {

	public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int sr = (int)Math.sqrt(n);
         
         int res = 0;
        
        	 res = sr * sr;
        	 if (res == n)
        	 {
        		 System.out.println(sr);
        		
        	 
        	 } else if(res < n) {
        		 System.out.println(sr);
        	     
        	 }
        		 
        	 
        
         sc.close();
	}

}
