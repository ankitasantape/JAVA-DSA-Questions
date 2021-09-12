package Linked_Lists;

import java.util.Scanner;

/*Delete a given node
Level EASY
Write a function to delete a node with given data (i.e. integer x) in a doubly linked list. Return the head of new list.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Line 2 : Integer x
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
1 2 3 4 5 6 -1
3
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 6.
Sample Output :
1 2 4 5 6
*/
public class DeleteAGivenNode {
	public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> n) {
		
		if ( n.data < 0)
		{
			return head;
		}
		if ( head == null || head.forw == null ) {
			
			return null;
		}
		
		ListNode<Integer> temp = head;
		ListNode<Integer> prev = null;
		
		while( temp != null && temp.data == n.data ){
            head = temp.next ;
            temp = head;
        }
		
		while( temp != null ) {
		
		       while ( temp.data != n.data && temp != null  ) {
			           prev = temp;
			           temp = temp.forw;
		       }
		  
		       if( temp == null ) {
			           return null;
		       }
		  
               prev.forw =  temp.forw;
            
               temp = prev.forw;
		  
		}
        return head;
	}
   public static void print(ListNode<Integer> head) {
    	
    	while (head != null) {
    		System.out.print(head.data + " ");
    		head = head.forw;
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
			
			   tail.forw = newNode;
			   
			   tail = newNode;
		   
		   }
		   
		   data = s.nextInt();
		}
		
		int n = s.nextInt();
		
		ListNode<Integer> newNode = new ListNode<>(n);
		
		head = deleteNode(head, newNode);
		
		 print(head);
		 s.close();

	}

	

}
