package Binary_Tree;

import java.util.Scanner;
/*
Input:
Enter root data: 
1
Enter root data: 
2
Enter root data: 
4
Enter root data: 
-1
Enter root data: 
-1
Enter root data: 
5
Enter root data: 
-1
Enter root data: 
-1
Enter root data: 
3
Enter root data: 
6
Enter root data: 
-1
Enter root data: 
-1
Enter root data: 
7
Enter root data: 
-1
Enter root data: 
-1
Output:
1: L: 2,R: 3,
2: L: 4,R: 5,
4: 
5: 
3: L: 6,R: 7,
6: 
7: 
*/
public class BinaryTreeRecursiveInputOutput
{
    
	public static void print( BinaryTreeNode<Integer> root ) {
		//if root ka data null hai to directly return kro
		if ( root == null ) {
			
			return;
		}
		//if root ka data null nhi hai toh string me append krke uske left and right part ko explore kro
		String toBePrinted = root.data +  ": ";
		
		
		if ( root.left != null ) {
			
			toBePrinted += "L: " + root.left.data + ",";
		}
		
		if ( root.right != null ) {

			toBePrinted += "R: " + root.right.data + ",";
		}
		
		System.out.println(toBePrinted);
		//Phle left part complete krenge, root ka left input lenge then root ke left ke left ko and right ko input krenge then left ke left ke left and right ko input krenge
		print( root.left );
		//after completing whole left part then right part start krenge, first root ka right input krenge then right ke right ko input krenge then left ko input krenge  
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
