package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Code: Print Elements in Range
Send Feedback
Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
Print the elements in increasing order.
Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
The following line contains two integers, that denote the value of k1 and k2.
Output Format:
 The first and only line of output prints the elements which are in range k1 and k2 (both inclusive). Print the elements in increasing order.
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output 1:
6 7 8 10
*/
public class PrintsElementInRange {

    public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2){
		if ( root == null ) {
			return;
		}
		
		
		if ( k1 < root.data ) {
			printNodeFromK1ToK2( root.left , k1, k2 );
		}
		if ( root.data >= k1 && root.data <= k2) {
			System.out.print( root.data + " ");
		}
		if ( k2 > root.data ) {
			printNodeFromK1ToK2( root.right , k1, k2 );
		}
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		int k1 = s.nextInt();
		int k2 = s.nextInt();
		printNodeFromK1ToK2( root, k1, k2);
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
