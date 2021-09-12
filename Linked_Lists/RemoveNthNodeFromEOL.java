package Linked_Lists;

import java.util.Scanner;

public class RemoveNthNodeFromEOL {
    public static LinkedListNode<Integer> removeNthFromEnd(LinkedListNode<Integer> head, int n  ){
    	
    	LinkedListNode<Integer> temp = new LinkedListNode<>(null);
    	temp.next = head;
    	LinkedListNode<Integer> fast = temp, slow = temp;
    	
    	int i = 1;
    	
    	while( i <= n ) {
    		fast = fast.next;
    		i++;
    	}
    	
    	while( fast.next != null ) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	
    	slow.next = slow.next.next;
    	head = temp.next;
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
		
		int n = s.nextInt();
		
		head  = removeNthFromEnd(head, n);
		 
		print(head);
		 
		s.close();
	}

}
