package DP_And_Memoization;

public class Fibonacci {

	//Recursion
	public static int fibRec(int n) {
		if( n== 0 || n== 1 ) {
			return n;
		}
		System.out.println("Hello " + n);
		return fibRec(n-1) + fibRec(n-2);
	}
	
	//Memoization
	public static int fibM( int n ) {
		
		int storage[] = new int[n+1]; // (n+1) becoz there are (n+1) unique calls
        for( int i = 0; i < storage.length; i++ ) {
        	storage[i] = -1;
        }
        
        return fibM( n, storage);
	}
	
	private static int fibM(int n, int[] storage) {
		
		if(n == 0 || n== 1) {
			storage[n] = n;
			return storage[n]; 
		}
		
		if( storage[n] != -1 ) {
			return storage[n];
		}
		
		storage[n] = fibM( n-1, storage) + fibM( n-2, storage);
		return storage[n];
		
	}

	//Dynamic Programming - Iterative
	public static int fibDP( int n ) {
		int storage[] = new int[n+1];
		storage[0] = 0;
		storage[1] = 1;
		
		for( int i = 2; i <= n; i++ ) {
			storage[i] = storage[i-1] + storage[i-2];
		}
		
		return storage[n];
	}
	public static void main(String[] args) {
	
		System.out.println("Memoization - "+fibM(10));
		System.out.println("DP - "+fibDP(10));
		System.out.println("Recusive - "+fibRec(10));
	}

}
