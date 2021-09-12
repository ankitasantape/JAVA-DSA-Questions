package Recursion_2;

public class SubsequencesOfTheStringPrint {
    public static void print(String input, String output) {
    	if(input.length() == 0) {
    		System.out.println(output);
    		return;
    	}
    	// we choose not to include the first character
    	print(input.substring(1), output);
    	// we choose to include the first character
    	print(input.substring(1), output + input.charAt(0));
    }
	public static void main(String[] args) {
           String s = "abs";
           print(s, "");
	}

}
