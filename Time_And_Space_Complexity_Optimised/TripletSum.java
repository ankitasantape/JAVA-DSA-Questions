package Time_And_Space_Complexity_Optimised;

import java.util.Arrays;

import java.util.HashSet;

/*   Triplet sum

Given a random integer array and a number x. Find and print the triplets of elements in the array which sum to x.
While printing a triplet, print the smallest element first.
That is, if a valid triplet is (6, 5, 10) print "5 6 10". There is no constraint that out of 5 triplets which have to be printed on 1st line. 
You can print triplets in any order, just be careful about the order of elements in a triplet.
Input format :
Line 1 : Integer N (Array Size)
Line 2 : Array elements (separated by space)
Line 3 : Integer x
Output format :
Line 1 : Triplet 1 elements (separated by space)
Line 2 : Triplet 3 elements (separated by space)
Line 3 : and so on
Constraints :
1 <= N <= 1000
1 <= x <= 100
Sample Input:
7
1 2 3 4 5 6 7 
12
Sample Output ;
1 4 7
1 5 6
2 3 7
2 4 6
3 4 5  */
public class TripletSum {
	public static void FindTriplet(int[] arr, int x){
	 
		Arrays.sort(arr);
		
		int start , last;
	    
		for(int i = 0; i < arr.length - 2; i++) {
			
		      start = i + 1;
		
		      last = arr.length - 1;
		
		      while( start < last) {
		    	 
		    	 if(arr[i] + arr[start] + arr[last] < x) {
			             
		    		 start++;
		         } 
		         else if (arr[i] + arr[start] + arr[last] > x) {
			          
		        	 last--;
		         } 
		         else if(arr[i] + arr[start] + arr[last] == x) {
			
				            System.out.println(arr[i] +" "+ arr[start]+" "+arr[last]);
			                start++;
			                last--;
			      }
			
			        
		      }
	     }
		
	}
	//Time Complexity - O(n^2) Space Complexity - O(n)
	private static void tripletSum(int a[], int x) {
		  
		int n = a.length;
		
		for(int i = 0; i <= n-2; i++) {
		
			HashSet<Integer> hm = new HashSet<>();
			
			for(int j = i + 1; j < n; j++ ) {
			
				int remSum = x - (a[i] + a[j]);
				
				if(hm.contains(remSum)) {
				
					System.out.println(a[i]+" "+a[j]+" "+remSum);
				} else {
					hm.add(a[j]);
				}
			}
		 }
	}
	private static void SumOf3Digits(int arr[], int x, int n) {
		Arrays.sort(arr);
		
		for(int i = 0; i < n - 2; i++ ) {
			int l = i + 1;
			int r = n - 1;
			int sum = arr[i];
			
			while( l < r) {
				if (sum + arr[l] + arr[r] == x ) {
					System.out.println(sum + " " + arr[l] + " "+ arr[r]);
					l++;
					r--;
				}
				
				else  if ( sum + arr[l] + arr[r] < sum) {
					l++;
				} else {
					r--;
				}
 
			}
		}
		
	}
	public static boolean findTripletSum(int []arr, int x) {
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length - 2; i++) {
			
			if(findTwoSum(arr, -arr[i], i+1)) {
				
				return true;
			}
		}
		return false;
	}
	//Using Two Pointer Algorithm
	public static boolean findTwoSum(int arr[], int x, int i) {
		
		int  j = arr.length - 1;
	    
		while(i < j) {
	    	
			if(arr[i] + arr[j] < x) {
	    		
	    		i++;
	    	} 
	    	else if(arr[i] + arr[j] > x) {
	    		
	    		j--;
	    	} 
	    	else {
	    		
	    		return true;
	    	}
	    }
	    return false;
	}
	//Best Code Run By Coding Ninja Platform
	public static void result(int arr[], int x) {
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) 
    	{
    		for(int j = i + 1; j < arr.length; j++)
    		{
    			for(int k = j + 1; k < arr.length; k++)
    			{
    				if((arr[i] + arr[j] + arr[k]) == x)
    				{
    					System.out.println(arr[i] +" "+ arr[j]+" "+arr[k]);
    				}
    			}
    		}
    	}
    	
    

	}
	public static void main(String[] args) {
           int a[] = {1, 2, 3, 4, 5, 6, 7};
           int x = 12;
         // FindTriplet(a, x);
         //tripletSum(a,x);
          // SumOf3Digits(a,x,a.length);
           result(a, x);
	}

}
