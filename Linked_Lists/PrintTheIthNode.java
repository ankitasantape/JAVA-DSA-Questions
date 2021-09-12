package Linked_Lists;

import java.util.Scanner;

/*  Print ith Node
Send Feedback
For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.
 Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the singly linked list separated by a single space.

The second line contains the value of 'i'. It denotes the position in the given singly linked list.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.
Output format :
For each test case, print the node data at the 'i-th' position of the linked list(if exists).

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
i  >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
2
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0
9 8 4 0 7 8 -1
3
Sample Output 2 :
3
0           */
public class PrintTheIthNode {
	
    public static void printIthNode(LinkedListNode<Integer> head, int i){
        System.out.println(head.data);
    	int len = 0;
		
		while(head != null) {
		
			if(len == i) {
				System.out.println(len + " " + i);
				System.out.println(head.data);
				break;
			} 
			
			else if(len > i) {
				
				System.out.println(" ");
				break;
			}
			head = head.next;
			
			len += 1;
		
		}
		
        
	}
    
   public static Scanner s = new Scanner(System.in);
    
   public static LinkedListNode<Integer> input() {
        
    	int data = s.nextInt();
		
	    LinkedListNode<Integer> tail = null, head = null;
	    
	   
		while( data != -1 ) {
		 
		   LinkedListNode < Integer > newNode = new LinkedListNode <>( data  );
		
		   if(head == null) {
			
			   head = newNode;
			   
			   tail = newNode;
		   
		   } else {
			
			   tail.next = newNode;
			   
			   tail = newNode;
		   
		   }
		   
		   data = s.nextInt();
		}
		
		
		return head; 
    	
    }
	public static void main(String[] args) {
        
		 LinkedListNode<Integer> head = input();
		
		 int i = s.nextInt();
		 
		 printIthNode(head, i);
		
		
	}

}
