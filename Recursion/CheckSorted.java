package Recursion;

public class CheckSorted {
    public static boolean checkSorted(int input[])
    {
    	if(input.length <= 1) {
    		return true;
    	}
    	
        if(input[0] > input[1]) {
    		
    		return false;
    	}
    	
    	int smallAry[] = new int[input.length - 1];
    
    	for(int i = 1; i < input.length; i++) {
    		smallAry[i - 1] = input[i]; 
            
    	}
    	
    	boolean smallAns = checkSorted(smallAry);
    	
    	return smallAns;
    }
	public static void main(String[] args) {
           int a[] = {2,1,3,6,9};
           boolean ans = checkSorted(a);
           System.out.println(ans);
	}

}
