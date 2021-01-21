package BinarySearchTree;


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
    	
		  if ( data > root.data )
		  {
			  root.right = remove( data, root.right );
		      return root;
			  
		  } else if ( data < root.data) {
			  
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
				  
				  BinaryTreeNode<Integer> minNode = root.right;
				  
				  while ( minNode.left != null ) {
					  
					  minNode = minNode.left;
				  }
				  
				  root.data = minNode.data;
				  
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
