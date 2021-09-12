package DP_And_Memoization;

import java.util.Scanner;
// Difficulty level - Hard
public class MinimumSubsetSumDifference {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for( int i = 0; i < n; i++ ) {
        	arr[i] = sc.nextInt();
        }
        System.out.println(minimumSubsetSumDiff(arr,n));
        sc.close();
	}

	private static int minimumSubsetSumDiff(int[] arr, int n) {
		int sum = 0;
		for( int i = 0; i < n; i++ ) {
			sum += arr[i];
		}
		
		boolean storage[][] = new boolean[n+1][sum+1]; 
		for( int i = 0; i <= n; i++ ) {
			storage[i][0] = true;
		}
		for( int j = 1; j <= sum; j++ ) {
			storage[0][j] = false;
		}
		for( int i = 1; i <= n; i++ ) {
			for( int j = 1; j <= sum; j++ ) {
				
				if( arr[i-1] > j ) {
					storage[i][j] = storage[i-1][j];
				
				} else {
                    storage[i][j] = storage[i-1][j - arr[i-1]] || storage[i-1][j];					
				}
			}
		}
		int ans[] = new int[storage.length];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < storage.length; i++ ) {
			if( storage[n][i] == true ) {
				ans[i] = i;
//				System.out.print(ans[i]+" ");
			}
		}
		
		for( int i = 0; i < ans.length; i++ ) {
			min = Math.min(min, sum - 2*ans[i]);
		}
		return min;
	}

}
