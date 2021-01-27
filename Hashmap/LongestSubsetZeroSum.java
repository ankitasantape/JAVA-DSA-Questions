package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*Longest subset zero sum
Send Feedback
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
NOTE: You have to return the length of longest subarray .
Input Format :
Line 1 : Contains an integer N i.e. size of array

Line 2 : Contains N elements of the array, separated by spaces
Output Format
 Line 1 : Length of longest subarray 
Constraints:
0 <= N <= 10^8
Sample Input :
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output :
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897 
Input :
20
-223 -163 56 -375 352 148 -167 421 -365 189 20 -127 -283 187 218 -435 -123 388 -171 -372 
Output: 11
             sum=x        sum=x  
      -----------i------------j
if we are reach at index i and sum of all element till i is x and sum of all element till j is x, from starting till i and starting till j can we conclude with this information  
the sum of element from i+1 to j is zero becoz we have achieved the same sum again so that means the element in between add upto to zero which is why I have x again so this is the important element
the elements between i+1 to j this is one candidate for our answer
How should we approach?
We should find sum at every element as we proceed calculating sum now encounter the same sum again then you have an information that sum of elements in between is actually zero 
So we should keep a track whether a sum is appeared again then you have a subset continuous subset whose sum is zero 
How will we keep a track whether a sum is repeating again or not & last at which index that sum is appeared we should keep that index also where that sum occurred becoz index i is also important for us
Since I have to look for sum whether that sum have already been calculated or not so what should we do
Keep a map   
Eg.   6, 3, -1, 2, -4, 3, 1, -2, 2, 0 
enter updated sum into map and its index 
keys        value(index)
6              0           sum till index 0 is 6
9              1           sum till index 1 is 9
8              2
10             3
-----------------

6              0 [ 4 ] don't insert 6 and don't update index 4 into the map becoz sum=6 which is already present in map so sum of element in between is zero, curr 6 came at index 4 and earlier 6 came at index 0 so there are 4 element in between that sum to zero, so length of subset from i=1 to i=4 is length = 4 
9              5 sum=9 already present inside map 
10             6 sum=10 already present inside map
8              7 sum=8 already present inside map
10             8
10             9
   Think about some corner cases, one boundry case is actually consider Eg. { 6,1,5,-8,-4,2 } so longest subset that sum to zero is { 6,1,5,8,-4,2 }         
keys  value
6       0
7       1 
12      2
4       3
0       4   Here, sum is zero, how should we print maxLen and there is no occurrence of zero before
we should apply check
if sum == 0 then
 first initialize len with len = i + 1 = 3 + 1 = 4
 compare len with maxLen if maxLen < len then update maxLen
 
*/
public class LongestSubsetZeroSum {
    // Find out longest consecutive subset whose sum is zero  one thing you have to take care of about is subset can contain discontinued element as well 
	public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) 
   	{
		int maxLen = 0;
		int i = 0,sum = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for( int val : arr) { // [ 6, 3, -1, 2, -4, 3, 1, -2, 2, 0 ]
		    // add every element with given sum
		    sum += val; // sum = 0 + 6 = 6 + 3 = 9 + (-1) = 8 + 2 = 10 - 4 = 6  
		    // if sum is found zero then increment length by 1 and update maxLen 
		    if( sum == 0 ) { // sum = 0
		       int len = i + 1;  // increment length by 1 len = 0 + 1 = 1
		       if( maxLen < len ) { // if maxLen less than len then update maxLen
		    	   maxLen = len; // maxLen = 1;
		       }
		    }
		    if( map.containsKey( sum )) { //sum = 6 which is already present inside map so one subset mil gya so we have to get the length of that subset and change the maxLen if maxLen is smaller than the length 
		    	int len = i - map.get(sum ); // len = 4 - 0 = 4
		    	if( maxLen < len ) { // if 1 < 4
		    		maxLen = len;   // maxLen = 4
		    	}
		    	
		    } else {
		    	
		    	map.put( sum, i ); //insert sum into map with index at which index we get that sum 6 , 9 , 8, 10 
		    }
			i++; // increment the index of array by 1
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();

		int size = scan.nextInt();
		for(int i = 0; i < size; i++)
			arr.add(scan.nextInt());

		System.out.println(lengthOfLongestSubsetWithZeroSum(arr));
		scan.close();
	}

}
