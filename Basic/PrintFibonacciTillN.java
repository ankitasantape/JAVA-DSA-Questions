package Basic;

import java.util.Scanner;

public class PrintFibonacciTillN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f0 = 0, f1 = 1,fib = 0;
        for( int i = 2; i <= n+1; i++ ) {
        	System.out.println(f0);
            fib = f0 + f1;
        	f0 = f1;
        	f1 = fib;
        }
        
        sc.close();
	}

}
