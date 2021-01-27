package hashMap;

import java.util.HashMap;
import java.util.Scanner;

/*Pair Sum to 0
Send Feedback
Given a random integer array A of size N. Find and print the pair of elements in the array which sum to 0.
Array A can contain duplicate elements.
While printing a pair, print the smaller element first.
That is, if a valid pair is (6, -6) print "-6 6". There is no constraint that out of 5 pairs which have to be printed in 1st line. You can print pairs in any order, just be careful about the order of elements in a pair.
Input format :
Line 1 : Integer N (Array size)
Line 2 : Array elements (separated by space)
Output format :
Line 1 : Pair 1 elements (separated by space)
Line 2 : Pair 2 elements (separated by space)
Line 3 : and so on
Constraints :
0 <= N <= 10^4
Sample Input:
5
2 1 -2 2 3
Sample Output :
-2 2
-2 2

Sample Input:
6
-2 2 6 -2 2 -6
Sample Output :
-2 2
-2 2
-2 2
-2 2
-6 6

*/
public class PairSumToZero {

	public static void PairSum(int[] input, int size) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
       
		for( int i : input ) {
			
			if (map.containsKey(-i)) {
				
				for (int j = 1; j <= map.get(-i); j++) {
				    // if i is positive number
					if (i >= 0) {
                       
						// first print negative integer then print positive integer 
						System.out.println(-i + " " + i);

					} else { // if i is negative number 
						
						// first print negative integer then print positive integer
						System.out.println(i + " " + -i);

					}
				}
			}
			if( map.containsKey( i )) {
				
				map.put( i , map.get( i ) + 1);
			
			} else {
				
				map.put( i, 1 );
			}
		}
	} 
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a1[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			a1[i] = s.nextInt();
		}
		PairSum( a1, n );
		
		s.close();
	}

}
