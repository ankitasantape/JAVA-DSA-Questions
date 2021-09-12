package Generic_Tree;

/*Node having sum of children and node is max
Send Feedback
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with maximum sum.

Sample Input 1 :
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
Sample Output 1 :
1
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class MaxSumOfNode {
	
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

	public static int sumOfAllNode(TreeNode<Integer> root) {

		if (root == null) {

			return 0;
		}

		int sum = root.data;

		for (int i = 0; i < root.children.size(); i++) {

			sum += root.children.get(i).data;
		}

		return sum;
	}

	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		
		    if (root == null) {

				return null;
			}

			TreeNode<Integer> ans = root;
			int sum = sumOfAllNode(root);
			
			TreeNode<Integer> maxNode = null;
			int maxSum = Integer.MIN_VALUE;
		    
		    for (int i = 0; i < root.children.size(); i++) {

			   TreeNode<Integer> x = maxSumNode(root.children.get(i));
			   
			   int xsum = sumOfAllNode(x);
			   
			   if ( xsum > maxSum ) {
				   
				   maxSum = xsum;
				   maxNode = x;
			   }
			}
		    
		    if ( sum > maxSum ) {
		    	
		    	return ans;
		    }

			return maxNode;
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
        
		TreeNode<Integer> root = takeInput(s);

		s.close();

		TreeNode<Integer> ans = maxSumNode(root);

		System.out.println(ans.data);

	}


}
