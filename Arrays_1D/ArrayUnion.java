package Arrays_1D;

import java.util.Scanner;
/*Given two arrays A and B of size N and M respectively. The task is to find union between these two arrays.
Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.
Example 1:
Input:
5 3
1 2 3 4 5
1 2 3
Output: 
5
Explanation: 
1, 2, 3, 4 and 5 are the
elements which comes in the union set
of both arrays. So count is 5.
Example 2:

Input:
6 2 
85 25 1 32 54 6
85 2 

Output: 
7
Explanation: 
85, 25, 1, 32, 54, 6, and
2 are the elements which comes in the
union set of both arrays. So count is 7.
Your Task:
Complete doUnion funciton that takes a, n, b, m as parameters and returns the count of union elements of the two arrays.The printing is done by the driver code.

Constraints:
1 ≤ N, M ≤ 105
1 ≤ A[i], B[i] < 105

Expected Time Complexity : O((n+m)log(n+m))
Expected Auxilliary Space : O(n+m)
*/
public class ArrayUnion {
/*Output: 
1 2 3 4 5 6 7 
Time Complexity : O(m + n)
*/	
	 static int printUnion(int arr1[], int arr2[], int m, int n) 
	    { 
	        int i = 0, j = 0; 
	        while (i < m && j < n) { 
	            if (arr1[i] < arr2[j]) 
	                System.out.print(arr1[i++] + " "); 
	            else if (arr2[j] < arr1[i]) 
	                System.out.print(arr2[j++] + " "); 
	            else { 
	                System.out.print(arr2[j++] + " "); 
	                i++; 
	            } 
	        } 
	  
	        /* Print remaining elements of  
	         the larger array */
	        while (i < m) 
	            System.out.print(arr1[i++] + " "); 
	        while (j < n) 
	            System.out.print(arr2[j++] + " "); 
	  
	        return 0; 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        int arr1[] = { 1, 2, 4, 5, 6 }; 
	        int arr2[] = { 2, 3, 5, 7 }; 
	        int m = arr1.length; 
	        int n = arr2.length; 
	        printUnion(arr1, arr2, m, n); 
	    } 

}
