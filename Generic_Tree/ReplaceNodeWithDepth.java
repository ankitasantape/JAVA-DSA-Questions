package Generic_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Replace node with depth
Send Feedback
In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything.
Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 : (Level wise, each level in new line)
0 
1 1 1 
2 2
*/public class ReplaceNodeWithDepth {
    
	public static void replace(TreeNode<Integer> root, int depth ) {
		
		if (root == null) {

			return;
		}
         
		root.data = depth;
		for (int i = 0; i < root.children.size(); i++) {
             
			
			replace(root.children.get(i), depth + 1);

		}
	}
	public static void replaceWithDepthValue(TreeNode<Integer> root){
           
       
		   replace(root, 0 );
	}
	
	public static void printLevelWise(TreeNode<Integer> root )  {
		
		   Queue<TreeNode<Integer>> queue = new LinkedList<>();
			
		   queue.add(root);
		   queue.add(null);
			
		   while ( !queue.isEmpty() ) {
			    
			   TreeNode<Integer> frontNode = queue.poll();
			   
			   if ( frontNode == null ) {
				   
				   System.out.println();
				   
				   if ( !queue.isEmpty() ) {
					   
					   queue.add(null);
				   }
			   } 
			   
			   else {
				   
				   System.out.print(frontNode.data + " ");
				   
				   for ( int i = 0; i < frontNode.children.size(); i++ ) {
					   
					   queue.add(frontNode.children.get(i));
				   }
			   }
		   }
			
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
        
		
		return root;
	} 
	
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		TreeNode<Integer> root = takeInput(s);

		replaceWithDepthValue(root);

		printLevelWise(root);
		
		s.close();
	}

}
