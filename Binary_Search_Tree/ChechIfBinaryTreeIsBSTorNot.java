package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*Check if a Binary Tree is BST
Send Feedback
Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree) or not. If yes, return true, return false otherwise.
Duplicate elements should be in right subtree.
Input format :
Line 1 : Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place
Output format :
true or false
Constraints :
1 <= N <= 10^5
Sample Input 1 :
3 1 5 -1 2 -1 -1 -1 -1
Sample Output 1 :
true
Sample Input 2 :
5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1
Sample Output 2 :
false
 
LeetCode 
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1: 
Input: root = [2,1,3]
Output: true
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.       
*/
class Pair< T1, T2> {

	public T1 first;  // Minimum
	public T2 second;// Maximum
	
}
public class ChechIfBinaryTreeIsBSTorNot {
   
	public static boolean isBST1(BinaryTreeNode<Integer> root ) {
        if ( root.left == null && root.right == null ) {
			return true;
		}
    	return isBST1( root, Integer.MIN_VALUE, Integer.MAX_VALUE );
    }
	
	// Time Complexity - O(N) Space Complexity - O(H) ,where N is the number of nodes in the input trees & H is the height of the input tree  
    public static boolean isBST1(BinaryTreeNode<Integer> root , int min , int max ) {
		
       if(root==null ) {
			return true;
	   }
       if(min>root.data || root.data>max ) {
			return false;
	   }
       //In leftSubtree, everything should be less than root &&  In rightSubtree, everything should be greater than root and equal to root as well
	   return isBST1( root.left, min, root.data-1 ) && isBST1( root.right, root.data, max );
	}
	
    //find maximum from from left subtree
    public static int maximum( BinaryTreeNode<Integer> root ) {
	  
		if ( root == null ) {
			return Integer.MIN_VALUE;
		}
		
		return Math.max( root.data , Math.max( maximum( root.left ), maximum( root.right )));
	}
	
    //find minimum from right subtree
	public static int minimum( BinaryTreeNode<Integer> root ) {
		  
		if ( root == null ) {
			return Integer.MAX_VALUE;
		}
		
		return Math.min( root.data , Math.min( minimum( root.left ), minimum( root.right )));
	}
	
	//Time Complexity - O(n^2) = O(n*height) becoz hume extra work kr rhe hai, this problem is similar to Diameter of the tree
	public static boolean isBST2( BinaryTreeNode<Integer> root) {
		// Constant work
		if ( root == null ) {
			return true;
		}
		// Problem is here - left side ka min nikalna will be n/2 work & right side ka max nikalna will be n/2
		// Recurrence Relation - T(n) = 2T(n/2) + nk which is basically O(nlogn) work done
		// If the tree is like linked list type toward right(height of tree is n) and left side is trivial(height of tree is 0) then,
		// Recurrence Relation - T(n) = T(n-1) + nk ,which is basically O(n^2) => O(n*height) work done, Right side se minimum lane ke liye T(n-1) work krna chahiye 
		// Why this code taking so much time? Becoz hume pehle minimum find kr rhe hai left sutree se then BST hai ya nahi check krne ke liye firse left sutree pe call kr rhe hai, agar hum ye 2 kam ek hi bari me kr de to complexity kam ho skti hai
		// But issue is that ek function at a time 2 values return nahi kr skta jaise ki left Subtree at a time minium value and left subtree isBST hai ya nhi bata nhi skta  
		int rightMin = minimum( root.right );
		int leftMax = maximum( root.left );
		// Constant work
		if ( root.data < leftMax ) {
			return false;
		}
		// Constant work
		if ( root.data > rightMin ) {
            return false;
		}
		// Recursive call
		boolean isLeftBST = isBST2( root.left );
		boolean isRightBST = isBST2( root.right );
		// Constant work
		if( isLeftBST && isRightBST ) {
			return true;
		}else {
			return false;
		}
		
		
//		if( root.data > leftMax && root.data < rightMin ) {
//			return isBST2(root.left) && isBST2(root.right);
//		}
//		return false;
	}
	
	//Time Complexity - O(n)
	public static Pair< Boolean, Pair<Integer, Integer>> isBST3( BinaryTreeNode<Integer> root ) {
		   // Constant Work = k
		   if ( root == null ) {
			   
			   Pair<Boolean, Pair<Integer, Integer>> ans = new Pair<>();
			   //isBST 
			   ans.first = true;
			   //Make a pair to store maxHeight and minHeight 
			   ans.second = new Pair<Integer, Integer>();
			   //minHeight
			   ans.second.first = Integer.MAX_VALUE;
			   //maxHeight
			   ans.second.second = Integer.MIN_VALUE;
			   return ans;
		   }
		   // Time Complexity of 2 recursive call, if dono side equal number of node honge then 2T(n/2) work hoga plus some constant work 
		   // T(n) = T(n/2) + k, dono side equal number of node hai to O(n) work done hoga
		   // T(n) = T(n-1) + k, if linked list type ki tree hogi tb bhi O(n) work done hoga, becoz hum every node pe ja rhe n every node pe constant work kr rhe to overall n nodes hai to humane kn work kiya & humari complexity O(n) ho gayi 
		   Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST3( root.left );
		   Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST3( root.right );
		  
		   //Constant work = k
		   // Overall minimum, leftOutput.second.first this will be left size ka minimum & rightOutput.second.first this will be right side ka minimum
		   int min = Math.min(root.data, 
				                        Math.min(leftOutput.second.first, rightOutput.second.first));
		  // Overall maximum, leftOutput.second.second = left side ka maximum, rightOutput.second.second = right side ka maximum
		   int max = Math.max(root.data, 
				                        Math.max(leftOutput.second.second, rightOutput.second.second));
		   // agar rootdata greater hona chahiye left side ke maximum se and lesser than equal to hona chahiye hai right side ke minimum se Are this 2 conditions are enough "No" iske sath, left subtree itself should be a BST and right subtree itself should be a BST       
		   boolean isBST = ( root.data > leftOutput.second.second ) 
				   && ( root.data <= rightOutput.second.first ) 
				   && leftOutput.first 
				   && rightOutput.first;
		   
		   
		   //If above 4 conditions are satisfying then overall tree could be a BST 	
		   Pair<Boolean, Pair<Integer, Integer>> ans = new Pair<>();
		   
		   ans.first = isBST;
		   ans.second = new Pair<Integer, Integer>();
		   ans.second.first = min;
		   ans.second.second = max;
		   
		   return ans;
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInput();
		
		boolean ans1 = isBST1( root );
		boolean ans2 = isBST2( root );
		boolean ans3 = isBST3( root ).first;
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		System.out.println(isBST3(root).second.second);
		System.out.println(isValidBST(root));
		
	}
	//Leetcode solution
	public static boolean isValidBST(BinaryTreeNode<Integer> root) {
	       return isValidBSTHelper( root , null, null );
	    }
	    
	private static boolean isValidBSTHelper(BinaryTreeNode<Integer> root,Integer min, Integer max){
	        if( root == null ){
	            return true;
	        }
	        if( max != null && root.data >= max || min != null && root.data <= min ){
	            return false;
	        }
	    return isValidBSTHelper(root.left,min,root.data) && isValidBSTHelper(root.right,root.data,max);
	}
	
	public static BinaryTreeNode<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        // System.out.println("Enter root data: ");
		int rootdata = s.nextInt();
        if(rootdata == -1) {
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
