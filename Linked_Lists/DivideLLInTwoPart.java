package Linked_Lists;

import java.util.Scanner;
/*Divide linked list in two
Level MEDIUM
Write a function that takes one list and divides up its nodes to create two smaller lists A and B. The sub lists should be made from alternating elements in the original list.
Nodes should be in the reverse order of which they occurred in the source list.
Print both linked lists in different lines.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Line 1 : Output Linked List 1 elements (separated by space)
Line 2 : Output Linked List 2 elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
 8 2 5 9 1 4 3 7 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 8.
Sample Output :
 3 1 5 8
 7 4 9 2
 */
public class DivideLLInTwoPart {
	
	public static void make2List(ListNode<Integer> head) {
		
		if ( head == null || head.next == null ) {
			
			return;
		}
		
		ListNode<Integer> rev = reverse(head);
		
		ListNode<Integer> h1 = rev, t1 = h1;
		ListNode<Integer> h2 = rev.next , t2 = h2;
		rev = rev.next.next;
		
		while ( rev != null && rev.next != null ) {
			
			t1.next = rev;
			t2.next = rev.next;
			
			t1 = t1.next;
			t2 = t2.next;
			
			rev = rev.next.next;
			
		}
		
		if ( rev != null ) {
			
			t1.next = rev;
			t1 = t1.next;
		}
		
		t1.next = null;
		t2.next = null;
		
		print(h1);
		
		System.out.println();
		
		//print(h2);
		
		return;
        
	}
	public static ListNode<Integer> reverse(ListNode<Integer> root) {
		
    	if( root == null || root.next == null ) {
    		
    		return null;
    	}
    	
    	ListNode<Integer> prev = null;
    	
    	while(root != null) {
    		
    		ListNode<Integer> newNode = root.next;
    		root.next = prev;
    		prev = root;
    		root = newNode;
    			
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

		while (data != -1) {

			ListNode<Integer> newNode = new ListNode<>(data);

			if (head == null) {

				head = newNode;

				tail = newNode;

			} else {

				tail.next = newNode;

				tail = newNode;

			}

			data = s.nextInt();
		}

		make2List(head);

		// print(head);

		s.close();

	}
}
