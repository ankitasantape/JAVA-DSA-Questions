package hashMap;

import java.util.HashMap;

/*Maximum Frequency Number
Send Feedback
You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Output Format :
Most frequent element
Constraints :
0 <= N <= 10^8
Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6 
Sample Output 1 :
2
Sample Input 2 :
3
1 4 5
Sample Output 2 :
1
*/
public class MaximumFrequencyNumber {

	public static int maxFrequencyNumber(int[] arr){
		HashMap<Integer, Integer> output = new HashMap<>();

		int max = 0;
		for( int i : arr ) {
			
			if( output.containsKey( i )) {
				
				output.put( i, output.get(i) + 1 );
			
			} else {
				
				output.put( i, 1);
			}
			
		}
		int res = Integer.MIN_VALUE;
		for( int i : arr ) {
			// if frequency of current element is greater than maximum Frequency
			if( output.get(i) > max ) {
				// store maximum frequency into max
				max = output.get(i);
				// store element i into res having maximum frequency
				res = i;
			}
		}
		// return maximum frequency element in array
		return res;
	}
	
	public static void main(String[] args) {
		int a[] = {2, 12, 2, 11, 12, 2, 1, 2, 2, 11, 12, 2, 6, };
		int ans = maxFrequencyNumber( a );
		System.out.println(ans);
	}

}
