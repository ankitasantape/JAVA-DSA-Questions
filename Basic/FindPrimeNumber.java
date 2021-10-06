package Basic;

import java.util.Scanner;

public class FindPrimeNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();
        while(t > 0){
            int n = scn.nextInt();
            int count = 0;
            int i = 2;
            while( i <= Math.sqrt(n) ){
                if( n % i == 0 ){
                   count++;
                   break;
                   
                }
                i++;
            }
            if( count == 0 ){
               System.out.println("prime");
                      
            }else{
               System.out.println("not prime");
                      
            }
            t--;
        }
        
        scn.close();
	}

}
