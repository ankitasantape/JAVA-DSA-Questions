package Basic;


import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int decimal = 0, i = 0;
        while(n != 0)
        {
        	decimal = (int) (decimal +( n % 10 )*(Math.pow(2, i)));
        	n = n / 10;
        	i++;
        }
        System.out.println(decimal);
        sc.close();
	}

}

