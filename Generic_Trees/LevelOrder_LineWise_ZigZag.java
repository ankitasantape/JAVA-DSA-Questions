package Generic_Trees;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 
40 30 20 
50 60 70 80 90 100 
120 110 
 */
public class LevelOrder_LineWise_ZigZag {

	private static class Node {
	    int data;
	    ArrayList<Node> children = new ArrayList<>();
	  }

	  public static void display(Node node) {
	    String str = node.data + " -> ";
	    for (Node child : node.children) {
	      str += child.data + ", ";
	    }
	    str += ".";
	    System.out.println(str);

	    for (Node child : node.children) {
	      display(child);
	    }
	  }

	  public static Node construct(int[] arr) {
	    Node root = null;

	    Stack<Node> st = new Stack<>();
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i] == -1) {
	        st.pop();
	      } else {
	        Node t = new Node();
	        t.data = arr[i];

	        if (st.size() > 0) {
	          st.peek().children.add(t);
	        } else {
	          root = t;
	        }

	        st.push(t);
	      }
	    }

	    return root;
	  }

	  public static int size(Node node) {
	    int s = 0;

	    for (Node child : node.children) {
	      s += size(child);
	    }
	    s += 1;

	    return s;
	  }

	  public static int max(Node node) {
	    int m = Integer.MIN_VALUE;

	    for (Node child : node.children) {
	      int cm = max(child);
	      m = Math.max(m, cm);
	    }
	    m = Math.max(m, node.data);

	    return m;
	  }

	  public static int height(Node node) {
	    int h = -1;

	    for (Node child : node.children) {
	      int ch = height(child);
	      h = Math.max(h, ch);
	    }
	    h += 1;

	    return h;
	  }

	  public static void traversals(Node node){
	    System.out.println("Node Pre " + node.data);

	    for(Node child: node.children){
	      System.out.println("Edge Pre " + node.data + "--" + child.data);
	      traversals(child);
	      System.out.println("Edge Post " + node.data + "--" + child.data);
	    }

	    System.out.println("Node Post " + node.data);
	  }

	  public static void levelOrderLinewiseZZ(Node node){
	       Stack<Node> ms = new Stack<>();
	       ms.add(node);
	       
	       Stack<Node> cs = new Stack<>();
	       int level = 1;
	       
	       while (ms.size() > 0) {
//	    	   Remove
	    	   node = ms.pop();
//	    	   Print
	    	   System.out.print(node.data+ " ");
	    	 
//	    	   AddChildren
	    	   if (level % 2 == 1) {
//	    		   for odd level --> traverse from left to right
	    		   for(int i = 0; i < node.children.size(); i++) {
	    			   Node child = node.children.get(i);
//	    	    	   AddChildren
	    			   cs.push(child);
	    		   }
	    	   } else {
//	    		   for even level --> traverse from right to left
	    		   for(int i = node.children.size()-1; i >= 0; i--) {
	    			   Node child = node.children.get(i);
//	    	    	   AddChildren
	    			   cs.push(child);
	    		   }
	    	   }
	    	   
//	    	   copy childStack into mainStack
	    	   if (ms.size() == 0) {
	    		   ms = cs;
//	    		   create new empty childStack
	    		   cs = new Stack<>();
	    		   level++;
//	    		   enter
	    		   System.out.println();
	    	   }
	       }
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(values[i]);
	    }

	    Node root = construct(arr);
	    levelOrderLinewiseZZ(root);
	  }

}
