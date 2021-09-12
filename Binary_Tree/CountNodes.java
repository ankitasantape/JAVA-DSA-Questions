package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 Sample Input 1:
 8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
 Sample Output 1:
 9
 
 */
public class CountNodes {

	public static int countNodes(BinaryTreeNode<Integer> root) {
        // If we don't write base case then it will throw nullPointerException becoz there will not be any bound to restrict recursive call
		if (root == null) {

			return 0;
		}
		int count = 1;

		count += countNodes(root.left); 
		count += countNodes(root.right);

		return count;
	}

	public static void main(String[] args) {

		BinaryTreeNode<Integer> root = takeInput();

		int ans = countNodes(root);

		System.out.println(ans);

	}

	public static BinaryTreeNode<Integer> takeInput() {

		Scanner s = new Scanner(System.in);

		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

		// System.out.println("Enter root data: ");
		int rootdata = s.nextInt();

		if (rootdata == -1) {
			s.close();
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
