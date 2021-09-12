package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Replace with Sum of greater nodes

Given a binary search tree, you have to replace each node's data with the sum of all nodes which are greater or equal than it. 
You need to include the current node's data also.
That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) 
and all nodes whose data is greater than or equal to 5.
Note: You don't need to return or print, just change the data of each node.
Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. 
If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, 
therefore, it will not be a part of the data of any node.
Output format:
In the output, data of the nodes of the tree are printed in level order form. Each level of the tree is printed on a separate line.
Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18 
36 10 
38 31 
25 
*/
public class ReplaceWithSumOfGreaterNodes {
    // Time Complexity - O(N) Space Complexity - O(H), H is the height of the input BST  
	private static int replaceRootDataWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum) {
		if( root == null ) {
			return 0;
		}
		//first call on right subtree becoz all greater nodes are present on right side of root
		//update sum by adding larger nodes on right side of root
		//sum of all nodes from right subtree
		int parentdata = root.data;
		int rightsum = replaceRootDataWithLargerNodesSum(root.right, sum);
		 //sum of all nodes from currNode which are greater than the currNode + sum of all nodes from right subtree
		root.data += sum + rightsum ;
		//replace currNode/curr rootdata with larger nodes sum
		int leftsum = replaceRootDataWithLargerNodesSum(root.left, root.data);
		return parentdata + rightsum + leftsum;
		
	}
	
	private static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum ) {
		
 	   if( root == null ) {
 		   
 		   return 0;
 	   }
 	   
 	   int parentNodeSum = root.data;
 	   int rightSubtreeSum = replaceWithLargerNodesSum( root.right , sum );
 	   
 	   root.data += rightSubtreeSum + sum;
 	   int leftSubtreeSum = replaceWithLargerNodesSum( root.left , root.data );
 	   
 	   return parentNodeSum + rightSubtreeSum + leftSubtreeSum;
 	   
 	}
	
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		
    	  replaceWithLargerNodesSum( root, 0 ); 
	}
	
	public static void main(String[] args) {
		   
		BinaryTreeNode<Integer> root = takeInput();
		
		//replaceWithLargerNodesSum( root );
		//printLevelWise2( root );
		System.out.println();
		replaceRootDataWithLargerNodesSum(root,0);
		printLevelWise2( root );
	}
	public static void printLevelWise2(BinaryTreeNode<Integer> root) {
			Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
			pendingNodes.add(root);
	        pendingNodes.add(null);
            while(!pendingNodes.isEmpty()) {
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
     public static BinaryTreeNode<Integer> takeInput( ) {
		
		Scanner s = new Scanner(System.in);
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		
		//System.out.println("Enter root data: ");
		int rootdata = s.nextInt();
		
		if ( rootdata == -1 ) {
			s.close();
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
