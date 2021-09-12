package Binary_Search_Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Largest BST
Send Feedback
Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree.
Return the height of largest BST.
Input format :

Line 1 : Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2

Approach 1:
   if( isBST(root) ){
       return height(root);
   } else {
       return Math.max( LargestBST(root.right) , LargestBST(root.right) );
   }    
   
   we need to perform O(n) work done for binary tree of height h at every level so Total Time Complexity is O( height * n )
*/
class Wrap<t1, t2>{
	
      t1 first; 
	  t2 second;
}
public class LargestBST {

    // Time Complexity - O(n) 
	public static Wrap<Wrap<Boolean,Integer>,Wrap<Integer,Integer>> largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
		 // Constant Work = k
		   if ( root == null ) {
			  
			   //Make a pair to store isBST and height of largest BST
			   Wrap<Boolean,Integer> ans1 = new Wrap<>();
			   //isBST 
			   ans1.first = true;
			   //height of Largest BST
			   ans1.second = 0;
			   
			   //Make a pair to store maxValue and minValue 
			   Wrap<Integer,Integer> ans2 = new Wrap<>();
			   //min value from right subtree
			   ans2.first = Integer.MAX_VALUE;
			   //max value from left subtree
			   ans2.second = Integer.MIN_VALUE;
			   
			   Wrap<Wrap<Boolean,Integer>,Wrap<Integer,Integer>> ans = new Wrap<Wrap<Boolean,Integer>,Wrap<Integer,Integer>>();
			   ans.first = ans1;
			   ans.second = ans2;
			   
			   return ans;
		   }
		   Wrap<Wrap<Boolean,Integer>,Wrap<Integer,Integer>> leftOutput = largestBSTSubtreeHelper( root.left );
		   Wrap<Wrap<Boolean,Integer>,Wrap<Integer,Integer>> rightOutput = largestBSTSubtreeHelper( root.right );
		   Wrap<Wrap<Boolean,Integer>,Wrap<Integer,Integer>> ans = new Wrap<>();
		   Wrap<Boolean,Integer> out1 = new Wrap<>();
		   Wrap<Integer,Integer> out2 = new Wrap<>();
		 
		  
		   // Overall minimum, leftOutput.second.first this will be left side ka minimum & rightOutput.second.first this will be right side ka minimum
		   out2.first  = Math.min(root.data, 
				                        Math.min(leftOutput.second.first, rightOutput.second.first));
		 
		   // Overall maximum, leftOutput.second.second = left side ka maximum, rightOutput.second.second = right side ka maximum
		   out2.second = Math.max(root.data, 
				                        Math.max(leftOutput.second.second, rightOutput.second.second));
		   
		   // leftSubtree and rightSubtree should be BST and 
		   //max value from leftSubtree should be less than root and 
		   //min value from rightSubtree should be greater than root 
		   out1.first = ( root.data > leftOutput.second.second ) 
				        && ( root.data < leftOutput.second.first ) 
				        && leftOutput.first.first 
				        && rightOutput.first.first;  
		   if(  out1.first ) {
			   //height of largest BST
			   out1.second = Math.max(leftOutput.first.second, rightOutput.first.second ) + 1;
		   } else {
			   out1.second = Math.max(leftOutput.first.second, rightOutput.first.second);
		   }
		  
		   ans.first = out1;
		   ans.second = out2;
		   return ans;
	}
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		   
		  return largestBSTSubtreeHelper(root).first.second;
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInput();
	
		System.out.println( largestBSTSubtree(root) );
		
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
