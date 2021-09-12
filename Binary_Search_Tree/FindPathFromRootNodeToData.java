package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*Find Path in BST
Send Feedback
Given a BST and an integer k. Find and return the path from the node with data k and root (if a node with data k is present in given BST). Return null otherwise.
Assume that BST contains all unique elements.
Input Format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer k
Output Format :
Path from node k to root
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output :
2
5
8
*/

public class FindPathFromRootNodeToData {
   
	public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){
		
		if (root == null) {

			return null;
		}

		if (root.data == data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}
        
		if ( data < root.data ) {
			ArrayList<Integer> leftOutput = findPath(root.left, data);
			if (leftOutput != null) {

				leftOutput.add(root.data);
				return leftOutput;
			}
		}
		else
		if (data > root.data) {
			ArrayList<Integer> rightOutput = findPath(root.right, data);

			if (rightOutput != null) {

				rightOutput.add(root.data);
				return rightOutput;
			
			} 
		}
		return null;
	}
	
   public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInput();
		
		ArrayList<Integer> ans = findPath( root, 2);
		
		for ( int i : ans ) {
			
			System.out.print(i + " ");
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
