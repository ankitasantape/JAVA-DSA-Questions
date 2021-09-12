package Graph;

import java.util.Arrays;
import java.util.Scanner;
/*Code : Kruskal's Algorithm
Send Feedback
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
Print the MST, as described in the task.
Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
1 2 1
0 1 3
0 3 5
*/
public class MinimumSpanningTree {

	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;
		
		Edge( int src, int dest, int weight ){
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
        // Comparator function used for sorting edges based on their weight  
		@Override
		public int compareTo(Edge o) {
               // For increasing order & For decreasing order reverse this statement
               return this.weight - o.weight ;
		}
		
		
	}
	
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
         
		Edge[] input = new Edge[E];
		for( int i = 0; i < input.length ; i++ ) {
			input[i] = new Edge( sc.nextInt() , sc.nextInt(), sc.nextInt() );
		}
		
		Kruskals( input, V );
		
		sc.close();
	}


	private static void Kruskals(Edge[] input, int v) {
		
		Arrays.sort( input );
		
		Edge[] output = new Edge[ v - 1 ];
		
		int parent[] = new int[ v ];
		
		for( int i = 0; i < v; i++ ) {
			
			parent[i] = i;
		}
		
		int i = 0;
		int count = 0;
		while( count != v - 1 ) {
			
			Edge currentEdge = input[i];
			
			int sourceVertx = findParent( currentEdge.src, parent );
			int destVertx = findParent( currentEdge.dest , parent );
			
			if( sourceVertx != destVertx ) {
				
				output[count] = currentEdge;
				count++;
				parent[sourceVertx] = destVertx;
			}
			i++;
		}
		
		for( int j = 0; j < v-1 ; j++ ) {
			if( output[j].src < output[j].dest ) {
				System.out.println(output[j].src +" "+output[j].dest + " " + output[j].weight);
			} else {
				System.out.println(output[j].dest +" "+output[j].src +" "+output[j].weight);
			}
		}
		
	}


	private static int findParent(int src, int[] parent) {
		
		if( parent[src] == src ) {
			return src;
		}
		
		return findParent( parent[src], parent );
	}


}
