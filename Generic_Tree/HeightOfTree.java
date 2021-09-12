package Generic_Tree;

/*Code : Find Height
Send Feedback
Given a generic tree, find and return the height of given tree.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Height
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
3
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightOfTree {
 
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
	
	public static int height(TreeNode<Integer> root){
		
		if ( root == null ) {
			
			return 0;
		}
		
		int maxheight = 0;
		
		for ( int i = 0; i < root.children.size(); i++ ) {
			
			int max = height(root.children.get(i));
			
			System.out.println("max " + max );
			
			
			if ( maxheight < max ) {
				
				maxheight = max;
			}
		}
		
		return maxheight + 1 ;
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
        
		TreeNode<Integer> root = takeInput(s);

		s.close();

		int ans = height(root);

		System.out.println(ans);

	}


}
