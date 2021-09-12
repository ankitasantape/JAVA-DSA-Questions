package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Code: Print Elements in Range
Send Feedback
Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
Print the elements in increasing order.
Input format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two Integers k1 and k2
Output Format :
Required elements (separated by space)
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output :
6 7 8 10
*/
public class ElementInRange {

	public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root, int k1, int k2) {
          
		if ( root == null ) {
			
			return;
		}
		
		if ( root.data >= k1 && root.data <= k2) {
			
			System.out.print( root.data + " ");
		}
		
		if ( k1 < root.data ) {
			
			printNodeFromK1ToK2( root.left , k1, k2 );
		}
		
		if ( k2 > root.data ) {
			
			printNodeFromK1ToK2( root.right , k1, k2 );
		}
		
	}

	public static void main(String[] args) {

		BinaryTreeNode<Integer> root = takeInput();

		printNodeFromK1ToK2(root, 6, 10);

		
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
