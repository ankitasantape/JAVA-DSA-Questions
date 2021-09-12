package Linked_Lists;

import java.util.Scanner;

public class InsertNodeAtIthPos {
    
	public static LinkedListNode<Integer> insertNode(LinkedListNode<Integer> head, int data, int pos) {
    	
    	
    	int len = 0;
    	LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
//    	while(head != null) {
//    		if(len + 1 == pos ) {
//    			
//    			newNode.next = head.next;
//    			head.next = newNode;
//    			
//    		}
//    		len++;
//    		head = head.next;
//    	}
    	
    	//Method 2
    	
    	if( pos == 0) {
    		
    		newNode.next = head;
    		return newNode;
    	
    	}
    	LinkedListNode<Integer> temp = head;
    	
    	while (len < pos - 1) {
    		
    		temp = temp.next;
    		len++;
    	}
    	newNode.next = temp.next;
		temp.next    = newNode;
    	
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

		while (data != -1) {

			LinkedListNode<Integer> newNode = new LinkedListNode<>(data);

			if (head == null) {

				head = newNode;

				tail = newNode;

			} else {

				tail.next = newNode;

				tail = newNode;

			}

			data = s.nextInt();
		}

		head = insertNode(head, 80, 4);

		print(head);

		s.close();

	}
    

}
