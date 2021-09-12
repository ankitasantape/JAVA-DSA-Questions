package String;
/*Check Palindrome
Send Feedback
Given a string, determine if it is a palindrome, considering only alphanumeric characters.
Palindrome
A palindrome is a word, number, phrase, or other sequences of characters which read the same backwards and forwards.
Example:
If the input string happens to be, "malayalam" then as we see that this word can be read the same as forward and backwards, it is said to be a valid palindrome.

The expected output for this example will print, 'true'.
From that being said, you are required to return a boolean value from the function that has been asked to implement.
Input Format:
The first and only line of input contains a string without any leading and trailing spaces. All the characters in the string would be in lower case.
Output Format:
The only line of output prints either 'true' or 'false'.
Note:
You are not required to print anything. It has already been taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1 :
abcdcba
Sample Output 1 :
true 
Sample Input 2:
coding
Sample Output 2:
false
*/
public class CheckPalindrome {
	
	public static boolean isPalindrom2(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
    public static boolean checkPalindrome(String str) {
//    	int  e = str.length() - 1;
//    	Boolean ans = false;
//    	for(int s = 0; s <= e; s++, e--)
//    	{
//    		char s1 = str.charAt(s);
//    		char e1 = str.charAt(e);
//    		if(s1 == e1)
//    		{
//    			ans = true;
//    		}
//    	
//    	}
//    	return ans;
    	
    	String rev = "";
    	for(int i = str.length() - 1; i >= 0 ; i--)
    	{
    		rev = rev + str.charAt(i);
    	}
    	System.out.println(rev);
    	if(str.equals(rev))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
	public static void main(String[] args) {
		//String str = "etsunjknuste";
		String str = "abcdcba";
        Boolean ans = checkPalindrome(str);
        System.out.println(ans);

	}

}
