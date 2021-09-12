package Recursion_2;

/*Return Permutations - String
Send Feedback
Given a string S, find and return all the possible permutations of the input string.
Note 1 : The order of permutations is not important.
Note 2 : If original string contains duplicate characters, permutations will also be duplicates.
Input Format :
String S
Output Format :
All permutations (in different lines)
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba*/

public class PermutationReturn {
	public static String[] permutationOfString(String input) { // input = dg
		if (input.length() == 2) {
			String a = input.substring(0, 1) + input.substring(1); // dg
			String b = input.substring(1) + input.substring(0, 1); // gd
			String arr[] = new String[] { a, b }; // { dg , gd }
			return arr;
		}

		int factorial = 1, index = 0;
		for (int i = 1; i <= input.length(); i++) {
			factorial *= i;
		}

		String[] ans = new String[factorial];
		for (int i = 0; i < input.length(); i++) {
			String arr[] = permutationOfString(input.substring(0, i) + input.substring(i + 1));
			for (int j = 0; j < arr.length; j++) {
				ans[index++] = input.charAt(i) + arr[j];
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		String s = "abc";

		String[] ans = permutationOfString(s);
		System.out.println("Permutations of String " + s + " is :");
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}
