package Recursion;


public class CheckNumerInArray {

	public static boolean checkNumber(int input[], int x)
	{
		if(input.length <= 0) {
			return false;
		}
		
		if(input[0] == x) {
    		return true;
    	} 
		
//		if(input[0] != x)
//		{
//			return false;
//		} 
		
		
    	int smallAry[] = new int[input.length - 1];
    	for(int i = 1; i < input.length; i++) {
    		smallAry[i - 1] = input[i]; 
    		
    	}
    	
    	boolean smallAns = checkNumber(smallAry, x);
    	
    	return smallAns;
	}
	public static void main(String[] args) {
//         int n = 3;
//         int a[] = { 8,9,10};
//         int x = 1;
         
         //int n = 44;
         int a[] = {34, 57, 82, 41, 
        		    65, 35, 82, 27, 
        		    36, 12, 6, 40, 
        		    66, 99, 25, 29, 
        		    22, 25, 12, 24, 
        		    65, 15, 5, 43, 
        		    28, 33, 76, 32, 
        		    13, 95, 22, 84, 
        		    71, 23, 28, 7, 
        		    65, 94, 18, 47,
        		    9, 42, 61, 73}; 
         int x = 61;
         boolean ans = checkNumber(a, x);
         System.out.println(ans);
	}

}
