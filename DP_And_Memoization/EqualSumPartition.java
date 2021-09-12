package DP_And_Memoization;

import java.util.Scanner;

public class EqualSumPartition {

   public static boolean canPartition(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		return subsetSumDP(arr, n, sum / 2);
	}

	// Time Complexity - O(sum*n) Space Complexity - O(sum*n) which is the size of
	// 2D array
	public static boolean subsetSumDP(int arr[], int n, int sum) {
		boolean storage[][] = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			storage[i][0] = true;
		}
		for (int j = 1; j <= sum; j++) {
			storage[0][j] = false;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				if (arr[i - 1] > j) {
					storage[i][j] = storage[i - 1][j];

				} else {
					storage[i][j] = storage[i - 1][j - arr[i - 1]] || storage[i - 1][j];
				}
			}
		}
		return storage[n][sum];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(canPartition(a, n));
		sc.close();
	}

}
