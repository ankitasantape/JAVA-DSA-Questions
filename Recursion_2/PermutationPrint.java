package Recursion_2;
/*Print Permutations - String
Send Feedback
Given a string, find and print all the possible permutations of the input string.
Note : The order of permutations are not important. Just print them in different lines.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba*/
public class PermutationPrint {
   public static void permutations(String input){
		  
	   String ans = "";
	   permutation(input, ans);
	}
    private static void permutation(String input, String output) {
    //System.out.println(output);
    	    if(input == null || input.length() <= 0)
    	    {
    	    	System.out.println(output);
    	    	return;
    	    }
    	    for(int i = 0; i < input.length(); i++) {
    	    char ch = input.charAt(i);
    	   // System.out.println(ch);
    	    String ans =  input.substring(0,i) + input.substring(i+1);
    	   // System.out.print(input.substring(0, i) + " " + i + " ");
    	    //System.out.println(input.substring(i+1) + " " + (i + 1));
    	    //System.out.println(ans);
    	   //System.out.println(output + ch);
    	    //System.out.println(i);
    	    permutation(ans, output + ch);
    	    }
    	  
    }
	public static void main(String[] args) {
		
           String s = "agi";
           permutations(s);
	}

}
