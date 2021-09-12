package Linked_Lists;

import java.util.Scanner;

/*Rearrange odd and even places
Level MEDIUM
Rearrange and return a linked list in such a way that all odd position nodes are together and all even positions node are together
You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
 1 2 3 4 5 6 7 8 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 4.
Sample Output :
 1 3 5 7 2 4 6 8
Input - 33749 -1
Output - 33749 

Input - 1 3 5 7 9 10 11 12 -1
Output - 1 5 9 11 3 7 10 12
*/
public class RearrangeOddAndEvenPlaces {
	public static ListNode<Integer> changelist(ListNode<Integer> head) {
		
		if( head == null || head.next == null) {
			
			return head;
		}
		
		ListNode<Integer> oddH = null, oddT = null, evenT = null, evenH = null;
		
		int count = 1;
		
		while(head != null ) {
			
    	    if( count % 2 != 0 ) {
				
				if ( oddH == null ) {
					
					oddH = head;
					oddT = head;
			
				} else {
				
					oddT.next = head;
					oddT = head;
			
				}
				
				
				
			} else  {
				
				if ( evenH == null ) {
					
					evenH = head;
					evenT = head;
					
				} else {
					
					evenT.next = head;
					evenT = head;
				}
				
			}
			head = head.next;
			
			count++;
		}
		if(oddT != null ) {
		   
			oddT.next = null;
		}
		if(evenT != null ) {
		    
			evenT.next = null;
		}
		if(oddT != null && evenH != null) {
		  
			oddT.next = evenH;
		} 
		if(oddH == null ) {
			
	        oddH = evenH;
		}
		    	
		return oddH;

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
