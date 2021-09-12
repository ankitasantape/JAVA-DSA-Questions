package Recursion_1;

public class RemoveX {
    public static String removeX(String input ) {
    	if( input == null ||  input.length() <= 1)
    	{
    		return input;
    	}
    	return input.replaceAll("x", "");

    }
    public static String removeX_1(String input) {
    	//System.out.println(input);
    	if( input.length() == 0)
    	{
    		//System.out.println(input.length());
    		return input;
    	}
    	
    	String ans = "";
    	if ( input.charAt(0) != 'x') {
    		
    		ans = ans + input.charAt(0);
    		//System.out.println(input + " " + ans);
    	}
    	String smallAns = removeX_1(input.substring(1));
    	//System.out.println(ans + " " +smallAns);
    	return ans + smallAns;
    }
	public static void main(String[] args) {
		String s = "axbx";
		String ans  = removeX_1(s);
		System.out.println(ans);

	}

}
