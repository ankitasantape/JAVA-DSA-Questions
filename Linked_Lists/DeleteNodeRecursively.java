package Linked_Lists;

import java.util.Scanner;

public class DeleteNodeRecursively {
	
	public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
		
		if(pos == 0) {
    		
    		
    		return head.next;
    	}
    	
    	if( head == null || head.next == null  ) {
    		
    		return head;
    		
    	}
    	
    	head.next = deleteNodeRec(head.next , pos - 1);
    	
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
			
			int pos = s.nextInt();
			
			head = deleteNodeRec(head, pos);
			
			 print(head);
			 s.close();

		}

}
