package Linked_Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intersectionof2LL {
	public static void print(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static LinkedListNode<Integer> takeInput() throws IOException {

		LinkedListNode<Integer> head = null, tail = null;

		String[] datas = br.readLine().trim().split("\\s");

		int i = 0;
		while (i < datas.length && !datas[i].equals("-1")) {
			int data = Integer.parseInt(datas[i]);
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			i += 1;
		}

		return head;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int t = Integer.parseInt(br.readLine().trim());

		while (t > 0) {

			LinkedListNode<Integer> head1 = takeInput();
			LinkedListNode<Integer> head2 = takeInput();

	        LinkedListNode<Integer> new2Head = getIntersectionNode(head1, head2);
			
			print(new2Head);

			t -= 1;
		}

	}
	// Using Two Pointer Technique Time Complexity : O(m+n) Space Complexity : O(1) 
	private static LinkedListNode<Integer> getIntersectionNode(LinkedListNode<Integer> headA, LinkedListNode<Integer> headB) {
		LinkedListNode<Integer> ptr1 = headA;
		LinkedListNode<Integer> ptr2 = headB;
		if (ptr1 == null || ptr2 == null) {
			return null;
		}
		while (ptr1 != ptr2) {

			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
			if (ptr1 == ptr2) {
				return ptr1;
			}

			if (ptr1 == null) {
				ptr1 = headB;
			}

			if (ptr2 == null) {
				ptr2 = headA;
			}
		}

		return ptr1;
	}

}
