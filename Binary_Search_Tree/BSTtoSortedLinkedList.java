package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Code: BST to Sorted LL
Send Feedback
Given a BST, convert it into a sorted linked list. Return the head of LL.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Linked list elements (separated by space)
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output :
2 5 6 7 8 10
*/
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		
		this.data = data;
	}
}

class Pair1<T1, T2> {
	
	T1 head;
	T2 tail;

	public Pair1(T1 head2, T2 tail2) {
		head = head2;
		tail = tail2;
	}
		
}

public class BSTtoSortedLinkedList {
    
    private static Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> BSTToSortedLLHelper(BinaryTreeNode<Integer> root){
    	
    	if ( root == null ) {
    		Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> ans = new Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>>(null, null);
    		return ans;
    	}
    	
    	Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> rhs = BSTToSortedLLHelper( root.right );
    	Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> lhs = BSTToSortedLLHelper( root.left );
    	LinkedListNode<Integer> rootNode = new LinkedListNode<Integer>(root.data);
    	
		if ( lhs.tail !=  null ) {
			lhs.tail.next = rootNode;
		}else{
		    lhs.head = rootNode;
		}
		
		if ( rhs.head != null ) {
			rootNode.next = rhs.head;
		}else{
			rhs.tail = rootNode;
		}
		
		Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> ans = new Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>>(lhs.head, rhs.tail);
		return ans;
	}
	
	public static LinkedListNode<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
		return BSTToSortedLLHelper(root).head;
			
	}
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); 
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			currentNode = pendingNodes.poll();
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}
		s.close();
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		LinkedListNode<Integer> ans = BSTToSortedLL(root);
		while(ans != null) {
			System.out.print(ans.data + " ");
			ans = ans.next;
		}
		
	}

}
