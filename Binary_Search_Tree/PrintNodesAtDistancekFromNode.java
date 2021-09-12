package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Print nodes at distance k from node
Send Feedback
You are given a Binary Tree of type integer, a target node, and an integer value K.
Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.
Example:
For a given input tree(refer to the image below):
1. Target Node: 5
2. K = 2
alt txt

Starting from the target node 5, the nodes at distance K are 7 4 and 1.
Input Format:
The first line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.

The second line of input contains two integers separated by a single space, representing the value of the target node and K, respectively.
Output Format:
All the node data at distance K from the target node will be printed on a new line.

The order in which the data is printed doesn't matter.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3 1
Sample Output 1:
9
6
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
3 3
Sample Output 2:
4
5
*/
public class PrintNodesAtDistancekFromNode {

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
	    
        nodesAtDistanceKFromTargetNode( root, node, k );
        
	}

    private static int nodesAtDistanceKFromTargetNode( BinaryTreeNode<Integer> root, int node, int k ) {
    	
    	if( root == null ) {
    		
    		return -1;
    	}
    	
    	if( root.data == node ) {
    		printDownwardsNode( root, k );
    		return 0;
    	}
    	
    	int leftdist = nodesAtDistanceKFromTargetNode( root.left, node, k );
    	
    	if( leftdist != -1 ) {
    		
    		if( leftdist + 1 == k ) {
    			
    			System.out.println(root.data);
    		
    		} else {
    			
    			printDownwardsNode( root.right, k-2-leftdist);
    		}
    		return leftdist + 1;
    	}
    	
        int rightdist = nodesAtDistanceKFromTargetNode( root.right, node, k );
    	
    	if( rightdist != -1 ) {
    		
    		if( rightdist + 1 == k ) {
    			
    			System.out.println(root.data );
    		
    		} else {
    			
    			printDownwardsNode( root.left, k-2-rightdist);
    		}
    		return rightdist + 1;
    	}
    	
    	return -1;
    }

	private static void printDownwardsNode(BinaryTreeNode<Integer> root, int k) {
		
		if( root == null ) {
			return;
		}
		
		if( k == 0 ) {
			System.out.println(root.data+" ");
			return;
		}
		
		printDownwardsNode( root.right, k-1);
		printDownwardsNode( root.left, k-1);
	}

	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		int target = s.nextInt();
		int k = s.nextInt();
		nodesAtDistanceK(root, target, k);
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
