package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Code: Search Node in BST

Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, if node with data k is present, return false otherwise.
Note: Assume that BST contains all unique elements.
Input Format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of k.
Output Format:
The first and only line of output contains a boolean value. Print true, if node with data k is present, print false otherwise. 
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
true
Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
false
*/
public class SearchNodeInBST {

	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root, int k) {

		if (root == null) {

			return null;
		}
		if (root.data == k) {

			return root;
		}

		if (root.data < k) {

			return searchInBST(root.right, k);

		}

		return searchInBST(root.left, k);

	}
	
    public static boolean searchNodeInBST(BinaryTreeNode<Integer> root, int k) {
    	if (root == null) {

			return false;
		}
		if (root.data == k) {

			return true;
		}

		if (root.data < k) {

			return searchNodeInBST(root.right, k);

		}

		return searchNodeInBST(root.left, k);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		int data = s.nextInt();
		System.out.println(searchNodeInBST(root,data));
		System.out.println(searchInBST(root,data).data);
		
	}

    public static BinaryTreeNode<Integer> takeInput(Scanner s  ) {
		
		//ye wo nodes hai jinke child nahi pahuche hai abhi tk jaiseki 1 ka input le liya hai but uske child ka input nahi aaya hai abhi tk to un nodes ko uthake pendingnodes me dal diya taki hume apna input turant mil jaye next time 1 ke children puch lenge
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		
		//System.out.println("Enter root data: ");
		int rootdata = s.nextInt();
		//if someone don't want to give tree input just give -1 and return null it means there is no tree(empty tree)
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
