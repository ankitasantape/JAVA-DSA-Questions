package Recursion_1;

public class StringToInteger {
    public static int convertStringToInteger(String input) {
    	
          if(input.length() == 1)
          {
        	  return input.charAt(0) - '0';
          }
          
         int a = convertStringToInteger(input.substring(1));
         
         double b = input.charAt(0) - '0'; 
        
        
         System.out.println(b  * Math.pow(10, input.length() - 1 )+ " " + a);
         
         b = (int) b *  Math.pow(10, input.length() - 1) + a;
         return (int) b;
    }
   
	public static void main(String[] args) {
               String s = "1234";
               int ans = convertStringToInteger(s);
               System.out.println(ans);
	}

}
