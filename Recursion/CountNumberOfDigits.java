package Recursion;

public class CountNumberOfDigits {
	public static int count(int n){
		//System.out.print(n + " ");
		if(n == 0){
			return 0;
		}
		int smallAns = count(n / 10);
		//System.out.print(smallAns + " ");
		return smallAns + 1 ;
	}
	public static void main(String[] args) {
       int n = 600;
       int ans = count(n);
       System.out.println(ans);
	}

}
