package Arrays_1D;

import java.util.Arrays;
import java.util.Scanner;
/*Triplet Sum
Send Feedback
You have been given a random integer array/list(ARR) and a number X. Find and return the triplet(s) in the array/list which sum to X.
Note :
Given array/list can contain duplicate elements.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.

Third line contains an integer 'X'.
Output format :
For each test case, print the total number of triplets present in the array/list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 50
0 <= N <= 10^2
0 <= X <= 10^9
Time Limit: 1 sec
Sample Input 1:
1
7
1 2 3 4 5 6 7 
12
Sample Output 1:
5
Sample Input 2:
2
7
1 2 3 4 5 6 7 
19
9
2 -5 8 -6 0 5 10 11 -3
10
Sample Output 2:
0
5


 Explanation for Input 2:
Since there doesn't exist any triplet with sum equal to 19 for the first query, we print 0.

For the second query, we have 5 triplets in total that sum up to 10. They are, (2, 8, 0), (2, 11, -3), (-5, 5, 10), (8, 5, -3) and (-6, 5, 11)
*/
public class TripletSum {
/*Method 1: This is the naive approach towards solving the above problem.  
Approach: A simple method is to generate all possible triplets and compare the sum of every triplet with the given value. The following code implements this simple method using three nested loops.
Algorithm: 
Given an array of length n and a sum s
Create three nested loop first loop runs from start to end (loop counter i), second loop runs from i+1 to end (loop counter j) and third loop runs from j+1 to end (loop counter k)
The counter of these loops represent the index of 3 elements of the triplets.
Find the sum of ith, jth and kth element. If the sum is equal to given sum. Print the triplet and break.
If there is no triplet, then print that no triplet exist.
Complexity Analysis: 
Time Complexity: O(n3). 
There are three nested loops traversing the array, so the time complexity is O(n^3)
Space Complexity: O(1). 
As no extra space is required.
*/
	 public static int findTriplet(int[] arr, int x) {
	    	int count = 0;
	    	for(int i = 0; i < arr.length-2; i++) 
	    	{
	    		for(int j = i + 1; j < arr.length - 1; j++)
	    		{
	    			for(int k = j + 1; k < arr.length; k++)
	    			{
	    				if((arr[i] + arr[j] + arr[k]) == x)
	    				{
	    					count = count + 1;
	    				}
	    			}
	    		}
	    	}
	    	
	    	return count;
	}
/*Method 2: This method uses sorting to increase the efficiency of the code. 
Approach: By Sorting the array the efficiency of the algorithm can be improved. This efficient approach uses the two-pointer technique. Traverse the array and fix the first element of the triplet. Now use the Two Pointers algorithm to find if there is a pair whose sum is equal to x – array[i]. Two pointers algorithm take linear time so it is better than a nested loop.
Algorithm : 
Sort the given array.
Loop over the array and fix the first element of the possible triplet, arr[i].
Then fix two pointers, one at i + 1 and the other at n – 1. And look at the sum, 
If the sum is smaller than the required sum, increment the first pointer.
Else, If the sum is bigger, Decrease the end pointer to reduce the sum.
Else, if the sum of elements at two-pointer is equal to given sum then print the triplet and break.
Complexity Analysis: 
Time complexity: O(N^2). 
There are only two nested loops traversing the array, so time complexity is O(n^2). Two pointers algorithm takes O(n) time and the first element can be fixed using another nested traversal.
Space Complexity: O(1). 
As no extra space is required.
*/ 
	public static void findTriplet2(int[] arr, int sum) {
		Arrays.sort(arr);
		int count = 0 , m, r;
		for (int l = 0; l < arr.length - 2; l++) { 
			  
            // To find the other two elements, start two index variables 
            // from two corners of the array and move them toward each 
            // other 
            m = l + 1; // index of the first element in the remaining elements 
            r = arr.length - 1; // index of the last element 
            while (l < r) { 
                if (arr[l] + arr[m] + arr[r] == sum) { 
                	count++;
                    System.out.print("Triplet "+ count +" is : "+ arr[l] + ", " + arr[m] + ", " + arr[r]); 
                    break;
                } 
                else if (arr[l] + arr[m] + arr[r] < sum) 
                    l++; 
  
                else // A[i] + A[l] + A[r] > sum 
                    r--; 
            } 
        } 
//		System.out.println(count);
	}
/*Method 3: This is a Hashing based solution. 
Approach: This approach uses extra space but is more simpler than the two pointers approach. Run two loops outer loop from start to end and inner loop from i+1 to end. Create a hashmap or set to store the elements in between i+1 to j-1. So if the given sum is x, check if there is a number in the set which is equal to x – arr[i] – arr[j]. If yes print the triplet. 
Algorithm: 
Traverse the array from start to end. (loop counter i)
Create a HashMap or set to store unique pairs.
Run another loop from i+1 to end of the array. (loop counter j)
If there is an element in the set which is equal to x- arr[i] – arr[j], then print the triplet (arr[i], arr[j], x-arr[i]-arr[j]) and break
Insert the jth element in the set.
*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t != 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
            {
            	a[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            int res = findTriplet(a , x);
            System.out.println(res);
            findTriplet2(a , x);
        	t--;
        
        }        sc.close();

	}

}
