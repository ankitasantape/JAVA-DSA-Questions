package Basic;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
		long pv = 1, rem = 0, ans = 0;// pv - previous value
		while(n != 0)
		{
			rem = n % 2;
			ans = ans + rem * pv;
			pv = pv * 10;
			n = n / 2;
		}
		System.out.println(ans);
        
        
        sc.close();
	}

}
