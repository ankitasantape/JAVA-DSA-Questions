package Generic_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Next larger element

Given a generic tree and an integer n. Find and return the node with next larger element in the Tree 
i.e. find a node with value just greater than n.
Return NULL if no node is present with value greater than n.
Input format :

Line 1 : Integer n

Line 2 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with value just greater than n.

Sample Input 1 :
18
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
20
Sample Input 2 :
21
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
30
*/
public class NextLargerNode {
    
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
	
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {

		  if ( root == null  ) {
			  
			  return null;
		  }
		  
		  TreeNode<Integer> ans = null, temp = null;
		  
		  if ( root.data > n ) {
			  
			  ans = root;
		  }
		  
		  for ( int i = 0; i < root.children.size(); i++ ) {
			  
			  TreeNode<Integer> newNode = findNextLargerNode( root.children.get(i), n);
			  
			  if ( newNode == null ) {
				  
				  continue;
			  }
			  
			  if ( newNode.data > n ) {
				
				  temp = newNode;
			  }
			  
			  if ( ans == null ) {
				  
				  ans = temp;
			  }
			  
			  if ( temp.data < ans.data ) {
				  
				  ans = temp;
			  }
		  }
		  
		  return ans;
	}
	
	public static TreeNode<Integer> findNextLargerNode2(TreeNode<Integer> root, int n) {

		  if ( root == null  ) {
			  
			  return null;
		  }
		  
		  int min = Integer.MAX_VALUE;
		  TreeNode<Integer> minNode = null;
		  
		  for ( int i = 0; i < root.children.size(); i++ ) {
			  
			  TreeNode<Integer> childNode = findNextLargerNode2( root.children.get(i), n);
			  
			  if ( childNode == null ) {
				  
				  continue;
			  }
			  
			  int max = childNode.data; 
			  if ( max < min ) {
				  
				  min = max;
				  minNode = childNode;
			  }
		  }
		  
		  if ( root.data > n &&  root.data <  min) {
			  
			  return root;
		  }
		  
		  return minNode;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
         
		int n = s.nextInt();
		
		TreeNode<Integer> root = takeInput(s);

		s.close();

		TreeNode<Integer> ans = findNextLargerNode(root, n);

		System.out.println(ans.data);

	}

}
