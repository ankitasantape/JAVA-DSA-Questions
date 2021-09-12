package Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*Print Tree Level Wise
Send Feedback
For a given a Binary Tree of type integer, print the complete information of every node, when traversed in a level-order fashion.
To print the information of a node with data D, you need to follow the exact format :

           D:L:X,R:Y

Where D is the data of a node present in the binary tree. 
X and Y are the values of the left(L) and right(R) child of the node.
Print -1 if the child doesn't exist.
Example:
alt text

For the above depicted Binary Tree, the level order travel will be printed as followed:

1:L:2,R:3
2:L:4:,R:-1
3:L:5:,R:6
4:L:-1:,R:7
5:L:-1:,R:-1    
6:L:-1:,R:-1
7:L:-1:,R:-1

Note: There is no space in between while printing the information for each node.
Input Format:
The first and the only line of input will contain the node data, all separated by a single space. Since -1 is used as an indication whether the left or right node data exist for root, it will not be a part of the node data.
Output Format:
Information of all the nodes in the Binary Tree will be printed on a different line where each node will follow a format of D:L:X,R:Y, without any spaces in between.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
 Sample Output 1:
8 :L: 3,R:10
3 :L: 1,R: 6
10:L:-1,R:14
1 :L:-1,R:-1
6 :L: 4,R: 7
14:L:13,R:-1
4 :L:-1,R:-1
7 :L:-1,R:-1
13:L:-1,R:-1
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
 Sample Output 2:
1:L:2,R:3
2:L:4,R:5
3:L:6,R:7
4:L:-1,R:-1
5:L:-1,R:-1
6:L:-1,R:-1
7:L:-1,R:-1
*/
public class LevelWiseInputOutput {
     
     public static void printLevelWise2(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
        pendingNodes.add(null);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

        
	        if (frontNode == null) {
	            System.out.println();

	            if (!pendingNodes.isEmpty()) {
	                pendingNodes.add(null);
	            }

	        } else {
	        	System.out.print(frontNode.data+":");
	    		if( frontNode.left != null ) {
	    			System.out.print("L:"+frontNode.left.data+",");
	    			pendingNodes.add(frontNode.left);
	    		}else {
	    			System.out.print("L:"+ -1 + ",");
	    		}
	    		if( frontNode.right != null ) {
	    			System.out.println("R:"+frontNode.right.data);
	    			pendingNodes.add(frontNode.right);
	    		}else {
	    			System.out.println("R:"+ -1 );
	    		}
	    		//System.out.println();
	        }

		}
		
	}

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		   Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			
		   queue.add(root);
		  // queue.add(null);
			
		   while ( !queue.isEmpty() ) {
			    
			   BinaryTreeNode<Integer> frontNode = queue.poll();
			   
			   System.out.print(frontNode.data +":");
			  
			   if ( frontNode.left != null) {

					System.out.print("L:" + frontNode.left.data + ",");
					queue.add(frontNode.left);
			   } 
			   else
			   {
				   System.out.print("L:"+ -1 + ",");
			   }

				if ( frontNode.right != null) {

					System.out.println("R:" + frontNode.right.data );
					queue.add(frontNode.right);
				}
			    else 
			    {
				    System.out.print("R:" + -1 );
			    }
			    
				System.out.println();
		   }
			
	}

	public static BinaryTreeNode<Integer> takeInput( ) {
		
		Scanner s = new Scanner(System.in);
		//ye wo nodes hai jinke child nahi pahuche hai abhi tk jaiseki 1 ka input le liya hai but uske child ka input nahi aaya hai abhi tk to un nodes ko uthake pendingnodes me dal diya taki hume apna input turant mil jaye next time 1 ke children puch lenge
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		
		//System.out.println("Enter root data: ");
		int rootdata = s.nextInt();
		//if someone don't want to give tree input just give -1 and return null it means there is no tree(empty tree)
		if ( rootdata == -1 ) {
			
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		
		pendingNodes.add(root);
		
		while ( !pendingNodes.isEmpty() ) {
			
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
			
			//System.out.println("Enter left child of " + frontNode.data );
			int leftChild = s.nextInt();
			
			if ( leftChild != -1 ) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
				pendingNodes.add(child);
				frontNode.left = child;
			}
			
			//System.out.println("Enter right child of " + frontNode.data );
			int rightChild = s.nextInt();
			
			if ( rightChild != -1 ) {
				
				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
				pendingNodes.add(child);
				frontNode.right = child;
				
			}
			
		}
	  	
		s.close();
	   return root;	
	}

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> root = takeInput();
		
		//print(root);
		
		printLevelWise(root);
		
		printLevelWise2(root);
	}
}
