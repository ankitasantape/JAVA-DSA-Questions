package Basic;

import java.util.Scanner;

public class DigitsOfANumber {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int no = n;
		int count = 0;
		while( n > 0 ) {
			n = n / 10;
			count++;
		}
		
		int divisor = (int)Math.pow(10, count-1 ); 
		while( divisor > 0 ) {
			int quotient = no / divisor ;
			System.out.println(quotient);
			no = no % divisor;
			divisor = divisor / 10;
		}
//        System.out.println(divisor);
//		while( no > 0 ) {
//			int quotient = no / divisor ;
//			System.out.println(quotient);
//			no = no % divisor;
//			divisor = divisor / 10;
//		}
        sc.close();
	}

}
