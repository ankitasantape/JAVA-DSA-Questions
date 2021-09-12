package Recursion;

public class Factorial {
    
	public static int fact(int n)
	{
		/*      Base Case
		        if(n == 0)  {
		            return 1;
		         }
		*/
		
		if(n >= 1)
		{
			int small = fact(n-1);
			return n * small;
		}
		return 1;
	}
	public static void main(String[] args) {
        int f = fact(5);
        System.out.println(f);
	}

}
