package DP_And_Memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Code: 0 1 Knapsack
Send Feedback
A thief robbing a store can carry a maximal weight of W into his knapsack. 
There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?
Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.

The second line of input contains the N number of weights separated by a single space.

The third line of input contains the N number of values separated by a single space.

The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
Output Format :
Print the maximum value of V that the thief can steal.
Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13
Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51
 */

/*Code: Knapsack(Memoization and DP)
Send Feedback
A thief is robbing a store and can carry a maximal weight of W into his knapsack. 
There are N items and ith item weighs wi and is of value vi. Considering the constraints of maximum weight that knapsack can carry, 
you have to find and return the maximum value that thief can generate by stealing items.
Note
Space complexity should be O(W).
Input Format :
The first line contains an integers, that denote the value of N. The following line contains N space separated integers, 
that denote the values of weight of items. The following line contains N space separated integers, that denote the values associated with the items. 
The following line contains an integer that denote the value of W. W denotes maximum weight that thief can carry.
Output Format :
The first and only line of output contains the maximum value that thief can generate, as described in the task. 
Constraints
1 <= N <= 10^4
1<= wi <= 100
1 <= vi <= 100
Time Limit: 1 second
Sample Input 1 :
4
1 2 4 5 --> wi
5 4 8 6 --> vi
5
Sample Output 1 :
13
*/
public class Z01Knapsack {
    
	public static int knapsackRec(int[] weights, int[] values, int n, int maxWeight) {
		   
		   return knapsack01( weights, values, maxWeight, n );
	}
	
	 private static int knapsack01(int[] weights, int[] values, int maxWeight, int n) {
		
		 if ( n == 0 || maxWeight == 0 ) {
			 return 0;
		 }
		 
		 if ( weights[n-1] > maxWeight ) {
			 
			 return knapsack01( weights, values, maxWeight, n-1);
		 } 
		     // include this ith item 
			 int value1 = values[n-1] + knapsack01( weights, values, maxWeight - weights[n-1], n - 1 );
			 // don't include
			 int value2 = knapsack01( weights, values, maxWeight, n-1);
			 
		return  Math.max( value1, value2 );	 
		 
	}
	public static int knapsackM(int[] weights, int[] values, int n, int maxWeight) {
	        
		    int storage[][] = new int[ n + 1 ][ maxWeight + 1];
		    for( int i = 0; i <= n; i++ ) {
		    	for ( int j = 0; j <= maxWeight ; j++ ) {
		    		storage[i][j] = -1;
		    	}
		    }
		    
		    return knapsackM( weights, values,  maxWeight , n , storage );
	 } 

	private static int knapsackM(int[] weights, int[] values, int maxWeight, int n, int[][] storage) {

		if (n == 0 || maxWeight == 0) {
			
			storage[n][maxWeight] = 0;
			return storage[n][maxWeight];
		}

		if (storage[n][maxWeight] != -1) {

			return storage[n][maxWeight];
		}

		if (weights[n-1] > maxWeight) {

			storage[n][maxWeight] = knapsackM(weights, values, maxWeight, n - 1, storage);
			
			return storage[n][maxWeight];

		}
		// include this ith item
		int value1 = values[n-1] + knapsackM(weights, values, maxWeight - weights[n-1], n - 1, storage);
		
		// don't include
		int value2 = knapsackM(weights, values, maxWeight, n - 1, storage);

		storage[n][maxWeight] = Math.max(value1, value2);
		return storage[n][maxWeight];
	}
	
    static int knapsackDP(int[] weight, int[] value, int n, int maxWeight) {
        
    	int storage[][] = new int[ n + 1][ maxWeight + 1];
        // row = 0 and col = 0 pe initialization hoga mtlab ki base case if ( arraysize == 0 and maxWeight == 0 ) hai then return 0 
    	for( int i = 1; i <= n ; i++ ) {
    		
    		for( int j = 1 ; j <= maxWeight; j++ ) {
    			
    		    if( weight[i - 1] > j ) {
    				
    				storage[i][j] = storage[i - 1][j];
    			} else {
   // storage[n][maxWeight] = max( value[n-1] + storage[n-1][maxWeight - weight[n-1]] , storage[n-1] )
    				storage[i][j] = Math.max( value[i-1] + storage[i-1][j - weight[i - 1]],  storage[i-1][j]);
    			}
    		}
    	}
        return storage[n][maxWeight];
    
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    public static Input takeInput() throws NumberFormatException, IOException {
			
			int n = Integer.parseInt(br.readLine().trim());

			if (n == 0) {
				return (new Input(new int[0], new int[0], 0, 0));
			}

			String[] strWeights = br.readLine().trim().split(" ");
			String[] strValues = br.readLine().trim().split(" ");
			int maxWeight = Integer.parseInt(br.readLine().trim());

			int[] weights = new int[n];
			int[] values = new int[n];

			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(strWeights[i]);
				values[i] = Integer.parseInt(strValues[i]);
			}

			return (new Input(weights, values, n, maxWeight));

	    }
	    
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        
	        Input input = takeInput();

	        int n = input.getSize();
	        int[] weights = input.getWeights();
	        int[] values = input.getValues();
	        int maxWeight = input.getMaxWeight();

	        
	        System.out.println(knapsackRec(weights, values, n, maxWeight));
	        System.out.println(knapsackM(weights, values, n, maxWeight));
	        System.out.println(knapsackDP(weights, values, n, maxWeight));
	    }

}
class Input {
	private int n;
	private int[] weights;
	private int[] values;
	private int maxWeight;

	public Input(int[] weights, int[] values, int n, int maxWeight) {
		this.n = n;
		this.weights = weights;
		this.values = values;
		this.maxWeight = maxWeight;
	}

	public int getSize() {
		return this.n;
	}

	public int[] getWeights() {
		return this.weights;
	}

	public int[] getValues() {
		return this.values;
	}

	public int getMaxWeight() {
		return this.maxWeight;
	}
}
