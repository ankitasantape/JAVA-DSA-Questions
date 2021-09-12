
package Arrays_1D;

import java.util.Scanner;
/*Arrange Numbers in Array

You have been given an empty array(ARR) and its size N. The only input taken from the user will be N and you need not worry about the array.
Your task is to populate the array using the integer values in the range 1 to N(both inclusive) in the order - 1,3,.......4,2.
Note:
You need not print the array. You only need to populate it.
Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains an integer 'N'.
Output Format :
For each test case, print the elements of the array/list separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4

Time Limit: 1sec
Sample Input 1 :
1
6
Sample Output 1 :
1 3 5 6 4 2
Sample Input 2 :
2
9
3
Sample Output 2 :
1 3 5 7 9 8 6 4 2
1 3 2
*/
public class ArrangeNumbers {
    
	public static void arrange(int arr[], int n) {
		int s = 0, e = n - 1, val = 1;
		if (n % 2 == 0) {
			for (; s <= e; s++, e--) {

				arr[s] = val;
				val++;

				arr[e] = val;
				val++;

			}
		} else {
			for (; s <= e; s++, e--) {

				if (s <= ((n - 1) / 2)) {
					arr[s] = val;
					val++;
				}

				if (((n - 1) / 2) < e) {
					arr[e] = val;
					val++;
				}

			}
		}
    }
	
    public static void print(int []arr, int n) {
    	for(int i = 0; i < n; i++)
    	{
    		System.out.print(arr[i]+" ");
    		
    	}
    	System.out.println();
    }
   
    public static void arrange2(int arr[], int n) {
    	int si = 0, ei = n-1;
    	int val = 1;
    	if(n % 2 == 0) {
    		while(si < ei) {
    			arr[si] = val++;
    			arr[ei] = val++;
    			si++;
    			ei--;
    		}
    	} else {
    		while(si <= ei) {
//    			traversing element from left to right
    			if(si <= n/2) {
    				arr[si] = val++;
    				si++;
    			} 
//    			traversing element from right to left
    			if(ei > n/2) {
    				arr[ei] = val++;
    				ei--;
    			}
    		}
    	}
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t != 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n]; 
        	
            arrange2(a,n);
            print(a, n);
        	t--;
        
        }        sc.close();
	}

}
