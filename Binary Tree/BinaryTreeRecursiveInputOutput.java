package BinaryTree;

import java.util.Scanner;

public class BinaryTreeRecursiveInputOutput
{
    
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
	public static BinaryTreeNode<Integer> takeInput( Scanner s ) {
		
		int rootdata;
		
		System.out.println("Enter root data: ");
		
		rootdata = s.nextInt();
		
		if ( rootdata == -1 ) {
			
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		
		root.left = takeInput(s);
		root.right = takeInput(s);
		
		return root;
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		BinaryTreeNode<Integer> root = takeInput(s);
		
		print(root);
		
		s.close();
//		BinaryTreeNode<Integer> data = new BinaryTreeNode<>(10);
//		BinaryTreeNode<Integer> data1 = new BinaryTreeNode<>(20);
//		data.left = data1;
//		
//		BinaryTreeNode<Integer> data2 = new BinaryTreeNode<>(30);
//        data.right = data2;
	}

}
