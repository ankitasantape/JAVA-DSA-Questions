package Graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Code : Get Path - BFS
Send Feedback
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), 
find and print the path from v1 to v2 (if exists). 
Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
Print the path from v1 to v2 in reverse order.
Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
*/
public class GetPathBFS {

	public static void main(String[] args)  throws NumberFormatException, IOException{
	    
	 Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int e = sc.nextInt();
     int edges[][] = new int[n][n];
     for( int i = 0; i < e; i++ ) {
  	   
       int fv = sc.nextInt();
  	   int sv = sc.nextInt();
  	   edges[fv][sv] = 1;
  	   edges[sv][fv] = 1;
  			
     }
     
     int start = sc.nextInt();
     int end = sc.nextInt();
     HashMap<Integer, Integer > map = new HashMap<>();
     boolean visited[] = new boolean[edges[0].length];
     getpath( edges, start, end, visited, map );
     sc.close();
     
	}

	private static void getpath(int[][] edges, int start, int end, boolean[] visited, HashMap<Integer, Integer> map) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int n = edges.length;
		int e = 0;
		while( q.size() != 0 ) {
			int remov = q.remove();
			visited[remov] = true;
			
			for( int i = 0; i < n; i++ ) {
				if( edges[remov][i] == 1 && !visited[i] ) {
					map.put( i , remov );
					visited[i] = true;
					q.add(i);
					if( i == end ) {
						e = 1;
					}
					if( e == 1 ) {
						break;
					}
				}
				if( e == 1 ) {
					break;
				}
			}
		}
		if( e == 1 ) {
			int last = map.get( end );
			System.out.print( end + " ");
			
			while( last != end ) {
				
				System.out.print(last+" ");
				if( map.get(last) != null )
					last = map.get(last);
				else {
					break;
				}
			}
		}
	}

	
}
