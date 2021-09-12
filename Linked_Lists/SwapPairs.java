package Linked_Lists;

import java.util.Scanner;
/*Pair Swap
Level EASY
Given a linked list l1->l2->l3->l4->and so on. Write a program that will swap pairs (l1, l2), (l3, l5), (l6, l9) ......etc.
You just need to return the head of new linked list, don't print the elements.
Note: If pair of a node does not exist then leave the node as it is.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
 1 2 3 4 5 -1
Sample Output :
 2 1 5 4 3
 */
public class SwapPairs {

	public static ListNode<Integer> PairSwap(ListNode<Integer> head){
		
		if ( head == null || head.next == null ) {
			
			return head;
		}
		
		ListNode<Integer> newNode = head.next;
		head.next = newNode.next;
		newNode.next = head;
		
		ListNode<Integer> firstpre = head, secondpre = head.next, first = null, second = null;
		
		int count = 2;
		
		while ( true ) {
			
			int temp = 1;
			
			while ( secondpre != null && secondpre.next != null && temp != count ) {
				
				temp++;
				
				secondpre = secondpre.next;
			}
			
			if ( secondpre == null || secondpre.next == null ) {
				
				return newNode;
			}
			
			first = firstpre.next;
			second = secondpre.next;
			
			firstpre.next = second;
			secondpre.next = first;
			
			ListNode<Integer> tempnode = second.next;
			second.next = first.next;
			first.next = tempnode;
			
			count++;
			
			secondpre = tempnode;
			firstpre = first;
			
		}
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
		
		 
		 head = PairSwap(head);
		
		 print(head);
		 
		s.close();

	}


}
