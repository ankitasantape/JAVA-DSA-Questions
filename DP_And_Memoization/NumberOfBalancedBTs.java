package DP_And_Memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Code: Number of Balanced BTs
Send Feedback
Given an integer h, find the possible number of balanced binary trees of height h. 
You just need to return the count of possible binary trees which are balanced.
This number can be huge, so, return output modulus 10^9 + 7.
Write a simple recursive solution.
Input Format :
The first and only line of input contains an integer, that denotes the value of h. Here, h is the height of the tree.
Output Format :
The first and only line of output contains the count of balanced binary trees modulus 10^9 + 7.
Constraints :
1 <= h <= 24
Time Limit: 1 sec
Sample Input 1:
3
Sample Output 1:
15
Sample Input 2:
4
Sample Output 2:
315
*/
public class NumberOfBalancedBTs {
    
	public static long balancedBTsRec(long n) {
		int mod = (int) Math.pow(10, 9) + 7;
		return balancedBTsRec(n, mod);
	}
	
	public static long balancedBTsRec(long n, int mod){

		  if( n == 0 || n == 1 ) {
			  
			  return 1;
		  }
		  
		  long leftSubHeight = balancedBTsRec( n - 1 , mod );
		  long rightSubHeight = balancedBTsRec( n - 2 , mod );
		  long res1 = (leftSubHeight * leftSubHeight) % mod;
		  long res2 = (2 * leftSubHeight * rightSubHeight) % mod;
		  
		  
		  return (res1 + res2)%mod;

	}
	
	public static int balancedBTs2Rec(int n) {
		int mod = (int) Math.pow(10, 9) + 7;
		return balancedBTs2Rec(n, mod);
	}
	
	private static int balancedBTs2Rec(int n, int mod){

		  if( n == 0 || n == 1 ) {
			  
			  return 1;
		  }
		  
		  int leftSubHeight = balancedBTs2Rec( n - 1 , mod );
		  int rightSubHeight = balancedBTs2Rec( n - 2 , mod );
		  long res1 = (leftSubHeight * leftSubHeight) % mod;
		  long res2 = (2 * leftSubHeight * rightSubHeight) % mod;
		  int val1 = (int) (res1 % mod);
		  int val2 = (int) (res2 % mod);
		  
		  return (val1 + val2)%mod;

	}
	
	public static int balancedBTsM(int height){

		   int storage[] = new int[ height + 1 ];
		  // (height+1) becoz there are (height+1) unique calls
	        for( int i = 0; i < storage.length; i++ ) {
	        	storage[i] = -1;
	        }
	        
	        int mod = (int) Math.pow(10, 9) + 7;
	        
	     return balancedBTsM( height, storage, mod );   
	}
	private static int balancedBTsM(int h, int[] storage, int mod ) {
		
		    if( h == 0 || h == 1 ) {
		    	storage[h] = 1;
		    	return storage[h];
		    }
		    
		    if( storage[h] != -1 ) {
				return storage[h];
			}
		    
		      int leftSubHeight = balancedBTsM( h - 1 ,storage, mod );
			  int rightSubHeight = balancedBTsM( h - 2 , storage, mod );
			  long res1 = (leftSubHeight * leftSubHeight) % mod;
			  long res2 = (2 * leftSubHeight * rightSubHeight) % mod;
			  int val1 = (int) (res1 % mod);
			  int val2 = (int) (res2 % mod);
			  
			  storage[h] = (val1 + val2) % mod;
			  return storage[h];
	}
	
	public static int balancedBTs(int height){

	       int mod = (int) Math.pow(10, 9) +7;
	       
	       int storage[] = new int[ height + 1];
	       
	       storage[0] = 1;
	       storage[1] = 1;
	       
	       for( int i = 2; i <= height; i++ ) {
	    	  
	    	  long leftSubHeight = storage[ i - 1 ];
	 		  long rightSubHeight = storage[ i - 2 ];
	 		 
	 		  long res1 = (leftSubHeight * leftSubHeight) % mod;
	 		  long res2 = (2 * leftSubHeight * rightSubHeight) % mod;
	 		  
	 		  storage[i] = (int)( res1 + res2 ) % mod;
	       }
	       
	       return storage[height];
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws NumberFormatException, IOException {


        long n = Integer.parseInt(br.readLine().trim());
        
        System.out.println("DP Solution : " + balancedBTsM( (int)n ));
        System.out.println("Memoization: " + balancedBTsM( (int)n ));
        System.out.println("For long value : "+balancedBTsRec(n));
        
        System.out.print("For int value : "+balancedBTs2Rec((int)n));
        
        
    }

}
