package Basic;
import java.util.Scanner;
/*Terms of AP
Send Feedback
Write a program to print first x terms of the series 3N + 2 which are not multiples of 4.
Input format :
Integer x
Output format :
Terms of series (separated by space)
Constraints :
1 <= x <= 1,000
Sample Input 1 :
10
Sample Output 1 :
5 11 14 17 23 26 29 35 38 41
Sample Input 2 :
4
Sample Output 2 :
5 11 14 17
*/
public class TermsOfAP {

	public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       long x = 1,j = 1, i = 1;
       while( i <= 1000 && j <= n) {
    	   
    	   x = 3*i + 2;
    	   if(x % 4 != 0 )
    	   {
    		   System.out.print(x +" ");
    		   j++;
    	   }
    	   
    		i++; 
    	   
    	   
       }
       s.close();
	}

}
