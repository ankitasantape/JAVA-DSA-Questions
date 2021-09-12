package Binary_Search_Tree;

import java.util.Scanner;

/*Code: Construct BST From Sorted Array
Send Feedback
Given a sorted integer array A of size n which contains all unique elements. 
You need to construct a balanced BST from this input array. Return the root of constructed BST.
Note : If array size is even, take first mid as root.
Input format :
Line 1 : Integer n (Size of array)
Line 2 : Array elements (separated by space)
Output Format :
BST elements (in pre order traversal, separated by space)
Sample Input :
7
1 2 3 4 5 6 7
Sample Output :
4 2 1 3 6 5 7 
*/
public class ConstructBSTfromSortedArray {
    
	private static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int start, int end) {
        
		if ( start > end) {
			
			return null;
		}
		int mid = (start + end)/2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		
		root.left = SortedArrayToBST( arr, start, mid - 1);
		root.right = SortedArrayToBST( arr, mid + 1, end);
		
		
		return root;
	}
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr) {

		return SortedArrayToBST( arr, 0, arr.length - 1);
	}
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int len = sc.nextInt();
		int[] arr = new int[len];
		for(int i = 0; i < len; ++i) {
			arr[i] = sc.nextInt();
		}
		BinaryTreeNode<Integer> ans = SortedArrayToBST(arr);
		
		preOrder(ans);
		
		sc.close();
	}
	

	private static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}

}
