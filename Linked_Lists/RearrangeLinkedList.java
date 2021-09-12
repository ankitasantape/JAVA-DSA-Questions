package Linked_Lists;

import java.util.Scanner;

/*   Rearrange linked list
Level MEDIUM
Given a singly linked list L : L0→L1→…→Ln-1→Ln . 
Rearrange the nodes in the list so that the new formed list is : L0→Ln→L1→Ln-1→L2→Ln-2→…
You are required do this in-place without altering the nodes' values.
You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
2 5 8 12 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 4.
Sample Output :
2 12 5 8
*/
public class RearrangeLinkedList {
	
	public static ListNode<Integer> changelist(ListNode<Integer> head) {
		
		ListNode<Integer> slow = head, fast = head.next;
		
		while ( fast != null && fast.next != null ) {
			
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode<Integer> curr1 = head;
		ListNode<Integer> curr2 = slow.next;
		slow.next = null;
		
		curr2 = reverse(curr2);
		
		head = new ListNode<>(0);
		
		ListNode<Integer> curr = head;

		
		while ( curr1 != null || curr2 != null ) {
			
			if ( curr1 != null ) {
				
				curr.next = curr1;
				curr = curr.next;
				curr1 = curr1.next;
						
			}
			
			if ( curr2 != null ) {
				
				curr.next = curr2;
				curr = curr.next;
				curr2 = curr2.next;
			}
		}
		
		head = head.next;
		
		return head;
		
	}
	
	public static ListNode<Integer> reverse(ListNode<Integer> root) {
			
	    	if( root == null || root.next == null ) {
	    		
	    		return null;
	    	}
	    	
	    	ListNode<Integer> prev = null;
	    	
	    	while(root != null) {
	    		
	    		ListNode<Integer> newNode = root.next;
	    		root.next = prev;
	    		prev = root;
	    		root = newNode;
	    			
	    	}
	    	
	        return prev;
	    	
	}

    public static void print(ListNode<Integer> head) {
    	
    	while (head != null) {
    		
    		System.out.print(head.data + " ");
    		
    		head = head.next;
    	}
     }
	 public static void main(String[] args) {
        
		 Scanner s = new Scanner(System.in);
		
		int data = s.nextInt();
		
	    ListNode<Integer> head = null, tail = null;
		
		while( data != -1 ) {
		 
		   ListNode < Integer > newNode = new ListNode <> ( data  );
		
		   if(head == null) {
			
			   head = newNode;
			   
			   tail = newNode;
		   
		   } else {
			
			   tail.next = newNode;
			   
			   tail = newNode;
		   
		   }
		   
		   data = s.nextInt();
		}
		
		 
		 head = changelist(head);
		
		 print(head);
		 
		s.close();

	}
}
