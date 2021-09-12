package DP_And_Memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*Code: Min Steps to One
Send Feedback
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. 
You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - 1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
Write brute-force recursive solution for this.
Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.
Constraints :
1 <= n <= 200

Time Limit: 1 sec
Sample Input 1 :
4
Sample Output 1 :
2 
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 
Sample Input 2 :
7
Sample Output 2 :
3
Explanation of Sample Output 2 :
For n = 7
Step 1 :  n = 7 - 1 = 6
Step 2 : n = 6  / 3 = 2 
Step 3 : n = 2 / 2 = 1  
*/
public class MinStepsTo1 {
	public static int countMinStepsToOne(int n) {
	       // if n is 1 then return 0 becoz we need not to reduce futher
	       if( n == 1 ) {
	    	   return 0; 
	       }
	       // To reduce n to 1 we have to perform 3 steps and those path will return min count of steps, that value will finally be returned 
	       int op1 = countMinStepsToOne( n - 1 );
	       // count1 from op1 now this count will be compared with count of op2 and op3
	       //initially, assume minsteps is equal to op1 as we have only count from op1
	       int minSteps = op1;
	       
	       //if n is completely divisible by 2 then we will call recursive function on this value  
	       if( n % 2 == 0 ) {
	    	   int op2 = countMinStepsToOne( n / 2 );
	    	   // compare count of op2 with count of op1 
	    	   if( op2 < minSteps ) {
	    		   // if the count of option2 is less than the minSteps, then update new minSteps as op2
	    		   minSteps = op2;
	    	   }
	       }
	     //if n is completely divisible by 3 then we will call recursive function on this value 
	       if( n % 3 == 0 ) {
	    	   int op3 = countMinStepsToOne( n / 3 );
	    	   if( op3 < minSteps ) {
	    		   
	    		   minSteps = op3;
	    	   }
	       }
	       // add 1 to minSteps as we have not include root value  
	       return minSteps + 1;
	}
    // Top - down Approach 
	public static int countMinStepsToOneM(int n) {
	       int storage[] = new int[n+1];
	       return countMinStepsToOneM(n, storage );
	}
	
	public static int countMinStepsToOneM(int n, int[] storage ) {
		
	       if( n == 1 ) {
	    	   storage[n] = 0;
	    	   return storage[n]; 
	       }
	       
	       if( storage[n] != 0 ) {
	    	   return storage[n];
	       }
	       
	       int op1 = countMinStepsToOneM( n - 1, storage );
	       int minSteps = op1;
	       
	       if( n % 2 == 0 ) {
	    	   int op2 = countMinStepsToOneM( n / 2 , storage );
	    	   if( op2 < minSteps ) {
	    		   
	    		   minSteps = op2;
	    	   }
	       }
	       
	       if( n % 3 == 0 ) {
	    	   int op3 = countMinStepsToOneM( n / 3 , storage );
	    	   if( op3 < minSteps ) {
	    		   
	    		   minSteps = op3;
	    	   }
	       }
	       storage[n] = minSteps + 1;
	       return storage[n];
	}
	//Bottom - up Approach
	public static int countMinStepsToOneDP( int n ) {
		
		int storage[] = new int[ n + 1];
		//base case if( n == 1 ) then return 0; 
		storage[1] = 0;
		for( int i = 2; i <= n; i++ ) {
			// minSteps followed by func(n-1) to reach 1
			int minSteps = storage[i-1];
			if( i % 3 == 0 ) {
				if( minSteps > storage[ i / 3 ] ) {
					minSteps = storage[ i / 3 ];
				}
			}
			
			if( i % 2 == 0 ) {
				if( minSteps > storage[ i / 2 ] ) {
					minSteps = storage[ i / 2 ];
				}
			}
			storage[i] = 1 + minSteps;
		}
		
		return storage[n];
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(countMinStepsToOneDP(n));
            System.out.println(countMinStepsToOneM(n));
            System.out.println(countMinStepsToOne(n));
    }
}
