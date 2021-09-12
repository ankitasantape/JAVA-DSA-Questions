package Recursion;

public class Sum {
    public static int sum(int n)
    {
    	if(n == 0) {
    		return 1;
    	}
    	
    	return n + sum(n-1);
    }
	public static void main(String[] args) {
		//Sum of N natural number upto N
           int ans  = sum(5);
           System.out.println(ans);
           
	}

}
