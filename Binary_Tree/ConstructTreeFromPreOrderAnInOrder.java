package Binary_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*Code: Construct Tree from Preorder and Inorder

For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
Note:
Assume that the Binary Tree contains only unique elements. 
Input Format:
The first line of input contains an integer N denoting the size of the list/array. It can also be said that N is the total number of nodes the binary tree would have.

The second line of input contains N integers, all separated by a single space. It represents the preorder-traversal of the binary tree.

The third line of input contains N integers, all separated by a single space. It represents the inorder-traversal of the binary tree.
Output Format:
The given input tree will be printed in a level order fashion where each level will be printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate them.
Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
1 2 4 5 3 6 7 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
5 6 2 3 9 10 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9 

*We can make N number trees using only inorder or preorder but the mixture of both can make a unique binary tree
*/
class Pair1 {
	int[] preOrder;
	int[] inOrder;

	public Pair1(int[] preOrder, int[] inOrder) {
		this.preOrder = preOrder;
		this.inOrder = inOrder;
	}

}

public class ConstructTreeFromPreOrderAnInOrder {
 
    private static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd ) {
		
    	if (  inStart > inEnd || preStart > preEnd  ) {
    		
    		return null;
    	}
    	
    	int mid = 0;
    	int rootdata = preOrder[ preStart ];
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata); 
    	
    	for ( int i = inStart; i <= inEnd; i++ ) {
    		
    		if ( rootdata == inOrder[i] ) {
    			
    			mid = i;
    			break;
    		}
    	}
    	
    	//For left subtree
    	int leftInStart  = inStart;
    	int leftInEnd  = mid - 1;
    	int leftPreStart = preStart + 1;
//    	int leftPreEnd = leftPreStart + mid - inStart - 1;
    	int leftPreEnd = leftInEnd - leftInStart + leftPreStart;
    	
    	//For right subtree
    	int rightPreStart = leftPreEnd + 1;
    	int rightPreEnd = preEnd;
    	int rightInStart  = mid + 1;
    	int rightInEnd  = inEnd;
    	
    	
    	
    	root.left = buildTree( preOrder, inOrder, leftPreStart , leftPreEnd , leftInStart  , leftInEnd );
    	
    	root.right = buildTree( preOrder, inOrder, rightPreStart, rightPreEnd , rightInStart , rightInEnd );
    	
    	return root;
	}

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		
    	return buildTree( preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}
   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair1 takeInput() throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine().trim());

    	int pre[] = new int[n];
    	int in[] = new int[n];

    	String[] preOrder = br.readLine().trim().split(" ");
    	String[] inOrder = br.readLine().trim().split(" ");


    	for (int i = 0; i < n; i++) {
    		pre[i] = Integer.parseInt(preOrder[i].trim());
    		in[i] = Integer.parseInt(inOrder[i].trim());
    	}

    	return new Pair1(pre, in);

    }

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
        pendingNodes.add(null);

		while(!pendingNodes.isEmpty()) {
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
    public static void main(String[] args) throws NumberFormatException, IOException {

    	Pair1 input = takeInput();

    	int[] preOrder = input.preOrder;
    	int[] inOrder = input.inOrder;

    	BinaryTreeNode<Integer> root = buildTree(preOrder, inOrder);

    	printLevelWise(root);

    }
}


