package Generic_Tree;

import java.util.ArrayList;
import java.util.Scanner;

/*Remove leaf nodes in Tree
Send Feedback
Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any children.
Note : Root will also be a leaf node if it doesn't have any child. You don't need to print the tree, just remove all leaf nodes and return the updated root.
Input format :
Line 1 : Elements in level order form separated by space (as per done in class). Order is - `

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element `
Output Format :
Elements are printed level wise, each level in new line (separated by space)
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 : (Level wise, each level in new line)
10
20
*/
public class RemoveLeafNodesInTree {

	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		
		if( root == null || root.children.size() == 0 ) {
			
			return null;
		}
		
		ArrayList<Integer> indexes = new ArrayList<>();
		for( int i = 0; i < root.children.size(); i++ ) {
			
		  TreeNode<Integer>	newTree = root.children.get( i );
		
		  if( newTree.children.size() == 0 ) {
			  
			  indexes.add( i );
		  }
		  
		}
		
		for( int i = indexes.size() - 1; i >= 0; i-- ) {
			int j = indexes.get( i );
			root.children.remove(j);
		}
		
		for( int i = 0; i < root.children.size() ; i++ ) {
			TreeNode<Integer> newTree = removeLeafNodes( root.children.get( i ));
			
			if ( newTree == null ) {
				
				root.children.remove( i );
			}
		}
		
		return root;
	}
	
	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}

	public static void printTreeLevelWise(TreeNode<Integer> root){
		if(root == null) {
			return;
		}
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>(); 
		pendingNodes.enqueue(root);
		pendingNodes.enqueue(null);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode = null;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				e.printStackTrace();
			}
			if(currentNode == null) {
				if(pendingNodes.isEmpty()) {
					break;
				}
				System.out.println();
				pendingNodes.enqueue(null);
				continue;
			}
			System.out.print(currentNode.data + " ");
			int numChild = currentNode.children.size();
			for(int i = 0 ; i < numChild; i++){
				pendingNodes.enqueue(currentNode.children.get(i));
			}
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		root = removeLeafNodes(root);
		printTreeLevelWise(root);
		s.close();
	}
}
