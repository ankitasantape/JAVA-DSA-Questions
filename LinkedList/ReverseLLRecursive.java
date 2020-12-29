package LinkedList;

import java.util.Scanner;

/*     Reverse LL (Recursive)
Send Feedback
Given a singly linked list of integers, reverse it using recursion and return the head to the modified list.
 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output format :
For each test case/query, print the elements of the updated singly linked list.

Output for every test case will be printed in a seperate line.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^4
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
Sample Output 1 :
8 7 6 5 4 3 2 1
Sample Input 2 :
2
10 -1
10 20 30 40 50 -1
Sample Output 2 :
10 
50 40 30 20 10        */
public class ReverseLLRecursive {
	
	public static DoubleNode betterReverseLL(LinkedListNode<Integer> head) {
		if(head == null || head.next == null) { // length 1 or 0
			DoubleNode ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		
		DoubleNode smallAns = betterReverseLL(head.next);
		smallAns.tail.next = head;
		head.next = null;
		
		DoubleNode ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}
    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
    	//System.out.print(head.data + " ");
		   if(head == null || head.next == null) {
			
			   return head;
		   
		   }
   
		   LinkedListNode<Integer> newNode =  reverseLinkedListRec(head.next);
		  
		   head.next.next = head;
		  
		   head.next = null;
		   
		   return newNode;
		   
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
		
		
//		
//		 LinkedListNode<Integer> ans  = reverseLinkedListRec(head);
//		 
//		  print(ans);
		
		DoubleNode ans = betterReverseLL(head);
		print(ans.head);
		 
		s.close();

	}

}
