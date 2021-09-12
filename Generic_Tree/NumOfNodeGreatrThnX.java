package Generic_Tree;

/*Code : Number of nodes greater than x
Send Feedback
Given a tree and an integer x, find and return number of Nodes which are greater than x.
Input format :
Single Line : First Integer denotes x and rest of the elements in level order form separated by space. Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Count of nodes greater than x
Sample Input 1 :
35 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
3
Sample Input 2 :
10 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
5
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumOfNodeGreatrThnX {

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
	
	public static int numNodeGreater(TreeNode<Integer> root,int x){

		if (root == null) {

			return 0;
		}
        
		int count = 0;
		
		for ( int i = 0; i < root.children.size(); i++ ) {
            
			count += numNodeGreater( root.children.get(i) , x );
			//System.out.println(root.data +" Inside "+count);
		}
		
       
		if ( root.data > x ) {
			
			return count + 1;
			
		}
         
		return count;

	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
        
		int x = s.nextInt();
		
		TreeNode<Integer> root = takeInput(s);

		s.close();

		int ans = numNodeGreater(root, x);

		System.out.println(ans);

	}

	

}
