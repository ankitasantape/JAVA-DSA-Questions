package DP_And_Memoization;

import java.util.Scanner;
/*You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

Input
[0,0,0,0,0,0,0,0,1]
1
Output
1
Expected
256

There are 5 ways to assign symbols to make the sum of nums be target 3.
Constraints:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/
public class TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
    	if( nums.length == 0 ) {
    		return 0;
    	}
    	int sumOfA = 0;
    	for( int i = 0; i < nums.length; i++ ) {
    		sumOfA += nums[i]; 
    	}
    	if( sumOfA < S || ( sumOfA + S ) % 2 != 0) {
    		return 0;
    	}
    	int sumToCheck = ( sumOfA + S )/2;
    	return countSubsets(nums, sumToCheck);
    }
	
	private static int countSubsets(int[] nums, int sum) {
		if( nums.length == 0 || sum <= 0 ) {
			return 0;
		}
		int n = nums.length;
		int [][]count = new int[n][sum+1];
//		fill 0th column
		for( int i = 0; i < n; i++ ) {
			count[i][0] = 1;
		}
//		fill 0th row 
		for( int j = 0; j <= sum ; j++ ) {
			if( nums[0] == j ) {
				count[0][j] = 1;
			}
		}
		
		for(int i = 1; i < n; i++ ) {
			for( int j = 1; j <= sum; j++) {
				int include = 0;
				int xclude = 0;
				if( nums[i] <= j) {
					include = count[i-1][j-nums[i]];
				}
				xclude = count[i-1][j];
				count[i][j] = include + xclude;
			}
		}
		return count[n-1][sum];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		System.out.println(findTargetSumWays(arr,sum));
		sc.close();
	}

}
