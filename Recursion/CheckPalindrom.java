package Recursion;

public class CheckPalindrom {
	public static boolean isStringPalindrome(String input) {
        if( input.length() == 0)
        {
        	return true;
        }
		return isStringPalindrome(input, 0, input.length() - 1);
	}
	private static boolean isStringPalindrome(String input, int start, int end ) {
		
		if( start == end) {
			return true;
		} 
		
		if(input.charAt(start) != input.charAt(end)) {
			return false;
		}
		
		if( start < end + 1 ) {
		    return isStringPalindrome(input, start + 1, end - 1);
        }
		return true;
		
	}
	public static void main(String[] args) {
           String str = "cooodddfrfdddoooc";
           boolean ans = isStringPalindrome(str);
           System.out.println(ans);
	}

}
