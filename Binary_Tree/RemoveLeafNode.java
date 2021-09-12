package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*      Remove Leaf nodes

Remove all leaf nodes from a given Binary Tree. Leaf nodes are those nodes, which don't have any children.
Note : Root will also be a leaf node if it doesn't have left and right child. 
You don't need to print the tree, just remove all leaf nodes and return the updated root.
Input format :

Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output :
8
3 10
6 14                    */
public class RemoveLeafNode {

	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root) {

		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return null;
		}

		root.left = removeAllLeaves(root.left);
		root.right = removeAllLeaves(root.right);

		return root;
	}

	public static void printLevelWise2(BinaryTreeNode<Integer> root) {

		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
			if (frontNode == null) {
				System.out.println();
				if (!pendingNodes.isEmpty()) {
					pendingNodes.add(null);
				}

			} else {
				System.out.print(frontNode.data + " ");
				if (frontNode.left != null) {
					pendingNodes.add(frontNode.left);
				}
				if (frontNode.right != null) {
					pendingNodes.add(frontNode.right);
				}
			}
		}
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

	public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInput();
        BinaryTreeNode<Integer> ans = removeAllLeaves(root);
        printLevelWise2(ans);
	}

}
