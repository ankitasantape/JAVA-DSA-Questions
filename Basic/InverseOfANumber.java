package Basic;

import java.util.*;
public class InverseOfANumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // Input : 21453  Output : 23154
		
		int p = 1;
		int inverse = 0;
		while( n > 0 ) {
			int d = n % 10;
			inverse += p * (int)Math.pow(10, d-1);
			n = n / 10;
			p++;
		}
		System.out.println(inverse);
		sc.close();
	}

}
