package Generic_Tree;

/*Check if generic tree contain element x

Given a generic tree and an integer x, check if x is present in the given tree or not. 
Return true if x is present, return false otherwise.
Input format :

Line 1 : Integer x

Line 2 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : true or false

Sample Input 1 :
40
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
true
Sample Input 2 :
4
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
false
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTreeContainsElemntOrNot {
	
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

	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
          
           if ( root == null ) {
			
			   return false;
		   }
           
           if ( root.data == x ) {
        	   
        	   return true;
           }
          
           boolean ans = false;
          
           for ( int i = 0; i < root.children.size(); i++ ) {
			   
			   ans = checkIfContainsX( root.children.get(i) , x);
			   
			   if ( ans ) {
			    	
			    	return true;
			    	
			    }
		   }
          
		    
		    
		    return ans;
	}
	
    public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		
		TreeNode<Integer> root = takeInput(s);
		
		boolean ans = checkIfContainsX(root, x);
		
		System.out.println(ans);
		
		s.close();
	}

}
