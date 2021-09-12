package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/*  ZigZag tree
Send Feedback
Given a binary tree, print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. 
This means odd levels should get printed from left to right and even level right to left.
Input format :

Elements in level order form (separated by space)

(If any node does not have left or right child, take -1 in its place)

Output Format :

Elements are printed level wise, each level in new line (separated by space).

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
5
10 6
2 3
9

Time Complexity - O(N)
Space Complexity - O(H) 

where, N is the number of nodes in a tree and H is the height of a tree
*/	
public class ZigZagTree {
    //Approach1
    public static void printZigZag(BinaryTreeNode<Integer> root) {
		
          Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
		  Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
		  s1.push(root);
		  
		  while ( !( s1.isEmpty() && s2.isEmpty() ) ) {
			
			   
			while (!s1.isEmpty()) {
                   
				   BinaryTreeNode<Integer> frontNode = s1.pop();
				   System.out.print( frontNode.data + " ");
				   
				   if ( frontNode.left != null ) {
					   s2.push( frontNode.left );
				   }
				   
				   if ( frontNode.right != null ) {
					   s2.push( frontNode.right );
				   }
			}
            System.out.println();
			while (!s2.isEmpty()) {
				 BinaryTreeNode<Integer> frontNode = s2.pop();
				   System.out.print( frontNode.data + " ");
				   
				   if ( frontNode.right != null ) {
					   s1.push( frontNode.right );
				   }
				   
				   if ( frontNode.left != null ) {
					   s1.push( frontNode.left );
				   }
			}
			System.out.println();
		  } 
		  
	}
	
    // Approach2 
    public static void printZigZag2(BinaryTreeNode<Integer> root) {
    	Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
    	Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
    	int level = 1;
    	// root has level 1
    	queue.add(root);
    	while(!queue.isEmpty()){
    	      BinaryTreeNode<Integer> frontNode = queue.poll();
    	      System.out.println(frontNode.data+" ");
    	      if( level % 2 == 0 ) {
    	    	  if(frontNode.right != null) {
    	    		  stack.add(frontNode.right);  
    	    	  }
    	    	  if(frontNode.left != null){
    	    		  stack.add(frontNode.right);
    	    	  }
    	    	  
    	      }else {
    	    	  if(frontNode.left != null ) {
    	    		  stack.add(frontNode.left);
    	    	  }
    	    	  if(frontNode.right != null ) {
    	    		  stack.add(frontNode.right);
    	    	  }
    	      }
    	      while(queue.isEmpty()) {
    	    	  while(!stack.isEmpty()) {
    	    		  queue.add(stack.pop());
    	    		  System.out.println();
    	    		  level++;
    	    	  }
    	      }
    	}
    	
    }
    
	public static void printLevelWise2(BinaryTreeNode<Integer> root) {

		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);

		while (!pendingNodes.isEmpty()) {
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

	
	public static BinaryTreeNode<Integer> takeInput(Scanner s) {

		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();

		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			currentNode = pendingNodes.poll();
			int leftChildData = s.nextInt();
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.add(leftChild);
			}
			int rightChildData = s.nextInt();
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.add(rightChild);
			}
		}

		return root;
	}


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		printZigZag(root);
		s.close();
	}
}
