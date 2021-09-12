package Recursion_2;

public class RemoveDuplicate {
	public static String removeConsecutiveDuplicates(String s) {
           if(s == null || s.length() <= 1)
           {
        	   return s;
           }
           String ans = "";
           if(s.charAt(0) != s.charAt(1)) {
        	   ans += s.charAt(0);
           }
           String smallAns = ans + removeConsecutiveDuplicates(s.substring(1));
           
           return smallAns;
	}
	public static void main(String[] args) {
           String s = "abbcdddeeee";
           String ans = removeConsecutiveDuplicates(s);
           System.out.println(ans);
		
	}

}
