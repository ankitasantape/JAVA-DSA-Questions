package Basic;
import java.util.Scanner;
/*Reverse of a number
Send Feedback
Write a program to generate the reverse of a given number N. Print the corresponding reverse number.
Note : If a number has trailing zeros, then its reverse will not include them. For e.g., reverse of 10400 will be 401 instead of 00401.


Input format :
Integer N
Output format :
Corresponding reverse number
Constraints:
0 <= N < 10^8
Sample Input 1 :
1234
Sample Output 1 :
4321
Sample Input 2 :
1980
Sample Output 2 :
891
*/
public class ReverseNumber {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int num = 0,rem = 0;
//        num = n;
//        while(num != 0)
//        {
//        	rem = num % 10;
//        	
//        	System.out.print(rem);
//        	num = num / 10;
//        	
//        }
        int  reverse = 0;

        System.out.println("Enter an integer to reverse");
        
        while(n != 0)
        {
          reverse = reverse * 10;
          reverse = reverse + n%10;
          n = n/10;
        }

        System.out.println("Reverse of the number is " + reverse);
      
        sc.close();
	}

}
