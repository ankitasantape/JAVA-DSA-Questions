package Generic_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PreOrderTraversal {
    
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

	public static void preOrder( TreeNode<Integer> root ) {
		
		if ( root == null ) {
			
			return;
		}
		
		System.out.println(root.data);
		
		for ( int i = 0; i < root.children.size(); i++ ) {
			
			preOrder( root.children.get(i) );
		}
	}
	
    public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		TreeNode<Integer> root = takeInput(s);
		
		preOrder(root);
		
		System.out.println();
		
		s.close();
	}

}
