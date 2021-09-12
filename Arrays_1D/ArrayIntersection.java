package Arrays_1D;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
/*Array Intersection
Send Feedback
You have been given two integer arrays/list(ARR1 and ARR2) of size M and N, respectively. 
You need to print their intersection; 
An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, 
when there is a common value that exists in both the arrays/lists.

Note :
Input arrays/lists can contain duplicate elements.
The intersection elements printed would be in the order they appear in the first array/list(ARR1)

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the first array/list.

Second line contains 'N' single space separated integers representing the elements of the first the array/list.

Third line contains an integer 'M' representing the size of the second array/list.

Fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output format :
For each test case, print the intersection elements in a row, separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
0 <= M <= 10^5
Time Limit: 1 sec 
Sample Input 1 :
2
6
2 6 8 5 4 3
4
2 3 4 7 
2
10 10
1
10
Sample Output 1 :
2 4 3
10
Sample Input 2 :
1
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
2 1 2
Explanation for Sample Output 2 :
Since, both input arrays have two '2's, the intersection of the arrays also have two '2's. 
The first '2' of first array matches with the first '2' of the second array. 
Similarly, the second '2' of the first array matches with the second '2' if the second array.
*/
public class ArrayIntersection {
	
	// Time Complexity - O ( nm )
	public static void intersections(int arr1[], int arr2[]) {
    	
		for(int i = 0; i < arr1.length; i++)
		{
			for(int j = 0; j < arr2.length; j++)
			{
				if(arr1[i] == arr2[j])
				{
					arr2[j] = -5;
					System.out.print(arr1[i]+" ");
					break;
				}
			}
		}
		System.out.println();
    }
    
	// Time Complexity - For Sorting - O( n log n + m log m ) For Finding intersection - O ( m + n ) 
	public static void intersections1(int arr1[], int arr2[]) {
	       Arrays.sort(arr1);
	       Arrays.sort(arr2);
	       
	       int i = 0 , j = 0, count = 0;
	       for( ; i < arr1.length && j < arr2.length ; ) {
	    	   
	    	   if( arr1[i] == arr2[j] ) {
	    		   System.out.print( arr2[j] + " " );
	    		   i++;
	    		   j++;
	    	   }else if( arr1[i] > arr2[j] ){
	    		   j++;
	    		  
	    	   } else {
	    		   i++;
	    	   }
	       }
	       System.out.println(count);
	}
	// Time Complexity - O ( m + n )
	public static void intersections2(int arr1[], int arr2[]) {
	       HashMap<Integer, Integer> map = new HashMap<>();
	       for( int i : arr1 ) {
	    	   map.put(i, 1);
	       }
	       
	       for( int i = 0; i < arr2.length; i++ ) {
	    	   
	    	   if( map.containsKey( arr2[i] ) ) {
	    		   System.out.print( arr2[i] + " ");
	    		   
	    		   map.put( arr2[i], map.get( arr2[i] ) - 1);
	    		   
//	    		   if( map.get( arr2[i] ) == 0 ) {
//		    		   map.remove( arr2[i] );
//		    	   }
	    	   } 
	      }
	}
/*Input
[4,9,5]
[9,4,9,8,4]
Output
[]
Expected
[9,4]
*/	
	public static int[] intersections3(int nums1[], int nums2[]) {
		    HashSet<Integer> set = new HashSet<>();
	        
	        Map<Integer, Integer> map = new HashMap<>();
	        // Map that stores the array elements
	        for(int i=0; i< nums1.length;i++){
	            if(!map.containsKey(nums1[i])){
	                map.put(nums1[i], 1);
	            }else{
	                map.put(nums1[i], map.get(nums1[i]+1));
	            }
	        }
	        //compare and add it to the set
	        for(int i =0;i< nums2.length;i++){
	            if(map.containsKey(nums2[i])){
	                set.add(nums2[i]);
	            }
	        }
	        
			//from the set form an array and return it.
	        Iterator<Integer> it = set.iterator();
	        int[] res = new int[set.size()];
	        for(int i=0; i< set.size();i++){
	            res[i] = (Integer)it.next();
	        }
	        return res;
	       
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t != 0)
        {
            int n = sc.nextInt();
            int a1[] = new int[n];
            for(int i = 0; i < n; i++)
            {
            	a1[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int a2[] = new int[m];
            for(int i = 0; i < m; i++)
            {
            	a2[i] = sc.nextInt();
            }
            int ans[] = intersections3(a1, a2);
            for( int k : ans ) {
            	System.out.print(k +" ");
            }
        	t--;
        
        }        
        sc.close();
		
	}

}
