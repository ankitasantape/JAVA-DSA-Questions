package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*LCA of BST
Send Feedback
Given a binary search tree and two nodes, find LCA(Lowest Common Ancestor) of the given two nodes in the BST. Read about LCA if you are having doubts about the definition.
If out of 2 nodes only one node is present, return that node.
If both are not present, return -1.
Input format :
Line 1 :  Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Two integers, Node 1 and Node 2 (separated by space)
Output Format :
LCA
Constraints :
1 <= N <= 1000
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1
*/
public class LCAofBST {

	public static int lcaInBST(BinaryTreeNode<Integer> root , int a , int b){
		
       if ( root == null ) {
    		
    		return -1;
    	}
    	
    	if ( root.data == a || root.data == b ) {
    		
    		return root.data;
    	}
    	
    	int ldata = lcaInBST( root.left , a, b );
    	int rdata = lcaInBST( root.right , a, b );
    	
    	if ( ldata == -1 && rdata == -1 ) {
    		
    		return -1;
    	}
    	if ( ldata == -1 ) {
    		
    		return rdata;
    	}
        
    	if ( rdata == -1 ) {
    		
    		return ldata;
    	}
    	
    	return root.data;
	}
	
	public static void main(String[] args) {
		   
		BinaryTreeNode<Integer> root = takeInput();
		
		int ans = lcaInBST( root, 2, 10 );
		
		System.out.println( ans );
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
