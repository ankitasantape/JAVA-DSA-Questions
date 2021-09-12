package Generic_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DepthOfTree {

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
	
	public static void printAtK(TreeNode<Integer> root, int k){
		
		if ( k < 0 ) {
			
			return;
		}
		if ( k == 0 ) {
			
			System.out.println(root.data);
			return;
		}
		
		for ( int i = 0; i < root.children.size(); i++ ) {
			
			printAtK(root.children.get(i), k - 1);
		}
		
		
		
	}
	
	public static void main(String[] args) {

/*10 3 20 30 40 2 40 50 0 0 0 0
20
30
40
*/
		Scanner s = new Scanner(System.in);
        
		TreeNode<Integer> root = takeInput(s);
        
		printAtK(root, 1);

		 s.close();

	}

}
