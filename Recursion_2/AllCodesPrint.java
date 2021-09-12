package Recursion_2;

public class AllCodesPrint {
	public static void printAllPossibleCodes(String input) {
     
		printAllPossibleCodes(input, "");
	
	}
	
	public static void printAllPossibleCodes(String input, String output) {
		 
		if(input == null || input.length() <= 0)
 	    {
 	    	System.out.println(output);
 	    	return;
 	    }
		 
		//SmallCalculation
		 
		String ch1 = input.substring(0, 1);
		
		String restStr = input.substring(1);
		
		if(Integer.parseInt(ch1) > 0) {
			
			char code = (char) (Integer.parseInt(ch1) + 'a' - 1);
			
			printAllPossibleCodes(restStr, output + code);
		}
		
		if(input.length() >= 2) {
		
			String ch2 = input.substring(0,2);
			
			String restStr2 = input.substring(2);
			
		if(Integer.parseInt(ch2) >= 10 && Integer.parseInt(ch2) <= 26) {
			
			char code = (char) (Integer.parseInt(ch2) + 'a' - 1);
			
			printAllPossibleCodes(restStr2, output + code);
		}
//		if(Integer.parseInt(ch2, 10) == 0) {
//			printAllPossibleCodes(restStr2, output);
//		}
		}
	}
	public static void main(String[] args) {
           String s = "1123";
           printAllPossibleCodes(s);
	}

}
