package DP_And_Memoization;
import java.util.Scanner;
/*
Sample Input : 6
               2 3 5 6 8 10
               10
Sample Output: 3
               3
               3
*/
public class CountOfSubsetsSum {
    
 // Recursive 
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
 	// Memoization
 	public static int subsetSumMemo( int arr[], int n, int sum) {
 		int storage[][] = new int[n+1][sum+1];
 		for( int i = 0; i < storage.length; i++) {
 			for( int j = 0; j < storage[0].length; j++) {
 				storage[i][j] = -1;
 			}
 		}
 		return subsetSumMemo( arr, n, sum, storage );
 	}	
 	
 	private static int subsetSumMemo(int[] arr, int n, int sum, int[][] storage) {
 	    if(sum == 0 ) {
 	    	storage[n][sum] = 1;
 	    	return storage[n][sum];
 	    }
 	    if( n == 0 ) {
 	    	storage[n][sum] = 0;
 	    	return storage[n][sum];
 	    }
 	    if( storage[n][sum] != -1 ) {
 	    	return storage[n][sum];
 	    }
 	    if( arr[n-1] > sum ) {
 	    	storage[n][sum] = subsetSumMemo( arr, n-1, sum, storage);
 	    	return storage[n][sum];
 	    }
 	    storage[n][sum] = subsetSumMemo( arr, n-1, sum - arr[n-1], storage) + subsetSumMemo( arr, n-1, sum, storage);
     	return storage[n][sum];
 	}
 	// Time Complexity - O(sum*n) Space Complexity - O(sum*n) which is the size of 2D array
 	public static int subsetSumDP(int arr[], int n, int sum) {
 		int storage[][] = new int[n+1][sum+1];
 		for( int i = 0; i <= n; i++ ) {
 			storage[i][0] = 1;
 		}
 		for( int j = 1; j <= sum; j++ ) {
 			storage[0][j] = 0;
 		}
 		for( int i = 1; i <= n; i++ ) {
 			for( int j = 1; j <= sum; j++ ) {
 				
 				if( arr[i-1] > j ) {
 					storage[i][j] = storage[i-1][j];
 				
 				} else {
                     storage[i][j] = storage[i-1][j - arr[i-1]] + storage[i-1][j];					
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
