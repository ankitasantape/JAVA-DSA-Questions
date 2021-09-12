package Binary_Search_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Longest Leaf to root path
Send Feedback
Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
Input format :

Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Line 1 : Binary Tree 1 (separated by space)

Sample Input 1 :
 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
9
3
6
5
*/
public class LongestLeafToRootPath {

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		
    	if ( root == null ) {
    		return new ArrayList<>();
    	}
    	
    	ArrayList<Integer> leftArray = longestRootToLeafPath( root.left );
    	ArrayList<Integer> rightArray = longestRootToLeafPath( root.right );
    	
    	if( leftArray.size() >= rightArray.size() )
    	{
    		leftArray.add( root.data );
    		return leftArray;
    	} else {
    		rightArray.add( root.data );
    		return rightArray;
    	}
	}
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
		Scanner s = new Scanner(System.in);
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
		return root;
	}
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<Integer> output = longestRootToLeafPath(root);
		for(int i : output) {
			System.out.println(i);
		}
		
		
		s.close();
	}


}
