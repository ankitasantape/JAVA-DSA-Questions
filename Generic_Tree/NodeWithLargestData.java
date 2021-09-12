package Generic_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NodeWithLargestData {

	public static int largest(TreeNode<Integer> root){
		// Edge Case not base case
	    if (root == null) {

			return Integer.MIN_VALUE;
		}

		int largest = root.data;

		for (int i = 0; i < root.children.size(); i++) {
            
			int largestChild = largest(root.children.get(i));
			
			if ( largestChild > largest ) {
				
				largest = largestChild;
			}
		}

		return largest;
	}
    
	public static TreeNode<Integer> largest2(TreeNode<Integer> root){
		// Edge Case not base case
	    if (root == null) {

			return null;
		}
        
	    TreeNode<Integer> large = root;
		int largest = root.data;
        int childLargest = 0;
		
        for (int i = 0; i < root.children.size(); i++) {
            
			TreeNode<Integer> largestChild = largest2(root.children.get(i));
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
        
//		s.close();
		
		return root;
	} 
	
	/*input - 10 3 20 30 40 2 40 50 0 0 0 0 
      output - 50
      output - 50      */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		TreeNode<Integer> root = takeInput(s);

		

		int ans = largest(root);
        
		TreeNode<Integer> ans2 = largest2(root);
		
		System.out.println(ans);

		System.out.println(ans2.data);
		s.close();
	}

	

}
