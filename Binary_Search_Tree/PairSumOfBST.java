package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*Pair sum Binary Tree
Send Feedback
Given a binary tree and an integer S, print all the pair of nodes whose sum equals S.
Assume binary tree contains all unique elements.
Note : In a pair, print the smaller element first. Order of different pair doesn't matter.
Input format :
Line 1 : Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 2 : Integer S
Output Format :
Each pair in different line (pair elements separated by space)
Constraints :
1 <= N <= 1000
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
15
Sample Output 1:
5 10
6 9

Approach 1:
1) Convert BST into sorted array ( how can we get sorted array - by inorder ) - O(N)
2) Apply two-pointer method on an array - O(N)
In two-pointer method we are adding start element and end element 
Algorithm: for( start to end )
           if( startElement + endElement == sum ) then start++; end--;
           else if( startElement + endElement < sum ) then start++;
           else end--;
Overall Time Complexity - O(N)
Space Complexity - O(N) , becoz we are storing all element into array 
We should improve the space complexity 

Approach 2:approach is same we are adding start element(which is the minimum element) and end element (which is the maximum element) first
Here, we have to reduce extra space 
In BST, if we want minimum element from tree then we use inorder and if we want maximum element from tree then we use reverse inorder
*/
public class PairSumOfBST {

	public static void printNodesSumToS( BinaryTreeNode<Integer> root , int s ) {
		
		if( root == null ) {
			return;
		}
		//A stack to store inorder passion
		Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
		//A stack to store reverse inorder passion
		Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
		BinaryTreeNode<Integer> temp = root;
		//getting minimum from left subtree and pushing left from whole left subtree
		while( temp != null ) {
			
			s1.push( temp );
			temp = temp.left;
		}
		//restoring root to traverse right subtree
		temp = root;
		//getting maximum from right subtree and pushing right from whole right subtree
		while (temp != null) {

			s2.push(temp);
			temp = temp.right;
		}
		//minimum of left subtree should be less the maximum of right subtree
		while (!s1.isEmpty() && !s2.isEmpty() && (s1.peek().data < s2.peek().data)) {
			//Getting minimum and maximum element of the BST
			BinaryTreeNode<Integer> frontNodeOfLeft = s1.peek(), frontNodeOfRight = s2.peek();
            // Check if addition of minimum + maximum == given sum 
			if (frontNodeOfLeft.data + frontNodeOfRight.data == s) {
                //print that node
				System.out.println(frontNodeOfLeft.data + " " + frontNodeOfRight.data);
				// pop minimum
				s1.pop();
				// pop maximum
				s2.pop();
                // next minimum, the value which is greater than the frontNodeOfLeft means inOrdeSuccessor( leftmost value in rightSubtree of frontNodeOfLeft) of the the frontNodeOfLeft 
				frontNodeOfLeft = frontNodeOfLeft.right;
				while (frontNodeOfLeft != null) {
                    
					s1.push(frontNodeOfLeft);
					frontNodeOfLeft = frontNodeOfLeft.left;
				}

				frontNodeOfRight = frontNodeOfRight.left;
				while (frontNodeOfRight != null) {

					s2.push(frontNodeOfRight);
					frontNodeOfRight = frontNodeOfRight.right;
				}

			} else if (frontNodeOfLeft.data + frontNodeOfRight.data < s) {

				s1.pop();
				frontNodeOfLeft = frontNodeOfLeft.right;

				while (frontNodeOfLeft != null) {
                    s1.push(frontNodeOfLeft);
					frontNodeOfLeft = frontNodeOfLeft.left;
				}

			} else { // if sum is greater than desired sum then pop maximum element
                
				s2.pop();
				// and then insert next maximum element, the number which is just smaller than the root ( which is just less than the popped out max element ) which is the right most value(maximum value) of left subtree 
				frontNodeOfRight = frontNodeOfRight.left; //first get left element
				//then traverse whole rightSubtree rightMost 
                while (frontNodeOfRight != null) {
                    s2.push(frontNodeOfRight);
					frontNodeOfRight = frontNodeOfRight.right;
				}
            }
       }
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		int sum = s.nextInt();
		printNodesSumToS( root, sum );
	}

    public static BinaryTreeNode<Integer> takeInput(Scanner s ) {
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
	   return root;	
	}
}
