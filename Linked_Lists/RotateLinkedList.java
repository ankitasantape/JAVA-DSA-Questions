package Linked_Lists;

import java.util.Scanner;

/*Rotate Linked List
Level EASY
Rotate linked list by n positions in clockwise direction. You are given a linked list and an integer n, return the n-rotated linked list.
You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length L (separated by space and terminated by -1)
Line 2 : Integer n
Output format :
Updated list elements (separated by space)
Constraints :
1 <= L <= 10^4
Sample Input :
1 2 3 4 5 6 -1
2
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 6.
Sample Output :
5 6 1 2 3 4
*/
public class RotateLinkedList {
	
    public static int length(ListNode<Integer> head){
		
		int len = 0;
		
		while(head != null) {
		
			head = head.next;
			
			len += 1;
		
		}
		
		return len;
		
	}
	public static ListNode<Integer> changeList(ListNode<Integer> head, int n) {
		
		if( n == 0 || n == length(head) ) {
			   return head;
		   }
		   
		   if(head == null) {
			   return null;
		   }
	       ListNode<Integer> curr = head;
	      
	       ListNode<Integer> tail = head;
	       
	       int len = length(head);
	       
           if ( n > len) {
              
        	   n = n % len;
           }
           
	       int i = 1, count = len - n; // 7 - 4 = 3
	       
	       while( i < count) {
	    	   
	    	   curr = curr.next;
	    	   i++;
	       }
	      
	       ListNode<Integer> newNode = curr.next;
	       
	       head = curr.next;
	       
	       curr.next = null;
	       
	       while(newNode.next != null) {
	    	
	    	   newNode = newNode.next;
	       }
	      
	       newNode.next = tail;
	      
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
		
		int n = s.nextInt();
		 head = changeList(head, n );
		 
		 print(head);
		
		s.close();
	}

}
