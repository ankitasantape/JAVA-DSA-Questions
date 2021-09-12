package Generic_Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
Sample Input

24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
10 20 -50 60 30 70 -80 110 -120 90 40 -100 
-50 60 20 70 110 -120 -80 90 30 -100 40 10 

*/

public class Iterative_PreOrder_And_PostOrder_Traversal {
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
    
	static class Pair{
		Node node;
		int state;
		
		Pair(Node node, int state){
			this.node = node;
			this.state = state;
		}
	}
	
	public static void IterativePreandPostOrder(Node node) {
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(node, -1));
		
		String pre = "";
		String post = "";
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == -1) {
				pre += top.node.data + " ";
				top.state++;
			} else if(top.state == top.node.children.size()) {
				post += top.node.data + " ";
//				post order ke bad recursion khtm ho jati hai so pop the data
				st.pop();
			} else { 
				// inorder me top.state = 0th position ka data get krenge aur bydefault state = -1 rahegi
				Pair cp = new Pair(top.node.children.get(top.state), -1);
				st.push(cp);
				
				top.state++;
			}
		}
		
		System.out.println(pre);
		System.out.println(post);
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
		IterativePreandPostOrder(root);
	}
}
