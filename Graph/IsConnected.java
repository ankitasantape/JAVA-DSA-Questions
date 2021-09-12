package Graph;

import java.io.IOException;
import java.util.Scanner;

/*Code : Is Connected ?
Send Feedback
Given an undirected graph G(V,E), check if the graph G is connected graph or not.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
Output Format :
The first and only line of output contains "true" if the given graph is connected or "false", otherwise.
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
true
Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
false 
Sample Output 2 Explanation
The graph is not connected, even though vertices 0,1 and 3 are connected to each other but there isn’t any path from vertices 0,1,3 to vertex 2. 
*/
public class IsConnected {

	public static void main(String[] args) throws NumberFormatException, IOException {
	       
        Scanner s = new Scanner( System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        if( n == 0 && e == 0 ){
            System.out.println("true");
            System.exit(0);
        }
        int edges[][] = new int[n][n];
        for( int i = 0; i < e; i++ ) {
        	int fv = s.nextInt();
        	int sv = s.nextInt();
        	edges[fv][sv] = 1;
        	edges[sv][fv] = 1;
        }
        
        boolean visited[] = new boolean[edges.length];
        help( edges, visited, 0 );
        
        int length = visited.length;
        int i = 0;
        while( i < length ) {
        	if( visited[i] != true ) {
        		System.out.print("false");
        		System.exit(0);
        	}
        	i++;
        }
        System.out.println("true");
        System.exit(0);
        
        s.close();
	}

	private static void help(int[][] edges, boolean[] visited, int fv) {
		visited[fv] = true;
		int n = edges.length;
		for( int j = 0; j < n; j++ ) {
			if( edges[fv][j] == 1 && !visited[j] ) {
				help( edges, visited, j);
			}
		}
	}
}
