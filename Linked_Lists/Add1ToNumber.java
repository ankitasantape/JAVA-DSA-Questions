package Linked_Lists;

import java.util.Scanner;

/*  Add one to linked list
Level MEDIUM
A number is represented in the form of a linked list such that each digit corresponds to a node in input linked list. You need to add 1 to it and return the updated list.
For example 1234 is represented as (1-> 2-> 3 -> 4) and adding 1 to it should change it to (1 -> 2 -> 3 -> 5).
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
4 2 9 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 4.
Sample Output :
4 3 0
*/

public class Add1ToNumber { // Test2 - Next Number

	public static ListNode<Integer>  changelist(ListNode<Integer> head) {
		
		head = reverse(head);
		
		ListNode<Integer> res = head, temp = null ;
		
		int cy = 1, sum;
		
		while ( head != null ) {
			
			//add cy to head.data and store it to sum
			sum = cy + head.data;
		    
			//find carry
			cy = ( sum >= 10 ) ? 1 : 0;
			
			//Update sum it could be >=10 or <10
			sum = sum % 10;
			
			//update data 
			head.data = sum;
			
			// store value in temp for future use
			temp = head;
			head = head.next;
		}
		
		if ( cy > 0 ) {
			
			ListNode<Integer> newNode = new ListNode<>(cy);
			temp.next = newNode;
		}
		
		
		
		return reverse(res) ;
		

	}
   public static ListNode<Integer> reverse(ListNode<Integer> head) {
	   
	   if ( head == null || head.next == null ) {
		   
		   return head;
	   }
	   ListNode<Integer> prev = null;
	   
	   while ( head != null ) {
		   ListNode<Integer> newNode = head.next;
		   head.next = prev;
		   prev = head;
		   head = newNode;
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
		 
		   ListNode < Integer > newNode = new ListNode <Integer>(data);
		
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
