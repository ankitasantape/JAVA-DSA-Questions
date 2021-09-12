package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Code: Search Node in BST

Given a BST and an integer k. Find if the integer k is present in given BST or not. Return the node with data k if it is present, return null otherwise.
Assume that BST contains all unique elements.
Input Format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer k
Output Format :
Node with data k
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -13
2
Sample Output 1 :
2
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
(empty)
*/
public class BSTUSe {

	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k){
	     
		if ( root == null  ) {
			
			return null;
		}
		if ( root.data == k ) {
			
			return root;
		}
		
		if ( root.data < k ) {
			
			return searchInBST( root.right , k);
			
		} 
		
		return searchInBST( root.left , k);
		
			
		
	}
	
	public static void main(String[] args) {
		
		
		BinaryTreeNode<Integer> root = takeInput();
		
		BinaryTreeNode<Integer> ans = searchInBST( root, 7 );
		
		if ( ans.data == 7 ) {
		    
			System.out.println(ans.data);
		}
		else {
			System.out.println("(empty)");
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
