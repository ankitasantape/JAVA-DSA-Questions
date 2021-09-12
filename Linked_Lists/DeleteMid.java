package Linked_Lists;

import java.util.Scanner;

/*Delete middle node
Level EASY
Given a singly linked list, delete middle node of the linked list. For example, if given linked list is 1 -> 2 -> 3 -> 4 -> 5 then linked list should be modified to 1 -> 2 -> 4 -> 5. If size of input list is even, delete the first middle node.
You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
1 2 3 4 5 6 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 6.
Sample Output :
1 2 4 5 6
*/

public class DeleteMid {
	
	public static int length(ListNode<Integer> head){
		
		int len = 0;
		
		while(head != null) {
		
			head = head.next;
			
			len += 1;
		
		}
		
		return len;
		
	}
	public static ListNode<Integer> deleteMid(ListNode<Integer> head) {

		if ( head == null || head.next == null ) {
			
			return null;
		}
		
		ListNode<Integer> slow = head;
    	ListNode<Integer> fast = head;
    	ListNode<Integer> prev = null;
    	int len = length(head);
    	if(len % 2 == 0) {
    	         while(fast != null && fast.next.next != null) {
    	        	   prev = slow; 
    		           slow = slow.next;
    		           fast = fast.next.next;
    	         }
    	} else {
    		while(fast != null && fast.next != null) {
    			   prev = slow;
		           slow = slow.next;
		           fast = fast.next.next;
	         }
    		
    	}
         prev.next = slow.next;
         
         return head;
	}
   
	public static void print(ListNode<Integer> head) {
	    	
	    	while (head != null) {
	    		
	    		System.out.print(head.data + " ");
	    		
	    		head = head.next;
	    	}
	    	System.out.println();
	 }
	
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		
		int data = s.nextInt();
		
		ListNode<Integer> head = null, tail = null;
		
		while(data != -1) {
		 
		   ListNode<Integer> newNode = new ListNode<>(data);
		
		   if(head == null) {
			
			   head = newNode;
			   
			   tail = newNode;
		   
		   } else {
			
			   tail.next = newNode;
			   
			   tail = newNode;
		   
		   }
		   
		   data = s.nextInt();
		}
		 head = deleteMid(head);
		 
		 print(head);
		
		s.close();
	}

}
