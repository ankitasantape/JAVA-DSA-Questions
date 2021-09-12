package Binary_Tree;
/*//System.out.println(diameter(root));
/*
Enter root data: 
1
Enter left child of 1
2
Enter right child of 1
3
Enter left child of 2
4
Enter right child of 2
5
Enter left child of 3
-1
Enter right child of 3
-1
Enter left child of 4
8
Enter right child of 4
-1
Enter left child of 5
-1
Enter right child of 5
6
Enter left child of 8
9
Enter right child of 8
-1
Enter left child of 6
-1
Enter right child of 6
7
Enter left child of 9
-1
Enter right child of 9
-1
Enter left child of 7
-1
Enter right child of 7
-1
Sample Input: 1 2 3 4 5 -1 -1 8 -1 -1 6 9 -1 -1 7 -1 -1 -1 -1
1: L: 2,R: 3,
2: L: 4,R: 5,
4: L: 8,
8: L: 9,
9: 
5: R: 6,
6: R: 7,
7: 
3: 
Diameter: 6
Height: 5
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DiameterOfBinaryTree {
    
	// Time Complexity - O(n)
	public static Pair<Integer, Integer> heightDiameter( BinaryTreeNode<Integer> root) {
		if ( root == null ) {
			Pair<Integer , Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		
		// height of left = first and diameter of left = second
		Pair<Integer, Integer> lo = heightDiameter(root.left);
	
		// height of right = first and diameter of right = second
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		
		int height = 1 + Math.max( lo.first , ro.first );
		
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		
		int diameter = Math.max(option1, Math.max( option2, option3));
		
		Pair<Integer , Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}
	
	// Time Complexity - O(n^2)
	public static int diameter( BinaryTreeNode<Integer> root ) {
		
		if ( root == null ) {
			
			return 0;
		}
		
		int option1 = height( root.left ) + height( root.right );
		int option2 = diameter( root.left );
		int option3 = diameter( root.right );
		
		return Math.max(option1 , Math.max(option2, option3));
	}
	public static void main(String[] args) {
		   
		BinaryTreeNode<Integer> root = takeInput();
		
		print(root);
		
		
		System.out.println("Diameter: " + heightDiameter(root).second);
		
		System.out.println("Height: " + heightDiameter(root).first);
		
	}
    public static int height(BinaryTreeNode<Integer> root) {
		
        if ( root == null ) {
        	
        	return 0;
        }
        
       int leftCount = height( root.left );
      
       int rightCount = height( root.right );
        
       return Math.max(leftCount, rightCount ) + 1;
        
	}
    
    public static BinaryTreeNode<Integer> takeInput( ) {
		
		Scanner s = new Scanner(System.in);
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		
		System.out.println("Enter root data: ");
		int rootdata = s.nextInt();
		
		if ( rootdata == -1 ) {
			
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		
		pendingNodes.add(root);
		
		while ( !pendingNodes.isEmpty() ) {
			
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
			
			System.out.println("Enter left child of " + frontNode.data );
			int leftChild = s.nextInt();
			
			if ( leftChild != -1 ) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
				pendingNodes.add(child);
				frontNode.left = child;
			}
			
			System.out.println("Enter right child of " + frontNode.data );
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

    public static void print( BinaryTreeNode<Integer> root ) {
		
		if ( root == null ) {
			
			return;
		}
		
		String toBePrinted = root.data +  ": ";
		
		if ( root.left != null ) {
			
			toBePrinted += "L: " + root.left.data + ",";
		}
		
		if (root.right != null) {

			toBePrinted += "R: " + root.right.data + ",";
		}
		
		System.out.println(toBePrinted);
		
		print( root.left );
		print( root.right );
	}
}
