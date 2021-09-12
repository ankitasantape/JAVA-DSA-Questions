package Generic_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountNumOfNodes {
    
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
	
	public static void print( TreeNode<Integer> root ) {
		
		if ( root == null ) {
			
			return;
		}
		
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
			} else {
				
				System.out.print(frontNode.data + " ");
				
				for ( int i = 0; i < frontNode.children.size(); i++ ) {
					
					queue.add(frontNode.children.get(i));
				}
			}
		}
	}
	
	public static int numNode( TreeNode<Integer> root ) {
		
		if ( root == null ) {
			
			return 0;
		}
		
		int count = 1;
		
		for ( int i = 0; i < root.children.size(); i++ ) {
			
			count += numNode( root.children.get(i));
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		TreeNode<Integer> root = takeInput(s);
		
		
		
		int ans = numNode(root);
		
		System.out.println(ans);
        
		print(root);
		
		s.close();
	}

}
