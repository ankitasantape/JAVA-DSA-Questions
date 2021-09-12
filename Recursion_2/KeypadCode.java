package Recursion_2;

public class KeypadCode {
	public static void printKeypad(int input){
		
		printKeypad(input, "");
	}
	private static void printKeypad(int input, String output) {
		
		if(input == 0) {
				System.out.println(output);
			     return;
		}
		
		String str = StringArray(input % 10) ; //234 % 10 = 4 ---> ghi
		for(int i = 0; i < str.length(); i++) {
		  
			 printKeypad(input / 10,  str.charAt(i) + output);
			
		}
	       
	}
	 private static String StringArray(int n ) {
	    	
	   switch(n) {
	    	case 2:  return  "abc"; 
	    	
	    	case 3:  return "def";
	    		
	    	case 4:  return "ghi";
	    		
	    	case 5:  return "jkl";
	    		
	    	case 6:  return  "mno";
	    		
	    	case 7:  return "pqrs";
	    		
	    	case 8:  return  "tuv";
	    		
	    	case 9:  return "wxyz";
	    	 
	    	default: break;
	    	}
	    	
	    	return "";
	    }
	public static void main(String[] args) {
		  int n = 23;
		  printKeypad(n);
	}

}
