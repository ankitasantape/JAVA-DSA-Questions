package Graph;

import java.util.Scanner;
/*Code : DFS Traversal
Send Feedback
Given an undirected and disconnected graph G(V, E), print its DFS traversal.
Note:
1. Here you need to consider that you need to print DFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
Output Format :
Print the DFS Traversal, as described in the task.
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 2 3 
*/

public class DFSTraversal {

	public static void DFShelper( int [][]edges, int sv, boolean[] visited ) {
		System.out.println( sv );
		visited[sv] = true;
		int n = edges.length;
		for( int i = 0; i < n; i++ ) {
			if( edges[sv][i] == 1 && !visited[i] ) {
			     DFShelper( edges, i, visited );	
			}
		}
	}
	
	public static void print( int edges[][] ) {
		boolean[] visited = new boolean[ edges.length ];
		for( int i = 0; i < edges.length; i++ ) {
			if( !visited[i] ) {
				DFShelper( edges, i , visited );
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int n ;
		int e ;
		Scanner sc = new Scanner( System.in );
		n = sc.nextInt();
		e = sc.nextInt();
		
		int edge[][] = new int[n][n];
		
		for( int i = 0; i < e; i++ ) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			edge[fv][sv] = 1;
			edge[sv][fv] = 1;
		}
		
		print( edge );
		sc.close();
	}

}
