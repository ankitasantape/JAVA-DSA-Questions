package Recursion;

public class CountZeroesRec {
	public static int countZerosRec(int input){
          
		
		if(input == 0){
			return 0;
		}
	    if( input % 10 == 0) {
	        return 1 + countZerosRec(input / 10);
	    }
		 
	    return countZerosRec(input / 10);
	
	
	}
	
	public static void main(String[] args) {
           int n = 1000230005;
           int ans = countZerosRec(n);
           System.out.println(ans);
	}

}
