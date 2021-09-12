package Searching_And_Sorting;

import java.util.Scanner;
/*Code Merge Two Sorted Arrays
Send Feedback
You have been given two sorted arrays/lists(ARR1 and ARR2) of size N and M respectively, merge them into a third array/list such that the third array is also sorted.
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements of the first array/list.

Third line contains an integer 'M' representing the size of the second array/list.

Fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output Format :
For each test case, print the sorted array/list(of size N + M) in a single row, separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
0 <= M <= 10^5
Time Limit: 1 sec 
Sample Input 1 :
1
5
1 3 4 7 11
4
2 4 6 13
Sample Output 1 :
1 2 3 4 4 6 7 11 13 
Sample Input 2 :
2
3
10 100 500
7
4 7 9 25 30 300 450
4
7 45 89 90
0
Sample Output 2 :
4 7 9 10 25 30 100 300 450 500
7 45 89 90
*/
public class MergeTwoSortedArray {
	public static int[] merge(int arr1[], int arr2[]) {
    	
		int arr3[] = new int[arr1.length + arr2.length];
		int k = 0;
		int i = 0;
		int j = 0;
		while(i < arr1.length && j < arr2.length)
		{
			if(arr1[i] < arr2[j])
			{
				arr3[k] = arr1[i];
				i++;
				k++;
			} else {
				arr3[k] = arr2[j];
				j++;
				k++;
			}
		}
		while(i < arr1.length)
		{
			arr3[k] = arr1[i];
			i++;
			k++;
		}
		while(j < arr2.length)
		{
			arr3[k] = arr2[j];
			j++;
			k++;
		}
		return arr3;
		
    }
	
	// time: O(m + n)
	// space: O(1)

	// trade off against merge sort
	// time: let's L = m + n, O(L LOG_L)
	// space between O(LOG L) to O(L) due to sorting
	
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int len = m + n;
	        int i = m - 1;
	        int j = n - 1;
	        int k = len - 1;
	        
	        while (i >= 0 && j >= 0) {
	            int numi = nums1[i];
	            int numj = nums2[j];
	            
	            if (numi > numj) {
	                nums1[k] = numi;
	                i -= 1;
	            } else {
	                nums1[k] = numj;
	                j -= 1;
	            }
	            
	            k -= 1;
	        }
	        
	        while (j >= 0) {
	            int numj = nums2[j];
	            nums1[k] = numj;
	            j -= 1;
	            k -= 1;
	        }
	    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	      int t = s.nextInt();
	      while(t != 0)
	      {
	    	  int n = s.nextInt();
	    	  int arr1[] = new int[n];
	    	  for(int i = 0; i < n; i++)
	    	  {
	    		  arr1[i] = s.nextInt();
	    	  }
	    	  int m = s.nextInt();
	    	  int arr2[] = new int[n];
	    	  for(int i = 0; i < m; i++)
	    	  {
	    		  arr2[i] = s.nextInt();
	    	  }
	    	  int ans[] = merge(arr1, arr2);
	    	  for(int i = 0; i < ans.length; i++)
	    	  {
	    		  System.out.print(ans[i]+" ");
	    	  }
	    	  t--;
	      }
			s.close();
//		int arr1[] = {2,3,4,5,6};
//		int arr2[] = {1,5,9};
//		int ans[] = merge(arr1, arr2);
//		for(int i = 0; i < ans.length; i++)
//		{
//			System.out.print(ans[i] +" ");
//		}
	}

}
