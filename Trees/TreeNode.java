import java.util.ArrayList;

public class TreeNode<T> {
      public T data;
      public ArrayList<TreeNode<T>> children; // ArrayList of children of type TreeNode & TreeNode of type T
       
      public TreeNode( T data) {
    	  this.data = data;
    	  children = new ArrayList<>(); //
      }
       
}
