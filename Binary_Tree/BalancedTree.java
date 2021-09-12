package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*Balanced
Send Feedback
Given a binary tree, check if its balanced i.e. depth of left and right subtrees of every node differ by at max 1. Return true if given binary tree is balanced, false otherwise.
Input format :

Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

Sample Input 1 :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
false
Sample Input 2 :
1 2 3 -1 -1 -1 -1
Sample Output 2 :
true
*/
class Pair3<T, V> {
	
	public T isBalanced;
	public V height;
	
}
public class BalancedTree {
   
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

    // Time Complexity - O(n * height )
   public static boolean checkBalanced1(BinaryTreeNode<Integer> root){
		 
	    if ( root == null ) {
	    	
	    	return true;
	    }
		
        if ( Math.abs(height(root.left) - height(root.right )) >= 1) {
        	
        	return false;
        }
        
        return checkBalanced1( root.left ) && checkBalanced1( root.right );
   }
   
   
   public static Pair3<Boolean, Integer> checkBalanced( BinaryTreeNode<Integer> root ) {
	
	   if ( root == null ) {
		   Pair3<Boolean , Integer> output = new Pair3<>();
			output.isBalanced = true;
			output.height = 0;
			return output;
	   }
	   
	  Pair3<Boolean, Integer> ans1 = checkBalanced( root.left );
	  Pair3<Boolean, Integer> ans2 = checkBalanced( root.right );
	  
	  Pair3<Boolean, Integer> ans = new Pair3<>();
	  
	  if ( ans1.isBalanced == true && ans2.isBalanced == true ) {
		  
		  if ( Math.abs(height(root.left) - height(root.right )) > 1) {
	        	
			    ans = new Pair3<>();
			    ans.height = Math.max(height(root.left), height(root.right))+1;
			    ans.isBalanced = false; 		
	        	return ans;
	      
		  }else {
			    
			    ans = new Pair3<>();
			    ans.height = Math.max(height(root.left), height(root.right))+1;
			    ans.isBalanced = true; 		
	        	return ans;
		  }
		  
	  }
	  return null;
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


	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(checkBalanced1(root));
		System.out.println(checkBalanced(root).isBalanced);
	}


}
