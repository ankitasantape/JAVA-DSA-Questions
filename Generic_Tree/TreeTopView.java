package Generic_Tree;

import java.util.Scanner;
/*
 Given a pointer to the root of a binary tree, print the top view of the binary tree.

The tree as seen from the top the nodes, is called the top view of the tree.

For example :

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
Top View : 1 -> 2 -> 5 -> 6

Complete the function topView  and print the resulting values on a single line separated by space.

Input Format

You are given a function,

void topView(node * root) {

}
Constraints

 1 <= Nodes in the tree <= 500  

Output Format

Print the values on a single line separated by space.

Sample Input

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4

6
1 2 5 3 6 4

Sample Output

1 2 5 6

Explanation

   1
    \
     2
      \
       5
      /  \
     3    6
      \
       4
From the top, only nodes 1,2,5,6 are visible.
*/
class NodeList {
    NodeList left;
    NodeList right;
    int data;
    
    NodeList(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeTopView {

	public static void topView(NodeList root) {
		
		if(root != null) {

		        top_view(root.left, true);

		        System.out.print(root.data + " ");

		        top_view(root.right, false);

		 }
	      
    }
	private static void top_view(NodeList node, boolean goLeft) {

	    if(node != null) {
	        if(goLeft) {
	            top_view(node.left, goLeft);
	            System.out.print(node.data + " ");
	        } else {
	            System.out.print(node.data + " ");
	            top_view(node.right, goLeft);
	        }
	    } 

	}
	public static NodeList insert(NodeList root, int data) {
        if(root == null) {
            return new NodeList(data);
        } else {
        	NodeList cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        NodeList root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
