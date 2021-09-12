package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*Path Sum Root to Leaf
Send Feedback
For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.
Example:
alt txt

If you see in the above-depicted picture of Binary Tree, we see that there are a total of two paths, starting from the root and ending at the leaves which sum up to a value of K = 13.

The paths are:
a. 2 3 4 4
b. 2 3 8

One thing to note here is, there is another path in the right sub-tree in reference to the root, which sums up to 13 but since it doesn't end at the leaf, we discard it.
The path is: 2 9 2(not a leaf)
 Input Format:
The first line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.

The second line of input contains an integer value K.
Output Format:
Lines equal to the total number of paths will be printed. All the node data in every path will be printed in a linear fashion taken in the order they appear from top to down bottom in the tree. A single space will separate them all.
Constriants:
1 <= N <= 10^5
0 <= K <= 10^8
Where N is the total number of nodes in the binary tree.

Time Limit: 1 second
Sample Input 1:
2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
13
Sample Output 1:
2 3 4 4 
2 3 8
Sample Input 2:
5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
13
Sample Output 2:
5 6 2
5 7 1
*/
public class PathSumRootToLeaf {
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String s, int currSum) {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			currSum += root.data;
			if (k == currSum) {
				System.out.println(s + root.data + " ");
				return;
			}
		}
		rootToLeafPathsSumToK(root.left, k, s + root.data + " ", currSum + root.data);
		rootToLeafPathsSumToK(root.right, k, s + root.data + " ", currSum + root.data);
	}
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
  		rootToLeafPathsSumToK( root, k, "",0);
  	}
	
	public static void main(String[] args) {
		// 6 3 2 1 5 4 1 2 -1 1 -1 3 8 -1 -1 -1 -1 -1 -1 -1 -1
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		int k = s.nextInt();							
		rootToLeafPathsSumToK( root, k );
	}
    public static BinaryTreeNode<Integer> takeInput(Scanner s ) {
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
	  	
		
	   return root;	
	}

}
