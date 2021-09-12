package Recursion_2;

public class KeypadCodeReturn {
    public static String[] keypad(int n){
		   if(n == 0 || n == 1) {
			   String[] ans = {" "};
			   return ans;
		   }
		   
		   String smalloutput[]=keypad(n/10);
	        String arr=StringArray(n%10);
	        String output[]=new String[arr.length()*smalloutput.length];
	        int k=0;
	        for(int i=0;i<arr.length();i++)
	        {
	            for(int j=0;j<smalloutput.length;j++)
	            {
	                output[k]=smalloutput[j]+arr.charAt(i);
	                k++;
	            }
	        }
	        return output;
	}
   
    private static String StringArray(int n ) {
    	String ans = " ";
    	switch(n) {
    	case 2: 
    		ans =  "abc"; 
    		break;
    	case 3:
    		ans = "def";
    		break;
    	case 4:
    	    ans = "ghi";
    		break;
    	case 5:
    		ans = "jkl";
    		break;
    	case 6:
    		ans = "mno";
    		break;
    	case 7:
    		ans = "pqrs";
    		break;
    	case 8:
    		 ans = "tuv";
    		break;
    	case 9:
    		ans = "wxyz";
    		break;
    	}
    	
    	return ans;
    }
    
   
	public static void main(String[] args) {
           int n = 234;
           String[] ans = keypad(n);
           for(int i = 0; i < ans.length; i++) {
        	   System.out.println(ans[i] + " ");
           }
           
	}

}
