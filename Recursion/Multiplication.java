package Recursion;

public class Multiplication {
	public static int multiplyTwoIntegers(int m, int n){
	     if(n == 0 )
	     {
	    	 return 0;
	     }
	     return m * n;
	}
	public static void main(String[] args) {
          int a = 3;
          int b = 0;
          int ans = multiplyTwoIntegers(a, b);
          System.out.println(ans);
	}

}
