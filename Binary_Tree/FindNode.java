package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Find Node
Send Feedback
For a given Binary Tree of type integer and a number X, find whether a node exists in the tree with data X or not.
 Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The only line of output prints 'true' or 'false'.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
7
Sample Output 1:
true
Sample Input 2:
2 3 4 -1 -1 -1 -1
10
Sample Output 2:
false
*/
public class FindNode {
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    
		if ( root == null ) {
			
			return false;
		}
		
		if ( root.data == x ) {
			
			return true;
		}
		
		boolean leftAns = isNodePresent( root.left, x );
        if ( leftAns ) {
			
        	return true;
		}
		boolean rightAns = isNodePresent( root.right, x );
        if ( rightAns ) {
			
        	return true;
		}
		
        return false;
	}
	
    public static boolean isNodePresent2(BinaryTreeNode<Integer> root, int x) {
	    
		if ( root == null ) {
			
			return false;
		}
		
		if( root.data == x ) {
			return true;
		}
		
		return ( isNodePresent2(root.left, x) || isNodePresent2(root.right, x));
    }	
		
    public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInput();
		
		boolean ans = isNodePresent(root, 4);
		
		System.out.println(ans);

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
