package Arrays_1D;

import java.util.Scanner;
/*Sort 0 1
Send Feedback
You have been given an integer array/list(ARR) of size N that contains only integers, 0 and 1. Write a function to sort this array/list. Think of a solution which scans the array/list only once and don't require use of an extra array/list.
Note:
You need to change in the given array/list itself. Hence, no need to return or print anything. 
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers(all 0s and 1s) representing the elements in the array/list.
Output format :
For each test case, print the sorted array/list elements in a row separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
Time Limit: 1 sec
Sample Input 1:
1
7
0 1 1 0 1 0 1
Sample Output 1:
0 0 0 1 1 1 1
Sample Input 2:
2
8
1 0 1 1 0 1 0 1
5
0 1 0 1 0
Sample Output 2:
0 0 0 1 1 1 1 1
0 0 0 1 1 
*/
public class SortZeroAndOne {
	public static void sortZeroesAndOne(int[] arr) {
		//Code 1
//       int count = 0;
//       for(int i = 0; i < arr.length; i++)
//       {
//    	   if(arr[i] == 0)
//    	   {
//    		   count++;
//    	   }
//       }
//       System.out.println(count);
//       for(int i = 0; i < count; i++)
//       {
//    	  arr[i] = 0;
//       }
//       for(int i = count; i < arr.length; i++)
//       {
//    	   arr[i] = 1;
//       }
//        for(int k = 0; k < arr.length; k++)
//        {
//        	System.out.print(arr[k] + " ");
//        }
		//Code 2
//		int j = arr.length-1;
//        for(int i = 0; i < j;  )
//        {
//        	if(arr[i] == 0)
//        	{
//        	   i++;
//        	} else if(arr[i] == 1)
//        	{
//        		if(arr[j] == 1 )
//        		{
//        			j--;
//        		} else if(arr[j] == 0)
//        		{
//        			swap(arr,i, j);
//        		}
//        	}
//          }
//        System.out.println();
//        for(int i = 0; i < arr.length; i++)
//        {
//        	System.out.print(arr[i]+" ");
//        }
        //Code 3 Traversing array only one's
		 int j = -1; 
	        for (int i = 0; i < arr.length; i++) 
	        { 
	  
	            if (arr[i] < 1) 
	            { 
	                j++; 
	               	swap(arr, j, i);
	        	}
	        }
		
		
	}
    public static void swap(int arr[], int i, int j)
    {
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
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
           
            sortZeroesAndOne(a);
            for(int k = 0; k < a.length; k++)
    		{
    			System.out.print(a[k]+" ");
    		}
            
        	t--;
        
        }        sc.close();

	}

}
