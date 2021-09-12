package Recursion;

public class FibonacciNumber {
    public static int fibonacciNumber(int n)
    {
//    	if( n == 0)
//    	{
//    		return 0;
//    	} 
//    	else if( n == 1 )
//    	{
//    		return 1;
//    	}
    	
    	if(n == 0 || n == 1)
    	{
    		return n;
    	}
    	int ans =  fibonacciNumber(n - 1) + fibonacciNumber(n-2);
    	return ans;
    }
	
	public static void main(String[] args) {
         int n = 7;
         int ans = fibonacciNumber(n);
         System.out.println(ans);
	}

}
