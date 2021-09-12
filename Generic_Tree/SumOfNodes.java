package Generic_Tree;

/*Code : Sum of nodes
Send Feedback
Given a generic tree, count and return the sum of all nodes present in the given tree.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Sum of all nodes
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
190
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SumOfNodes {
    
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
	
	public static int sumOfAllNode(TreeNode<Integer> root){
		
	    if (root == null) {

			return 0;
		}

		int sum = root.data;

		for (int i = 0; i < root.children.size(); i++) {

			sum += sumOfAllNode(root.children.get(i));
		}

		return sum;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		TreeNode<Integer> root = takeInput(s);

		s.close();

		int ans = sumOfAllNode(root);

		System.out.println(ans);

	}

}
