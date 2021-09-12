package DP_And_Memoization;

import java.util.Scanner;

/*Loot Houses
Send Feedback
A thief wants to loot houses. He knows the amount of money in each house. 
He cannot loot two consecutive houses. Find the maximum amount of money he can loot.
Input format :
The first line of input contains an integer value of 'n'. It is the total number of houses.

The second line of input contains 'n' integer values separated by a single space denoting the amount of money each house has.
Output format :
Print the the maximum money that can be looted.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
6
5 5 10 100 10 5
Sample Output 1 :
110
Sample Input 2 :
6
10 2 30 20 3 50
Sample Output 2 :
90
Explanation of Sample Output 2 :
Looting first, third, and the last houses([10 + 30 + 50]) will result in the maximum loot, and all the other possible combinations would result in less than 90.*/
public class LootHouses {

	public static int maxMoneyLootedRec(int[] houses) {

		return maxMoneyLootedRec(houses, 0);
	}

	private static int maxMoneyLootedRec(int[] houses, int i) {

		if (i >= houses.length) {
			return 0;
		}

		int max1 = houses[i] + maxMoneyLootedRec(houses, i + 2);
		int max2 = maxMoneyLootedRec(houses, i + 1);

		return Math.max(max1, max2);
	}
	
	public static int maxMoneyLootedM( int[] houses ) {
		
		int storage[] = new int[ houses.length + 1];
		for( int i = 0; i <= houses.length; i++ ) {
			
			storage[i] = -1;
		}
		
		return maxMoneyLooted( houses, 0 , storage );
	}
    
    
	private static int maxMoneyLooted(int[] houses, int i, int[] storage ) {
		
		if( i >= houses.length ) {
			storage[0] = 0;
			return storage[0];
		}
		
		if( storage[i] != -1 ) {
			return storage[i];
		}
		
		storage[i] = Math.max( maxMoneyLooted( houses, i + 1, storage ), houses[i] + maxMoneyLooted( houses, i + 2, storage ));
		
		return storage[i];
	}

	public static int maxMoneyLootedDP( int[] houses ) {
		if( houses.length == 0 ){
            return 0;
        }
	     int storage[] = new int[houses.length + 1];
	     storage[0] = houses[0];
	     storage[1] = Math.max( houses[0], houses[1] );
		 
	     for( int i = 2; i <= houses.length - 1; i++ ) {
	    	 
	    	 storage[i] = Math.max( storage[i - 1], storage[ i - 2] + houses[i] );
	     }
	     
	     return storage[houses.length-1];
	}	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner( System.in);
		
		int n = s.nextInt();
		int a[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			a[i] = s.nextInt();
		}
		
		System.out.println( maxMoneyLootedM(a) );
		System.out.println( maxMoneyLootedRec(a) );
		System.out.println( maxMoneyLootedDP(a) );
		
		s.close();
	}

}
