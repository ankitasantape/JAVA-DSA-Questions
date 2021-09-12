package Function;

import java.util.Scanner;

public class MemberOfFibonacciSeries {

	public static boolean checkMember(int n)
	{
	    int a = 0, b = 1 , c = 0;
	    while( a < n)
	    {
	    	c = a + b;
	    	a = b; 
	    	b = c;
	    
	    if( a == n)
	    {
	    	return true;
	    }
	    }
	    return false;
	}
	public static void main(String[] args) {
     Scanner s = new Scanner(System.in);
     int n = s.nextInt();
     boolean ans = checkMember(n);
     System.out.println(ans);
		s.close();
	}

}
