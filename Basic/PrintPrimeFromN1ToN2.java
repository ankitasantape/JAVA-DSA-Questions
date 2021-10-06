package Basic;

import java.util.Scanner;

public class PrintPrimeFromN1ToN2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		for( int i = n1; i <= n2; i++ ) {
			 int count = 0;
	            int j = 2;
	            while( j <= Math.sqrt(i) ){
	                if( i % j == 0 ){
	                   count++;
	                   break;
	                   
	                }
	                j++;
	            }
	            if( count == 0 ){
	               System.out.println(i);
	                      
	            }
		}
		sc.close();
	}

}
