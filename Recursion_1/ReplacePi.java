package Recursion_1;

public class ReplacePi {
    public static String replacepi(String input) {
    	
    	if (input == null || input.length() <= 1 ) {
    		return input;
    	}
    	return input.replace("pi", "3.14");
    }
	public static void main(String[] args) {
           String s = "pipip";
          String ans =  replacepi(s);
          System.out.println(ans);
           
	}

}
