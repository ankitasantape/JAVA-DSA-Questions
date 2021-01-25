package com.treesLearning;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*  Code : Print Level Wise
Send Feedback
Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in differnet lines.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Level wise print
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :3
10
20 30 40 
40 50
*/
public class InputOutputLevelWiseTraversal {

	public static TreeNode<Integer> takeInputLevelWise(Scanner s) {

		// System.out.println("Enter root data:");
		int rootdata = s.nextInt();

		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();

		TreeNode<Integer> root = new TreeNode<>(rootdata);

		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {

			TreeNode<Integer> frontNode;

			frontNode = pendingNodes.poll();

			// System.out.println("Enter num of children of "+ frontNode.data);
			int numChildren = s.nextInt();

			for (int i = 0; i < numChildren; i++) {

				    // System.out.println("Enter " + ( i + 1) + " th child of "+ frontNode.data );

				    int child = s.nextInt();

				    TreeNode<Integer> childNode = new TreeNode<Integer>(child);

				    frontNode.children.add(childNode);

				    pendingNodes.add(childNode);
      }
	}

	s.close();

	return root;
  }

  public static void printLevelWise(TreeNode<Integer> root) {

	Queue<TreeNode<Integer>> queue = new LinkedList<>();
		
        //First insert root into queue
	queue.add(root); // 1
		
        //then insert null means, level1 is inserted into queue
       queue.add(null); // null    1--->null
		
       //jb tk queue empty nhi hoti tb tk traverse kro
		while(!queue.isEmpty()) {
		        //first, deque first elem from queue and store it into frontNode
			      TreeNode<Integer> frontNode = queue.poll(); // frontNode = 1,null,2,3,4,null,5,6,null
			      if( frontNode == null ) {
				        System.out.println();
				        if(!queue.isEmpty() ) {
					            queue.add(null);
				        }
		                } else {
			                System.out.print(frontNode.data+" ");
		                        //then, insert all the children of frontNode into queue
		                        for( int i = 0; i < frontNode.children.size(); i++ ) {
				                 TreeNode<Integer> child = frontNode.children.get(i);
				                 queue.add(child);
			                }
		               }
		}
	}

	public static void main(String[] args) throws QueueEmptyException {

		Scanner s = new Scanner(System.in);

		TreeNode<Integer> root = takeInputLevelWise(s);

		printLevelWise(root);

		s.close();
	}

}
