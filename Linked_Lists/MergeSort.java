package Linked_Lists;

import java.util.Scanner;

/*       Code : Merge Sort
Send Feedback
 Given a singly linked list of integers, sort it using 'Merge Sort.'
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
-5 1 5 9 10 67 89 90        */
public class MergeSort {
    public static int length(LinkedListNode<Integer> head){
		
		int len = 0;
		
		while(head != null) {
		
			head = head.next;
			
			len += 1;
		}
		return len;
		
	}
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
    	if(head == null || head.next == null) {
    		return head;
    	}
    	LinkedListNode<Integer> slow = head;
    	LinkedListNode<Integer> fast = head;
    	int len = length(head);
    	if(len % 2 == 0) {
    	         while(fast != null && fast.next.next != null) {
    		           slow = slow.next;
    		           fast = fast.next.next;
    	         }
    	} else {
    		while(fast != null && fast.next != null) {
		           slow = slow.next;
		           fast = fast.next.next;
	         }
    	}
    	return slow;
    }
    public static LinkedListNode<Integer> merge2SortedList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
    	LinkedListNode<Integer> head3 , temp3, temp1 = head1, temp2 = head2;
    	 
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		if (temp1.data < temp2.data) {

			head3 = temp1;
			temp3 = temp1;
			temp1 = temp1.next;

		} else {
    		
    		head3 = temp2;
    		temp3 = temp2;
    		temp2 = temp2.next;
    		
    	}
    	
    	while ( temp1 != null && temp2 != null ) {
    		
    		if ( temp1.data <= temp2.data ) {
    			
    			temp3.next = temp1;
    			temp3 = temp1;
    			temp1 = temp1.next;
    			
    		} else if ( temp1.data > temp2.data ) {
    			
    			temp3.next = temp2;
    			temp3 = temp2;
    			temp2 = temp2.next;
    			
    		}  
    	}
    	if( temp1 != null )
		{
			temp3.next = temp1; 
		}
		if( temp2 != null ) { 
		    
			temp3.next = temp2;
		}
		
		return head3;
    }
/* Time Complexity: O(nlogn), where n is the number of nodes in linked list. The algorithm can be split into 2 phases, Split and Merge.
 * Let's assume that n is power of 22. For n = 16, the split and merge operation in Top Down fashion can be visualized as follows

Split :

The recursion tree expands in form of a complete binary tree, splitting the list into two halves recursively. 
The number of levels in a complete binary tree is given by log2(n)
​For n=16, number of splits = log2(16) = 4 

Merge :

At each level, we merge n nodes which takes O(n) time. For n = 16, we perform merge operation on 16 nodes in each of the 4 levels.
So the time complexity for split and merge operation is O(nlogn)

Space Complexity: O(logn), where n is the number of nodes in linked list.
Since the problem is recursive, we need additional space to store the recursive call stack. 
The maximum depth of the recursion tree is logn
        TOP - DOWN APPROACH                                                         */
	
    public static LinkedListNode<Integer> SortList(LinkedListNode<Integer> head) {
		     // print(head);
		      if(head == null || head.next == null) {
		    	  return head;
		      }
		      LinkedListNode<Integer> mid = midPoint(head);
		      LinkedListNode<Integer> midnext = mid.next;
		      mid.next = null;
		      
		      LinkedListNode<Integer> left = SortList(head);
		      
		      LinkedListNode<Integer> right = SortList(midnext);
		      
		      LinkedListNode<Integer> merge = merge2SortedList(left, right);
		      
		      return merge;
	}
	public static void print(LinkedListNode<Integer> head) {
	    	
	    	while (head != null) {
	    		
	    		System.out.print(head.data + " ");
	    		
	    		head = head.next;
	    	}
	    	System.out.println();
	 }
	 
	 public static LinkedListNode<Integer> takeInput(){
		 
		 Scanner s = new Scanner(System.in);
			
			int data = s.nextInt();
			
		    LinkedListNode<Integer> head = null, tail = null;
			
			while( data != -1 ) {
			 
			   LinkedListNode < Integer > newNode = new LinkedListNode <> ( data  );
			
			   if(head == null) {
				
				   head = newNode;
				   
				   tail = newNode;
			   
			   } else {
				
				   tail.next = newNode;
				   
				   tail = newNode;
			   
			   }
			   
			   data = s.nextInt();
			}
			
			s.close();
			return head;
	 }
	 public static void main(String[] args) {
       
		LinkedListNode<Integer> head = takeInput();
		
		head  = SortList(head);
		 
		print(head);
	 }
/*Approach 2: Bottom Up Merge Sort
Intuition

The Top Down Approach for merge sort uses O(logn) extra space due to recursive call stack. 
Let's understand how we can implement merge sort using constant extra space using Bottom Up Approach.

The Bottom Up approach for merge sort starts by splitting the problem into the smallest subproblem and iteratively merge the result to solve the 
original problem.

First, the list is split into sublists of size 1 and merged iteratively in sorted order. The merged list is solved similarly.

The process continues until we sort the entire list.

This approach is solved iteratively and can be implemented using constant extra space. Let's look at the algorithm to implement merge sort in Bottom 
Up Fashion.

Algorithm :

Assume, n is the number of nodes in the linked list.

Start with splitting the list into sublists of size 1. Each adjacent pair of sublists of size 1 is merged in sorted order. After the first 
iteration, we get the sorted lists of size 2. 
A similar process is repeated for a sublist of size 2. In this way, we iteratively split the list into sublists of size 1,2,4,8.. and 
so on until we reach n.

To split the list into two sublists of given size beginning from start, we use two pointers, mid and end that references to the start and end of 
second linked list respectively. 
The split process finds the middle of linked lists for the given size.

Merge the lists in sorted order as discussed in Approach 1

As we iteratively split the list and merge, we have to keep track of the previous merged list using pointer tail and the next sublist to be sorted 
using pointer nextSubList.

For the linked list = [10,1,30,2,5], the following figure illustrates the merge sort process using a Bottom Up approach.

Complexity Analysis :

Time Complexity: O(nlogn), where n is the number of nodes in linked list. Let's analyze the time complexity of each step:
Count Nodes - Get the count of number nodes in the linked list requires O(n) time.

Split and Merge - This operation is similar to Approach 1 and takes O(nlogn) time. For n = 16, the split and merge operation in Bottom Up fashion 
can be visualized as follows

This gives us total time complexity as O(n) + O(n log n) = O(n log n)

Space Complexity: O(1) We use only constant space for storing the reference pointers tail ,nextSubList etc.*/
}
