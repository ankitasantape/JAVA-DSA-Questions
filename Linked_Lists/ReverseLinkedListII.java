package Linked_Lists;

import java.util.Scanner;
/*Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
Input: 1 2 3 -1 , m = 1, n = 2
Output: 2 1 3 
Input: 1 2 -1, m = 1, n = 2
Output: 2 1
*/
public class ReverseLinkedListII {

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
	

	public static int length(LinkedListNode<Integer> head){
	
		int len = 0;
		
		while(head != null) {
		
			head = head.next;
			
			len += 1;
		}
		return len;
		
	}
	public static LinkedListNode<Integer> reverseBetween(LinkedListNode<Integer> head, int m, int n){
		
		if( head == null ) {
			return head;
		}
		if( m == n ) {
			return head;
		}
		if( m == 1 && n == length(head) ) {
			DoubleNode rev = betterReverseLL(head); 
			return rev.head;
		}
		LinkedListNode<Integer> curr = head, prev = null, start = null;
		int i = 1;
		
	    while (i < m) {
				prev = curr;
				curr = curr.next;
				i++;
		}
		start = curr;
		
		while( i < n ) {
			curr = curr.next;
			i++;
		}
		LinkedListNode<Integer> end = curr, next = curr.next;

		end.next = null;
		DoubleNode rev = betterReverseLL(start); 
       
		if( prev != null ) {
			prev.next = rev.head;
		
		}else {
			head = rev.head;
		}
		
		rev.tail.next = next;
		
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head) {
	    	
	    	while (head != null) {
	    		
	    		System.out.print(head.data + " ");
	    		
	    		head = head.next;
	    	}
	}
	
	public static LinkedListNode<Integer> takeInput() {
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
        s.close();
		return head;
	}
	
	public static void main(String[] args) {
	       
        LinkedListNode<Integer> head = takeInput();
		
		int m = 1, n = 2;
		LinkedListNode<Integer> ans = reverseBetween(head,m,n );
		print(ans);
		

	}
}
