package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
/*Running median
Send Feedback
You are given a stream of N integers. For every i-th integer added to the running list of integers, print the resulting median.
Print only the integer part of the median.
Input Format :
The first line of input contains an integer N, denoting the number of integers in the stream.

The second line of input contains 'N' integers separated by a single space.
Output Format :
Print the running median for every integer added to the running list on a new line.
Input Constraints
1 <= N <= 10^5
1 <= Ai <= 10^5

Time Limit: 1sec
Sample Input 1 :
6
6 2 1 3 7 5
Sample Output 1 :
6
4
2
2
3
4
Explanation of Sample Output 1 :
S = {6}, median = 6
S = {6, 2} -> {2, 6}, median = 4
S = {6, 2, 1} -> {1, 2, 6}, median = 2
S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
Sample Input 2 :
5
5 4 3 2 1
Sample Output 2 :
5
4
4
3
3
*/
public class RunningMedian {
       
	public static void findMedian(int arr[])  {
		
		  PriorityQueue<Integer> max = new PriorityQueue<>( Collections.reverseOrder());
		  PriorityQueue<Integer> min = new PriorityQueue<>();
		 
		  for( int i : arr ) {
			  
			if (max.isEmpty()) {
				
				max.add(i);
			
			} else if (i < max.peek()) {
				
				max.add(i);
				
				if ((max.size() - min.size()) > 1) {
					
					int p = max.remove();
					min.add(p);
				}
			} else {
				
				min.add(i);
				
				if ((min.size() - max.size()) > 1) {
				
					int p = min.remove();
					max.add(p);
				}
			}
			
			if( min.size() > max.size() ) {
				
				System.out.println(min.peek());
			
			} else if( max.size() > min.size() ) {
				
				System.out.println(max.peek());
			
			} else {
				
				System.out.println((min.peek() + max.peek()) / 2);
			}
			
		}
		  
		  
	}
	
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    private static int[] takeInput() throws NumberFormatException, IOException {
	    	int n = Integer.parseInt(br.readLine().trim());

	    	int[] arr = new int[n];

	    	String[] vals = br.readLine().trim().split(" ");

	    	for (int i = 0; i < n; i++) {
	    		arr[i] = Integer.parseInt(vals[i].trim());
	    	}

	    	return arr;
	    }  


	    public static void main(String[] args) throws NumberFormatException, IOException {
	    	
	    	int[] arr = takeInput();
			findMedian(arr);

	    }
}
