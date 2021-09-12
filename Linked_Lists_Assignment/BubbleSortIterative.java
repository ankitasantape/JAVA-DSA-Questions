package Linked_Lists_Assignment;

import java.util.Scanner;



/*Bubble Sort (Iterative) LinkedList
Send Feedback
Given a singly linked list of integers, sort it using 'Bubble Sort.'
Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the sorted singly linked list.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Output 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90  */
public class BubbleSortIterative { // 80
    
	public static int length(LinkedListNode<Integer> head){
		
		int len = 0;
		
		while(head != null) {
		
			head = head.next;
			
			len += 1;
		
		}
		
		return len;
		
	}
    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
    	
    	
    	int n = length(head);
    	for( int i = 0; i < n - 1; i++ )
    	{	
    		LinkedListNode<Integer> prev = null, curr = head ;
    		
    		
    		for( int j = 0; j < n - i - 1; j++) {
    			
    		  if( curr.data <= curr.next.data ) {
    		       
    			  prev = curr;
      			  curr = curr.next;
      			
    		  } else {
    		    
    			      if( prev == null ) {
    				
    				             LinkedListNode<Integer> next = curr.next;
    				             head = head.next;
    				             curr.next = next.next;
    			            	 next.next = curr;
    				             prev = next;
    			      } else {
    				             LinkedListNode<Integer> next = curr.next;
    			            	 prev.next = next;
                                 curr.next = next.next;
    			    	         next.next = curr;
    			    	         prev = next;
    			}
    		} 
    	 }
      }	
	  return head;
		
	}
    public static LinkedListNode<Integer> bubble( LinkedListNode<Integer> head ) {
    	int n = length(head);
    	for( int i = 0; i < n - 1; i++ )
    	{	
    		LinkedListNode<Integer> prev = null, curr = head , next = curr.next;
    		
    		
    		for( int j = 0; j < n - i - 1; j++) {
    			
    		  if( curr.data <= curr.next.data ) {
    		       
    			  prev = curr;
      			  curr = curr.next;
      			
    		  } else {
    		    
    			      if( prev == null ) {
    				
    				            // LinkedListNode<Integer> next = curr.next;
    				             head = head.next;
    				             curr.next = next.next;
    			            	 next.next = curr;
    				             prev = next;
    			      } else {
    				            // LinkedListNode<Integer> next = curr.next;
    			            	 prev.next = next;
                                 curr.next = next.next;
    			    	         next.next = curr;
    			    	         prev = next;
    			}
    		} 
    	 }
      }	
	  return head;      	
    }
    public static void print(LinkedListNode<Integer> head) {
    	
    	while (head != null) {
    		
    		System.out.print(head.data + " ");
    		
    		head = head.next;
    	}
    }
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int data = s.nextInt();
		
	    LinkedListNode<Integer> head = null, tail = null;
		
		while( data != -1 ) {
		 
		   LinkedListNode < Integer > newNode = new LinkedListNode <Integer>(data);
		
		   if(head == null) {
			
			   head = newNode;
			   
			   tail = newNode;
		   
		   } else {
			
			   tail.next = newNode;
			   
			   tail = newNode;
		   
		   }
		   
		   data = s.nextInt();
		}
		
		
		//head = bubbleSort(head);
		head = bubble(head);
		
		print(head);
		
	    s.close();	
	}


}
