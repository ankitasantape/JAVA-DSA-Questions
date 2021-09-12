package Function;

import java.util.Scanner;

public class NcR {
     public static int factorial(int n)
    {
    	int ans = 1;
    	for(int i = 1; i <= n; i++)
    	{
    		ans = ans * i;
    	}
    	return ans;
    } 
	
	 public static int ncr(int n, int r)
	    {
	    	int num = factorial(n);
	    	
	    	int d1 = factorial(r);
	    	
	    	int d2 = factorial(n - r);
	    	
	    	int ans = num / (d1 * d2);
	    	
	    	return ans;
	    	
	    }
    
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int c = s.nextInt();
//		int numerator = factorial(n);
//		for(int i = 1; i <= n; i++)
//		{
//			numerator = numerator * i;
//		}
//		int denomenator1 = factorial(c);
//		for(int i = 1; i <= c; i++)
//		{
//			denomenator1 = denomenator1 * i;
//		}
//		int denomenator2 = factorial(n - c);
//		for(int i = 1; i <= n - c; i++)
//		{
//			denomenator2 = denomenator2 * i;
//		}
//		int ans = numerator / (denomenator1 * denomenator2);
//		System.out.println(ans);
		
		int output = ncr(n, c);
		System.out.println(output);
		s.close();
	}

}
