package DP_And_Memoization;

import java.util.Scanner;
/*
n = 4
arr[] = 2 7 11 15
sum = 9
o/p : true
*/
public class SubsetSum {
    // Recursive 
	public static boolean subsetSum( int arr[], int n, int sum) {
		if( n == 0 || sum == 0 ) {
			return true;
		}
		
		if( arr[n-1] > sum ) {
			return subsetSum( arr, n - 1, sum);
		}
		
		return subsetSum( arr, n-1, sum - arr[n-1]) || subsetSum( arr, n - 1, sum);
	}
	// Memoization
	public static boolean subsetSumMemo( int arr[], int n, int sum) {
		boolean storage[][] = new boolean[n+1][sum+1];
		for( int i = 0; i < storage.length; i++) {
			for( int j = 0; j < storage[0].length; j++) {
				storage[i][j] = false;
			}
		}
		return subsetSumMemo( arr, n, sum, storage );
	}	
	
	private static boolean subsetSumMemo(int[] arr, int n, int sum, boolean[][] storage) {
	    if( n == 0 || sum == 0 ) {
	    	storage[n][sum] = true;
	    	return storage[n][sum];
	    }
	    if( storage[n][sum] != false ) {
	    	return storage[n][sum];
	    }
	    if( arr[n-1] > sum ) {
	    	storage[n][sum] = subsetSumMemo( arr, n-1, sum, storage);
	    	return storage[n][sum];
	    }
	    storage[n][sum] = subsetSumMemo( arr, n-1, sum - arr[n-1], storage) || subsetSumMemo( arr, n-1, sum, storage);
    	return storage[n][sum];
	}
	// Time Complexity - O(sum*n) Space Complexity - O(sum*n) which is the size of 2D array
	public static boolean subsetSumDP(int arr[], int n, int sum) {
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
		return storage[n][sum];
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		System.out.println(subsetSum( arr, n, sum));
		System.out.println(subsetSumMemo( arr, n, sum));
		System.out.println(subsetSumDP( arr, n, sum));
        sc.close();
	}

}
