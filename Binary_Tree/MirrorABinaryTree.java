package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Mirror a Binary Tree
Send Feedback
For a given Binary Tree of type integer, update it with its corresponding mirror image.
Example:
Alt text

Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The only line of output prints the mirrored tree in a level-wise order. 
Each level will be printed on a new line. Elements printed at each level will be separated by a single line.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1 
3 2 
7 6 5 4
Sample Input 2:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 2:
5 
6 10 
3 2 
9
*/
public class MirrorABinaryTree {
    
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		
		if ( root == null ) {
			
			return;
		}
		
		mirrorBinaryTree( root.left );
		mirrorBinaryTree( root.right );
		
		BinaryTreeNode<Integer> temp = root.left;
		                   root.left = root.right;
		                   root.right = temp;
		
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInput();
		
		mirrorBinaryTree(root);
		
		print(root);
	}
    
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		   Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			
		   queue.add(root);
		  // queue.add(null);
			
		   while ( !queue.isEmpty() ) {
			    
			   BinaryTreeNode<Integer> frontNode = queue.poll();
			   
			   System.out.print(frontNode.data +":");
			  
			   if ( frontNode.left != null) {

					System.out.print("L:" + frontNode.left.data + ",");
					queue.add(frontNode.left);
			   } 
			   else
			   {
				   System.out.print("L:"+ -1 + ",");
			   }

				if ( frontNode.right != null) {

					System.out.println("R:" + frontNode.right.data );
					queue.add(frontNode.right);
				}
			    else 
			    {
				    System.out.print("R:" + -1 );
			    }
			    
				System.out.println();
		   }
			
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
	public static void print(BinaryTreeNode<Integer> root) {
		
		Queue<BinaryTreeNode<Integer>>  primary = new LinkedList<>();
		Queue<BinaryTreeNode<Integer>>  secondary = new LinkedList<>();

		primary.add(root);

		while(!primary.isEmpty()){
			
			BinaryTreeNode<Integer> current = null;
			
			current = primary.poll();
			
			System.out.print(current.data + " ");
			
			if(current.left != null){
				
				secondary.add(current.left);
			}
			if(current.right != null){
				
				secondary.add(current.right);
			}
			if(primary.isEmpty()){
				
				Queue<BinaryTreeNode<Integer>>  temp = secondary;
				secondary = primary;
				primary = temp;
				System.out.println();
			}
		}
			
	}



}
