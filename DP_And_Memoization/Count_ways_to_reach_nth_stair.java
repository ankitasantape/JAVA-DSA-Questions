package DP_And_Memoization;

import java.util.Scanner;

/*
 There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top (order does matter).

Example 1:

Input:
n = 4
Output: 5
Explanation:
You can reach 4th stair in 5 ways. 
Way 1: Climb 2 stairs at a time. 
Way 2: Climb 1 stair at a time.
Way 3: Climb 2 stairs, then 1 stair
and then 1 stair.
Way 4: Climb 1 stair, then 2 stairs
then 1 stair.
Way 5: Climb 1 stair, then 1 stair and
then 2 stairs.
Example 2:

Input:
n = 10
Output: 89 
Explanation: 
There are 89 ways to reach the 10th stair.
Your Task:
Complete the function countWays() which takes the top stair number m as input parameters and returns the answer % 10^9+7.

Expected Time Complexity : O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ n ≤ 104

Input
84   
Output
93254120
 */
public class Count_ways_to_reach_nth_stair {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countWays(n));
		sc.close();
	}

	public static long countWays(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		long dp[] = new long[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}
		return dp[n];
	}

}
