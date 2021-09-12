package Generic_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Second Largest Element In Tree
Send Feedback
Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40
*/

public class SecondLargestElement {
	
	public static void RemoveMax( TreeNode<Integer> root, int largest ) {
		
		if ( root == null ) {
			
			return;
		}
		
		if ( root.data == largest ) {
			
			root.data = Integer.MIN_VALUE;
		}
		
		for ( int i = 0; i < root.children.size(); i++ ) {
			
			RemoveMax( root.children.get(i), largest );
		}
		
	}
	public static TreeNode<Integer> largest(TreeNode<Integer> root){
		// Edge Case not base case
	    if (root == null) {

			return null;
		}
        
	    TreeNode<Integer> large = root;
		int largest = root.data;
        int childLargest = 0;
		
        for (int i = 0; i < root.children.size(); i++) {
            
			TreeNode<Integer> largestChild = largest(root.children.get(i));
		    childLargest = largestChild.data;
		    
			if ( largestChild == null ) {
				
				continue;
			}
			if ( childLargest > largest ) {
				
				largest = childLargest ;
				large = largestChild;
			}
		}

		return large;
	}
    
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

        if (root == null) {

   			return null;
   		}
        
        RemoveMax ( root, largest(root).data );
        
        return largest(root);
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
         
		TreeNode<Integer> root = takeInput(s);

		s.close();

		TreeNode<Integer> ans = findSecondLargest(root);

		System.out.println(ans.data);

	}
	
	public static TreeNode<Integer> takeInput( Scanner s ) {
		   
		Queue<TreeNode<Integer>> queue = new LinkedList<>();

		int rootdata = s.nextInt();

		TreeNode<Integer> root = new TreeNode<>(rootdata);

		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode<Integer> frontNode = queue.poll();

			int childrenCount = s.nextInt();

			for (int i = 0; i < childrenCount; i++) {

				rootdata = s.nextInt();

				TreeNode<Integer> childNode = new TreeNode<>(rootdata);

				frontNode.children.add(childNode);

				queue.add(childNode);
			}
		}
        
		s.close();
		
		return root;
	} 
	
}
