package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Level wise linked list
Send Feedback
Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.
Input format :

Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

Output format : Each level linked list is printed in new line (elements separated by space).

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
5 
6 10 
2 3 
9*/
class Node<T> {
    T data;
    Node<T> next;
    Node(T data) {
 	   this.data = data;
    }
    
}

public class LevelWiseLinkedList {
	
	public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {
             
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		Node<BinaryTreeNode<Integer>> head = null , tail = null ;
		ArrayList<Node<BinaryTreeNode<Integer>>> output = new ArrayList<Node<BinaryTreeNode<Integer>>>();
		
		queue.add(root);
		queue.add(null);
		
		while ( !queue.isEmpty() ) {
			
			BinaryTreeNode<Integer> curr = queue.poll();
			 
			if ( curr == null ) {
				
				output.add(head);
				
				head = null;
				tail = null;
				
				if ( !queue.isEmpty() ) {
					
					queue.add( null );
				}
				
			} else {
				
				Node<BinaryTreeNode<Integer>> n = new Node<>(curr);
				
				if (curr.left != null) {
					queue.add(curr.left);
				}

				if (curr.right != null) {
					queue.add(curr.right);
				}
				if ( head == null ) {
					
					head = n;
					tail = n;
				
				} else {
					
					tail.next = n;
					tail = tail.next;
				}
			}
		}
	    
		return output;
		
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<Node<BinaryTreeNode<Integer>>> output = LLForEachLevel(root);
		for(Node<BinaryTreeNode<Integer>> head : output){
			Node<BinaryTreeNode<Integer>> temp = head;
			while(temp != null){
				System.out.print(temp.data.data + " ") ;
				temp = temp.next;
			}
			System.out.println();
		}
	}
		
    public static BinaryTreeNode<Integer> takeInput( ) {
		
		Scanner s = new Scanner(System.in);
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		
		//System.out.println("Enter root data: ");
		int rootdata = s.nextInt();
		
		if ( rootdata == -1 ) {
			
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		
		pendingNodes.add(root);
		
		while ( !pendingNodes.isEmpty() ) {
			
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
			
			//System.out.println("Enter left child of " + frontNode.data );
			int leftChild = s.nextInt();
			
			if ( leftChild != -1 ) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
				pendingNodes.add(child);
				frontNode.left = child;
			}
			
			//System.out.println("Enter right child of " + frontNode.data );
			int rightChild = s.nextInt();
			
			if ( rightChild != -1 ) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
				pendingNodes.add(child);
				frontNode.right = child;
				
			}
			
		}
	  	
		s.close();
	   return root;	
	}


}
