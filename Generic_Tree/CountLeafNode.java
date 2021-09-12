package Generic_Tree;

/*Code : Count leaf nodes
Send Feedback
Given a generic tree, count and return the number of leaf nodes present in the given tree.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Count of leaf nodes
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
4
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountLeafNode {

	
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
	
	public static int countLeafNodes( TreeNode<Integer> root ) {
		
		if ( root == null ) {
			
			return 0;
		}
		
		if ( root.children.size() == 0 ) {
			
			return 1;
		}
		
		int count = 0;
		
		for ( int i = 0; i < root.children.size(); i++ ) {
			
			count +=  countLeafNodes( root.children.get(i) );
		}
		
		return count ;
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		TreeNode<Integer> root = takeInput(s);
		
		s.close();
		int ans = countLeafNodes(root);
		
		System.out.println(ans);
        
		//print(root);
		
		
	}

}
