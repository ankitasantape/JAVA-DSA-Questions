package Binary_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Pair sum Binary Tree
Send Feedback
Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.
Assume binary tree contains all unique elements.
Note : In a pair, print the smaller element first. Order of different pair doesn't matter.
Input format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer S
Output Format :
Each pair in different line (pair elements separated by space)
Constraints :
1 <= N <= 1000
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
15
Sample Output 1:
5 10
6 9
*/
public class PairSumBinaryTree {
	
	 
	private static ArrayList<Integer> convertBTintoArray( BinaryTreeNode<Integer> root ){
		
		if ( root == null ) {
			
			return new ArrayList<>();
		}
		ArrayList<Integer> leftArray = convertBTintoArray( root.left );
		ArrayList<Integer> rightArray = convertBTintoArray( root.right );
		ArrayList<Integer> array = new ArrayList<>();
		
		for( int i : leftArray ) {
			
			array.add(i);
		}
		
		for (int i : rightArray) {

			array.add(i);
		}
		array.add( root.data );
		
		return array;
	}
	
	
	public static void pairSum(BinaryTreeNode<Integer> root, int sum) {
		
		if ( root == null ) {
			
			return;
		}
		
		ArrayList<Integer> arr = convertBTintoArray( root );
		
		Collections.sort( arr );
	   
		int i = 0, j = arr.size() - 1;
	   
		while ( i < j ) {
	    	
	    	if ( arr.get(i) + arr.get(j) == sum ) {
	    		
	    		System.out.println( arr.get( i )+ " " + arr.get(j) );
	    		i++;
	    		j--;
	    		
	    	} else if ( arr.get(i) + arr.get(j) < sum ) {
	    		
	    		i++;
	    	
	    	} else {
	    	
	    		j--;
	    	}
	    }
		   
	}
	
	
	public static void main(String[] args) {
		 
		BinaryTreeNode<Integer> root = takeInput();
		
		pairSum( root, 15);
		
	}
	
	public static BinaryTreeNode<Integer> takeInput() {

		Scanner s = new Scanner(System.in);

		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

		// System.out.println("Enter root data: ");
		int rootdata = s.nextInt();

		if (rootdata == -1) {

			return null;
		}

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);

		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {

			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

			// System.out.println("Enter left child of " + frontNode.data );
			int leftChild = s.nextInt();

			if (leftChild != -1) {

				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
				pendingNodes.add(child);
				frontNode.left = child;
			}

			// System.out.println("Enter right child of " + frontNode.data );
			int rightChild = s.nextInt();

			if (rightChild != -1) {

				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
				pendingNodes.add(child);
				frontNode.right = child;

			}

		}

		s.close();
		return root;
	}
 
}
