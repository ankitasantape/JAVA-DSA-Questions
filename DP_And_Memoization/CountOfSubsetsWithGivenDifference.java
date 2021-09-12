package DP_And_Memoization;

import java.util.Scanner;
/*   We have to find this,
 *   sum(s1) - sum(s2) = difference ------(1)
 *   sumOf subset1 + sumOf subset2 is equal to total sum of array
 *   sum(s1) + sum(s2) = sum(array) ------(2)
 *   From (1) & (2)
 *   2 * sum(s1) = difference + sum(array) 
 *   sumOf subset1 should be equal to ( difference + sumOf array ) divided by 2 
 *   sum(s1) = ( difference + sum(array) ) / 2
 Sample Input:  4
                1 1 2 3
                1
 Sample Output: 3
*/
public class CountOfSubsetsWithGivenDifference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}
		int diff = sc.nextInt();
        System.out.println(countOfSubsetsWithGivenDiff(arr,n,diff));
        sc.close();
	}

	private static int countOfSubsetsWithGivenDiff(int[] arr, int n, int diff) {
		int sum = 0;
		for( int i = 0; i < n; i++ ) {
			sum += arr[i];
		}
		
		int subsetSum = ( sum + diff )/2;
		
		return subsetSum( arr, n, subsetSum );
		
	}
    
	public static int subsetSum( int arr[], int n, int sum) {
 		if( sum == 0 ) {
 			return 1;
 		}
 		if( n == 0 ) {
 			return 0;
 		}
 		if( arr[n-1] > sum ) {
 			return subsetSum( arr, n - 1, sum);
 		}
 		
 		return subsetSum( arr, n-1, sum - arr[n-1]) + subsetSum( arr, n - 1, sum);
 	}
}
