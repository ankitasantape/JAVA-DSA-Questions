package DP_And_Memoization;

import java.util.Scanner;

/*Code: Edit Distance(Memoization and DP)
Send Feedback
You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
1. Delete a character
2. Replace a character with another one
3. Insert a character
Note :
Strings don't contain spaces in between.
 Input format :
The first line of input contains the string S of length M.

The second line of the input contains the String T of length N.
Output format :
Print the minimum 'Edit Distance' between the strings.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".

And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 

Hence, the minimum distance.
Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9
*/
public class EditDistance {

	public static int editDistanceRec(String s, String t) {
		   
		if (s.length() == 0) {
			return t.length();
		}
		
		if (t.length() == 0) {
			return s.length();
		}
		 
		if (s.charAt(0) == t.charAt(0)) {
			return editDistanceRec(s.substring(1), t.substring(1));
		}
		// insert
		int op1 = editDistanceRec(s, t.substring(1));
		// delete
		int op2 = editDistanceRec(s.substring(1), t);
		// substitute
		int op3 = editDistanceRec(s.substring(1), t.substring(1));
	
		return 1 + Math.min(op1, Math.min(op2, op3));

    }
	
	public static int editDistanceM( String s, String t ) {
		   
		int m = s.length();
		int n = t.length();
		int storage[][] = new int[m + 1][n + 1];
		for( int i = 0; i <= m; i++ ) {
			for( int j = 0; j <= n; j++ ) {
				storage[i][j] = -1;
			}
		}
	    
		return editDistance( s, t, storage );
	}
	
	private static int editDistance( String s, String t , int storage[][] ) {
		int m = s.length();
		int n = t.length();
		//Base Case
		if( m == 0 ) {
			storage[m][n] = n;
			return storage[m][n];
		}
		
		if( n == 0 ) {
			storage[m][n] = m;
			return storage[m][n];
		}
		
		if( storage[m][n] != -1 ) {
			return storage[m][n];
		}
		
		if( s.charAt(0) == t.charAt(0) ) {
			
			storage[m][n] = editDistance( s.substring(1), t.substring(1), storage );
		}
		else 
		{
			// insert
			int op1 = editDistance( s, t.substring(1), storage );
			// delete
			int op2 = editDistance( s.substring(1), t, storage );
			// substitute
			int op3 = editDistance( s.substring(1), t.substring(1), storage );
			
			storage[m][n] = 1 + Math.min(op1, Math.min(op2, op3));
			
		}
		
		return storage[m][n];
	}
	
	public static int editDistanceDP( String s, String t ) {
		   
		int m = s.length();
		int n = t.length();
		int storage[][] = new int[m + 1][n + 1];
		
		for( int i = 0; i <= m; i++ ) {
			storage[i][0] = i;
		}
		
		for( int j = 0; j <= n; j++ ) {
			storage[0][j] = j;
		}
		
		for( int i = 1; i <= m; i++ ) {
			for( int j = 1; j <= n; j++ ) {
				if( s.charAt( m - i ) == t.charAt( n - j)) {
					storage[i][j] = storage[i - 1][j - 1];
				
				} else {
					
					storage[i][j] = 1 + Math.min( storage[i][j - 1], Math.min(storage[i - 1][j - 1], storage[i - 1][j]));
				}
			}
		}
		
		return storage[m][n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		
		
		System.out.println( editDistanceM( s , t ));
		System.out.println( editDistanceRec( s, t ));
		System.out.println( editDistanceDP( s, t));
		sc.close();
	}

}
