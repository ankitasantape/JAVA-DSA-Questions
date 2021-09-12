package Linked_Lists;

import java.util.Scanner;
/*Point to next increasing node
Level MEDIUM
Given singly linked list with every node having an additional “arbitrary” pointer. This arbitrary pointer is currently pointing to NULL. You need to make this arbitrary pointer of each node point to the next higher value node in the input list.
You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
 12 5 2 8 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 4.
Sample Output :
 2 5 8 12 
1) Input -  2 1 8 4 -1
   Output - 1 2 4 8
2) Input -  3 11 4 2 8 5 7 9 6 10 -1
   Output - 2 3 4 5 6 7 8 9 10 11 
3) Input -  7 20 4 17 15 18 19 9 12 6 10 5 13 21 14 2 16 8 3 11 -1
   Output - 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 */

public class PointToNextIncreasingNode {
    
	public static int length(ListNode<Integer> head){
		
		int len = 0;
		
		while(head != null) {
		
			head = head.arbitrary;
			
			len += 1;
		
		}
		
		return len;
		
	}
    public static ListNode<Integer> midPoint(ListNode<Integer> head) {
    	
    	if(head == null || head.arbitrary == null) {
    		return head;
    	}
    	ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
    	int len = length(head);
    	if(len % 2 == 0) {
    	         
    		while(fast != null && fast.arbitrary.arbitrary != null) {
    		           slow = slow.arbitrary;
    		           fast = fast.arbitrary.arbitrary;
    	         }
    	} 
    	else {
    		
    		while(fast != null && fast.arbitrary != null) {
		           slow = slow.arbitrary;
		           fast = fast.arbitrary.arbitrary;
	         }
    		
    	}
    	return slow;
    }
    public static ListNode<Integer> merge2SortedList(ListNode<Integer> head1, ListNode<Integer> head2) {
    	
    	ListNode<Integer> head3 , temp3, temp1 = head1, temp2 = head2;
    	 
    	if(head1 == null){
             return head2;
             
         }
         if(head2 == null) {
             return head1;
             
         }
    	if(temp1.data < temp2.data) {
    		head3 = temp1;
    		temp3 = temp1;
    		temp1 = temp1.arbitrary;
    		
    	} else {
    		head3 = temp2;
    		temp3 = temp2;
    		temp2 = temp2.arbitrary;
    		
    	}
    	
    	while ( temp1 != null && temp2 != null ) {
    		if ( temp1.data <= temp2.data ) {
    			temp3.arbitrary = temp1;
    			temp3 = temp1;
    			temp1 = temp1.arbitrary;
    			
    		} else if ( temp1.data > temp2.data ) {
    			temp3.arbitrary = temp2;
    			temp3 = temp2;
    			temp2 = temp2.arbitrary;
    			
    		}  
    	}
    	if( temp1 != null )
		{
			temp3.arbitrary = temp1; 
		}
		if( temp2 != null ) { 
		    temp3.arbitrary = temp2;
		}
		
		return head3;
    }
    public static ListNode<Integer> mergeSort(ListNode<Integer> head) {
	    
	      if(head == null || head.arbitrary == null) {
	    	  return head;
	      }
	      ListNode<Integer> mid = midPoint(head);
	      ListNode<Integer> midnext = mid.arbitrary;
	      mid.arbitrary = null;
	      
	      ListNode<Integer> left = mergeSort(head);
	      
	      ListNode<Integer> right = mergeSort(midnext);
	      
	      ListNode<Integer> merge = merge2SortedList(left, right);
	      
	      return merge;

    }
	public static ListNode<Integer> changeList(ListNode<Integer> head) {
		
           ListNode<Integer> temp = head;
           
           while ( temp != null ) {
        	   temp.arbitrary = temp.next;
        	   temp = temp.next;
           }

		return mergeSort(head);
	}
	 public static void print(ListNode<Integer> head) {
	    	
	    	while (head != null) {
	    		
	    		System.out.print(head.data + " ");
	    		
	    		head = head.arbitrary;
	    	}
	    	System.out.println();
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
			
			
			
			head  = changeList(head);
			 
			print(head);
			 
			s.close();

	}

}
