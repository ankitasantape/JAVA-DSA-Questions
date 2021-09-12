package Recursion_2;

public class ReplaceCharAbyB {
	public static String replaceCharacter(String input, char c1, char c2) {
		   if(input == null || input.length() <= 0)
		   {
			   return input;
		   }
		   String ans  = "";
		   if(input.charAt(0) == c1)
		   {
			    ans += c2;
		   } else 
		   if( input.charAt(0) != c1) {
			   ans += input.charAt(0);
		   }
		   String smallAns = ans +  replaceCharacter(input.substring(1), c1, c2);
		   return smallAns;
	}
	public static void main(String[] args) {
           String str = "abacd";
           char c1 = 'a';
           char c2 = 'x';
           String ans = replaceCharacter(str, c1, c2);
           System.out.println(ans);
		
	}

}
