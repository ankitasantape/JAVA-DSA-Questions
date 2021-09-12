package Time_And_Space_Complexity_Optimised;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Pair sum in array
Send Feedback
Given a random integer array A and a number x. Find and print the pair of elements in the array which sum to x.
Array A can contain duplicate elements.
While printing a pair, print the smaller element first.
That is, if a valid pair is (6, 5) print "5 6". There is no constraint that out of 5 pairs which have to be printed in 1st line. You can print pairs in any order, just be careful about the order of elements in a pair.
Input format :
Line 1 : Integer N (Array size)
Line 2 : Array elements (separated by space)
Line 3 : Integer x
Output format :
Line 1 : Pair 1 elements (separated by space)
Line 2 : Pair 2 elements (separated by space)
Line 3 : and so on
Constraints :
1 <= N <= 1000
1 <= x <= 100
Sample Input:
9
1 3 6 2 5 4 3 2 4
7
Sample Output :
1 6
3 4
3 4
2 5
2 5
3 4
3 4*/
public class PairSum {
	public static void pairSum(int[] arr, int num) {
		Arrays.sort(arr);
		// 1, 2, 2, 3, 3, 4, 4, 5, 6
//		int i = 0, j = arr.length - 1;
//		
//		while(i < j) {
//
//			
//			if(arr[i] + arr[j] < num) {
//				i++;
//			} else if(arr[i] + arr[j] > num) {
//				j--;
//			} else  {
//				int k = i, l = j;
//				while(arr[k] + arr[l] == num) {
//					System.out.println(arr[k] + " " + arr[l]);
//					l--;
//				}
//				i++;
//			 }
//		}
		//Best Code
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] + arr[j] == num) {
					System.out.println(arr[i] + " " + arr[j]);
				}
			}
		}
        
	}
	public static void findSum(int arr[], int num) {
		Arrays.sort(arr);
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(pairs.containsKey(arr[i])) {
				System.out.println( pairs.get(arr[i]) +" "+ arr[i]);
			} else {
				pairs.put(num - arr[i], arr[i]);
			}
		}
	}
	public static void main(String[] args) {
		int a[] = {1, 3, 6, 2, 5, 4, 3, 2, 4};
		int x = 7;
		pairSum(a, x);
		System.out.println("------------------------");
		findSum(a,x);
	}

}
