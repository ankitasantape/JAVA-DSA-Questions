package hashMap;

import java.util.HashMap;
import java.util.Scanner;

/*Pairs with difference K
Send Feedback
You are given with an array of integers and an integer K. 
Write a program to find and print all pairs which have difference K.
Take difference as absolute.
Input Format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Line 3 : K
Output format :
Print pairs in different lines (pair elements separated by space). In a pair, smaller element should be printed first.
(Order of different pairs is not important)
Constraints :
0 <= n <= 10^4
Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2 5
1 4
Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
4 4
4 4
4 4
4 4
4 4
4 4

You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
Note: Take absolute difference between the elements of the array.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
The following line contains n space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of K.
Output format :
The first and only line of output contains count of all such pairs which have an absolute difference of K.
Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2
Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
6

Approach 1:
Time Complexity - O(N^2)
Space Complexity - O(1)

Eg. 2,-1,3,5,6,0,-1,2,6  k = 3     
o/p -1 2                              
    -1 2
    -1 2
    -1 2
     2 5
     0 3
     3 6
     3 6 
  How should we proceed ? 
  For any number i if I have to find out what are all possible numbers that I can pair with either 
  you can have a number which is k greater than i so you should look for a number i+k if it is there then you have a pair 
  or you should look for a number k smaller than i so you should look for a number i-k if it is there then you have a pair 
  In given eg. if I have a number 2 I have to find out what all numbers can 2 pair with either 2 can pair with 2+k which is 2+3=5 or 2-k which is 2-3=-1 
  For 2, you have to find 2+k = 2+3 = 5 from n-1 other element & you have to find 2-k = 2-3 = -1
  Go to every other n-1 element and check if it is 5 or -1 so it will take O(n) time
  Next, num = -1, now check for n-2 other element, now find  -1+k = -1+3 = 2 from n-2 & -1-k = -1-3 = -4 from n-2 other element & don't include element which are came before -1 which is the first element will not be considered so this will take O(n) time  
  You have to scan n-1 other element for element 1, for next element you have to scan n-2 other element, 
  n-1 + n-2 + n-3 + n-4 +... + 1 So, this will take O(n^2) 
Approach 2:  
  For checking whether element is present or not from n-1,n-2,n-3 other element it will take O(n) time we should improve it and try to do this work in O(1) time complexity
  So we can use hashMap to check whether the element is present or not it will take O(1) time 
  Place every element into hashMap as key and along with every element keep their frequencies as well 
  We need frequencies, we have to find out pair of 2 with -1 & 3 
  if 2 pairs up with -1 then total number of pairs will be 4 { [-1,2],[-1,2],[-1,2],[-1,2] } becoz -1 comes twice and 2 comes twice so 2*2 = 4    
*/
public class PairsWithDifferenceK {

    public static void findPairsDifferenceK(int[] input, int k){
		
    	   HashMap<Integer, Integer> map = new HashMap<>();
    	   int pairCount = 0;
    	   for( int i : input ) {
   			     // you have to find a number either k greater than i  which is i+k or k smaller than i which is i-k
   			     if ( map.containsKey(i + k) ) {
   				      // i+k jitani times present hai array me utani times hume usko print krna padega  
   				     // map.get(i+k) will get an index of i+k element which means how many times i+k is present in array utane times loop chalega  
   			    	 for (int j = 0; j < map.get(i+k); j++) {
   			    		   //increment pairCount by 1
   				           pairCount++;
   				           // print first min value of the pair and then print max value of the pair
   					       System.out.println(Math.min(i, i + k) + " " + Math.max(i, i + k));
   				      }
   			     }
   			     // if we are dealing with element at index 1 then the pair for that element will be found from index 2 to n-1 (index 1 to onward ) I will not consider index 0
   			     if( map.containsKey( i - k) && map.get( i ) > 0 ) {
   				      
   				      for (int j = 0; j < map.get(i-k); j++) {
   	   				       pairCount++; 
   					       System.out.println(Math.min(i, i - k) + " " + Math.max(i, i - k));
   			          }
                      // After printing all pairs of i with i+k & i-k then reduce the frequency of i by 1 
   		              map.put(i, map.get( i ) - 1);
   			     }
   			     if( map.containsKey( i )) {
   				
   				       map.put( i , map.get( i ) + 1);
   			
   			     } else {
   				
   				      map.put( i, 1 );
   			     }
   		 }
    	 System.out.println( pairCount );  
    }
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		findPairsDifferenceK(input, k);
		s.close();
	}

}
