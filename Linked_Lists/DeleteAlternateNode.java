package Linked_Lists;

import java.util.Scanner;

public class DeleteAlternateNode {
    public static void deleteAlternate(ListNode<Integer> head ) {
    	   
        if ( head == null || head.next == null ) {
			
			return;
		}
		
		ListNode<Integer> h1 = head, t1 = h1;
		ListNode<Integer> h2 = head.next , t2 = h2;
		
		head = head.next.next;
		
		while ( head != null && head.next != null ) {
			
			t1.next = head;
			//t2.next = head.next;
			
			t1 = t1.next;
			//t2 = t2.next;
			
			head = head.next.next;
			
		}
		
		if ( head != null ) {
			
			t1.next = head;
			t1 = t1.next;
		}
		
		t1.next = null;
		t2.next = null;
		
		print(h1);
		
		
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

		deleteAlternate(head);

		s.close();

	}

}
