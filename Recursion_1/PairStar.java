package Recursion_1;

public class PairStar {
	public static String addStars(String s) {
         
                    return addString(s, 0, 1);
	}
	private static String addString(String s, int start, int end) {
		
		if(end == s.length())
		{
			return s;
		}
		if(s.charAt(start) == s.charAt(end)) {
			
			s = s.substring(0, end) + "*"+ s.substring(end , s.length());
			//System.out.println(s );
		}
		return addString(s, start + 1, end + 1);
	}
	public static void main(String[] args) {
           String s = "hellopp";
           String ans = addStars(s);
           System.out.println(ans);
	}

}
