package DP_And_Memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Code: Minimum Count of Squares
Send Feedback
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. 
The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.
Input format :
The first and the only line of input contains an integer value, 'N'.
 Output format :
Print the minimum count of numbers required.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1)

B) (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1)  + (2 ^ 2)

C) (1^1) + (1^1) + (1^1) + (1^1) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.
Sample Input 2 :
9
Sample Output 2 :
1
*/
public class MinimumCountOfSquares {
	public static int minCount(int n) {
	     
		if( n == 0 ) {
			return 0;
		}
		
		if( n == 1 ) {
			return 1;
		}
		int min = Integer.MAX_VALUE;
		for( int i = 1; i <= Math.sqrt(n); i++ ) {
			
			int minIntReq = minCount( n - (i*i ));
			if( min > minIntReq ) {
				min = minIntReq;
			}
		}
		return min + 1;
	}
	
	public static int minCountM(int n) {
		
		int storage[] = new int[n+1];
		for( int i = 0; i < storage.length; i++ ) {
        	storage[i] = -1;
        }
		
		return minCountM( n, storage );
	}

	private static int minCountM(int n, int[] storage) {
		
		if(n == 0 || n == 1) {
			storage[n] = n;
			return storage[n]; 
		}
		
		if( storage[n] != -1 ) {
			return storage[n];
		}
		
		int min = Integer.MAX_VALUE;
		for( int i = 1; i <= Math.sqrt(n); i++ ) {
			
			int minIntReq = minCountM( n - ( i*i ), storage );
			if( min > minIntReq ) {
				min = minIntReq;
			}
		}
		
		storage[n] = min + 1;
		return storage[n];
	}

	public static int minCountDP(int n) {
		int storage[] = new int[n+1];
		storage[0] = 0;
		storage[1] = 1;
		
	   for (int i = 2; i <= n; i++) {
			
		   int min = Integer.MAX_VALUE;
			
			for (int j = 1; j <= Math.sqrt(i); j++) {

				int count = storage[i - (j * j)];
				if (min > count) {
					min = count;
				}
			}
			storage[i] = min + 1;
		}
		
		return storage[n];
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(minCountDP(n));
            System.out.println(minCountM(n));
            System.out.println(minCount(n));
    }
}
