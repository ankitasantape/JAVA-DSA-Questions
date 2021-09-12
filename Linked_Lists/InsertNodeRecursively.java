package Linked_Lists;

import java.util.Scanner;

public class InsertNodeRecursively {
    public static LinkedListNode<Integer> insertNode(LinkedListNode<Integer> head, int data, int pos) {
    	
    	if(pos == 0) {
    		LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
    		newNode.next = head;
    		
    		return newNode;
    	}
    	
    	if( head == null ) {
    		
    		return head;
    		
    	}
    	
    	head.next = insertNode(head.next, data, pos - 1);
    	
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
		
		int pos  = s.nextInt();
		
		head  = insertNode(head, 80, pos);
		 
		print(head);
		 
		s.close();

	}

}
