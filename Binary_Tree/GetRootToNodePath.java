package Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Sample Input - 5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1, data = 15
  Sample Output- 15 10 5 
*/
public class GetRootToNodePath {

	public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data ){
		if (root == null) {
            return null;
		}

		if (root.data == data) {
			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}

		ArrayList<Integer> leftOutput = getRootToNodePath( root.left, data );
		//If leftSide not null hai means leftSide pe wo data mil gya, leftPath leftOutput me already hai ab hume sirf rootdata arraylist me insert krna hai  
		if (leftOutput != null) {
            leftOutput.add(root.data);
			return leftOutput;
		}
		
		ArrayList<Integer> rightOutput = getRootToNodePath( root.right, data );
		//If rightSide not null hai means rightSide pe data mil gya mtlab us data tk path mil chuki hai rightSide se aur root khudako arraylist me add kr dega  
		if (rightOutput != null) {
            rightOutput.add(root.data);
			return rightOutput;
		} else {
			//left to null tha hi tabhi yaha tk pahuche hai abhi right ka null hai to return null
			return null;
		}
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<Integer> ans = getRootToNodePath( root, 15);
		for(int i : ans){
			System.out.print(i + " ");
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
