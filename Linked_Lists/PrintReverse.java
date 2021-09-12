
package Linked_Lists;

import java.util.Scanner;

/*       Print Reverse LinkedList

You have been given a singly linked list of integers. Write a function to print the list in a reverse order.
To explain it further, you need to start printing the data from the tail and move towards the head of the list, printing the head data at the end.
Note :
You can’t change any of the pointers in the linked list, just print it in the reverse order.
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Constraints :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each test case, print the singly linked list of integers in a reverse fashion, in a row, separated by a single space.

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^3
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
1 2 3 4 5 -1
Sample Output 1 :
5 4 3 2 1
Sample Input 2 :
2
1 2 3 -1
10 20 30 40 50 -1
Sample Output 2 :
3 2 1
50 40 30 20 10  */
public class PrintReverse {
    
    public static void printReverse(LinkedListNode<Integer> root) {
		
    	if( root == null) {
    		
    		return;
    	}
    	LinkedListNode<Integer> prev = null;
    	
    	while(root != null) {
    		
    		LinkedListNode<Integer> newNode = root.next;
    		root.next = prev;
    		prev = root;
    		root = newNode;
    			
    	}
    	
        print(prev); 
    	
    }
    public static LinkedListNode<Integer> returnReverse(LinkedListNode<Integer> root) {
		
    	if( root == null) {
    		
    		return root;
    	}
    	LinkedListNode<Integer> prev = null;
    	
    	while(root != null) {
    		
    		LinkedListNode<Integer> newNode = root.next;
    		root.next = prev;
    		prev = root;
    		root = newNode;
    			
    	}
    	
        return prev;
    	
    }
    
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> root) {
    	if(root == null || root.next == null) {
    		return root;
    	}
    	 LinkedListNode<Integer> finalHead = reverse(root.next);
    	 LinkedListNode<Integer> temp = finalHead;
    	 
    	 while(temp.next != null) {
    		 temp = temp.next;
    	 }
    	 temp.next = root;
    	 root.next = null;
    	 return finalHead;
    	
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
		
		
		
	    printReverse(head);
		 
		head = returnReverse(head);
		print(head);
		
		head = reverse(head);
		print(head);
		 
		s.close();

	}

}
