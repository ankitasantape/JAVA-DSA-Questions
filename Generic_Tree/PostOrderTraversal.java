package Generic_Tree;

/*Code : Post-order Traversal
Send Feedback
Given a generic tree, print the post-order traversal of given tree.
Post-order traversal is : Children and then Root
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Post-order traversal, elements separated by space
Sample Input :
10 3 20 30 40 2 400 50 0 0 0 0 
Sample Output :
400 50 20 30 40 10
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PostOrderTraversal {
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

	public static void postOrder( TreeNode<Integer> root ) {
		
		if ( root == null ) {
			
			return;
		}
		
		for ( int i = 0; i < root.children.size(); i++ ) {
			
			postOrder( root.children.get(i) );
		}
		System.out.print(root.data + " ");
	}
	
    public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		TreeNode<Integer> root = takeInput(s);
		
		postOrder(root);
		
		System.out.println();
		
		s.close();
	}

}
