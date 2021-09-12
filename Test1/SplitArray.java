package Test1;
/* Sum of both the parts is equal
 * All elements in the input, which are divisible by 5 should be in same group
 * All elements in the input, which are divisible by 3 (but not divisible by 5) should be in other group
 * Elements which are neither divisible by 5 nor by 3, can be put in any group*/
public class SplitArray {
   
	public static boolean splitArray( int input[] ) {
		
    	int n = input.length;
    	
    	return split( input, n, 0, 0, 0 );
    	
    }
    
    public static boolean split( int input[], int n, int idx, int sum1, int sum2 ) {
    	
    	if( idx == n ) {
    	
//    		if(sum1 == sum2) {
//    			
//    			return true;
//    	
//    		} else {
//    		
//    			return false;
//    		}
    		
    		return sum1 == sum2;
    	
    	}
    	
    	if( input[idx] % 3 == 0 ) {
    		
    		sum1 += input[idx];
    	}
    	
    	else if( input[idx] % 5 == 0 ) {
    		
    		sum2 += input[idx];
    	}
    	
    	else {
    	    
    		return split( input, n, idx + 1, sum1, sum2 + input[idx] ) || split( input, n, idx + 1, sum1 + input[idx], sum2 );
    	}
    	
    	return split( input, n, idx + 1, sum1, sum2 );
    }
	public static void main(String[] args) {
		
		int n = 2;
		
		int a[] = { 1 , 2 }; //false
		
		int a1[] = { 1 , 4 , 3 }; // true
		
		boolean ans = splitArray(a);
		
		System.out.println(ans);
	}

}
