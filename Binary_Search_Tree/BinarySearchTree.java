package Binary_Search_Tree;


public class BinarySearchTree {
    
	private BinaryTreeNode<Integer> root;
    
	public BinarySearchTree() {
		
		root = null;
	}
	
	public boolean search(int data) {
		
		return search(data, root);
	}

	private boolean search(int data, BinaryTreeNode<Integer> root) {
         
		if ( root == null  ) {
			
			return false;
		}
		
		if ( root.data == data ) {
			
			return true;
		
		} else if ( root.data < data ) {
			
			return search( data, root.right );
		
		} else {
			
			return search( data, root.left );
			
		}
		
	}
	
	public void insert( int data ) {
		
		//May be sometimes root = null so we should be assigned updated root 
		root = insert( data, root);
	}
	
    private BinaryTreeNode<Integer> insert( int data , BinaryTreeNode<Integer> root) {
		
		if ( root == null ) {
		   
			BinaryTreeNode<Integer>	newRoot = new BinaryTreeNode<>(data);
			return newRoot ;
		}
		
		if ( data > root.data  ) {
			
		    root.right =  insert( data, root.right );
		}
		
		else {
			
			root.left =  insert( data, root.left );
		}
		
		return root;
		
	}
	
	public void remove( int data ) {
		
		   root = remove( data, root );
	}
	
    private BinaryTreeNode<Integer> remove( int data, BinaryTreeNode<Integer> root ) {
		 
    	  if ( root == null ) {
    		  
    		  return null;
    	  }
    	  // if root ka data less hai data se then right side ko call kro
		  if ( data > root.data )
		  {
			  // after deleting data from right subtree whatever data remove() will return null or not null attach it to the right of root 
			  root.right = remove( data, root.right );
		      return root;
			  
		  } else if ( data < root.data) {
			 // after deleting data from left subtree whatever data remove() will return null or not null attach it to the left of root 
			  root.left =  remove( data, root.left );
			  return root;
		  
		  } else {
			  
			  if ( root.left == null && root.right == null ) {
	    		  
	    		  return null;
	    	  
	    	  } else if ( data == root.data && root.right == null ) {
	    		  
	    		  return root.left;
	    	  
	    	  } else  if ( data == root.data && root.left == null) {

				  return root.right;
			  } else {
				  //Assume root ke right ko minNode, either minNode from right subtree or maxNode from left subtree becoz after deleting rootNode we need newRoot to return 
				  BinaryTreeNode<Integer> minNode = root.right;
				  // Find minNode from right subtree, right subtree ke left subtree ka last root means minNode
				  while ( minNode.left != null ) {
					  
					  minNode = minNode.left;
				  }
				  //Root ke data ko replace krke minNode ko newRoot banayenge and minNode to remove kr denge
				  root.data = minNode.data;
				  //Aur minNode ko finally rightSubtree ke leftSubtree se remove kr denge and updated tree ko root ke right part me attach kr denge
				  root.right = remove( minNode.data , root.right );
				  
				  return root;
			  }
		  }
		  
		  
    }
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
//		Scanner s = new Scanner( System.in );
//		int choice, input;
//		while(true) {
//			choice = s.nextInt();
//			switch(choice) {
//				case 1 : 
//					input = s.nextInt();
//					bst.insertData(input);
//					break;
//				case 2 : 
//					input = s.nextInt();
//					bst.deleteData(input);
//					break;
//				case 3 : 
//					input = s.nextInt();
//					System.out.println(bst.search(input));
//					break;
//				default :
//					bst.printTree();
//					return;
//			}
//           // s.close();   
//		}
		
		bst.insert(10);
		bst.insert(20);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(7);
		
		bst.printTree();
		System.out.println("---------------------------------");
		bst.remove(10);
		bst.printTree();
		
	}

    public void printTree() {
    	
    	print(root);
    }
	
    private void print( BinaryTreeNode<Integer> root ) {
	
		if ( root == null ) {
			
			return;
		}
		
		String toBePrinted = root.data +  ":";
		
		if ( root.left != null ) {
			
			toBePrinted += "L:" + root.left.data + ",";
		}
		
		if (root.right != null) {

			toBePrinted += "R:" + root.right.data ;
		}
		
		System.out.println(toBePrinted);
		
		print( root.left );
		print( root.right );
	}


}