package Recursion_2;

public class SubsequencesOfTheStringReturn {
    public static String[] returnSubsequences(String input) {
    	if(input.length() == 0) {
    		String[] ans = {""};
    		return ans;
    	}
    	
    	String smallAns[] = returnSubsequences(input.substring(1));
    	String ans[] = new String[2 * smallAns.length];
    	
    	int k = 0;
    	for(int i = 0; i < smallAns.length; i++) {
    		ans[i] = smallAns[i];
    		k++;
    	}
    	
    	for(int i = 0; i < smallAns.length; i++) {
    		ans[k] = input.charAt(0) + smallAns[i];
    		k++;
    	}
    	
    	return ans;
    }
	public static void main(String[] args) {
		   String s = "abc";
		   String ans[] = returnSubsequences(s);
		   for(int i = 0; i < ans.length; i++) {
			   System.out.print(ans[i] + " ");
		   }
	}

}
