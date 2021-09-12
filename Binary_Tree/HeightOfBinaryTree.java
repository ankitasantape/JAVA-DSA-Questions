package Binary_Tree;

/*Height Of Binary Tree
Send Feedback
For a given Binary Tree of integers, find and return the height of the tree.
Example:
                        10
                      /      \
                    20      30
                   /    \
                 40    50

Height of the given tree is 3. 

Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.
 Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
The first and the only line of output prints the height of the given binary tree.
Note:
You are not required to print anything explicitly. It has already been taken care of.
Constraints:
0 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 -1 -1 -1 -1 -1
Sample Output 1:
3
Sample Input 2:
3 -1 -1
Sample Output 2:
1
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightOfBinaryTree {
    
	public static int height(BinaryTreeNode<Integer> root) {
		
        if ( root == null ) {
        	
        	return 0;
        }
        
        int leftCount = 1;
        int rightCount = 1;
        
        leftCount += height( root.left );
        rightCount += height( root.right );
        
        return Math.max(leftCount, rightCount );
        
	}

	public static void main(String[] args) {
		   
		BinaryTreeNode<Integer> root = takeInput();
		
		int height = height(root);
		
		System.out.println(height);
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

}
