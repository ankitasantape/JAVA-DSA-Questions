package Recursion;

public class SumOfDigits {
	public static int sumOfDigits(int input){
		if(input == 0){
			return 0;
		}
		int smallAns = input % 10 + sumOfDigits(input / 10);
		return smallAns  ;
	}
	public static void main(String[] args) {
             int n = 12345;
             int ans = sumOfDigits(n);
             System.out.println(ans);
	}

}
