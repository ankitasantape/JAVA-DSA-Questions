package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*Merge K sorted arrays
Send Feedback
Given k different arrays, which are sorted individually (in ascending order). You need to merge all the given arrays such that output array should be sorted (in ascending order).
Hint : Use Heaps.
Input Format :
Line 1 : Integer K
Line 2 : Arrays 1 size (n1)
Line 3 : Array 1 elements (separated by space)
Line 4 : Array 2 size (n2)
and so on for next arrays
Sample Input 1 :
4
3
1 5 9
2
45 90
5
2 6 78 100 234
1
0
Sample Output 1 :
0 1 2 5 6 9 45 78 90 100 234
*/
class Triplet {
	int elem;
	int rowIdx;
	int colIdx;
}

class TripletComparator implements Comparator<Triplet> {

	@Override
	public int compare(Triplet arg0, Triplet arg1) {
		if( arg0.elem <= arg1.elem ) {
			return -1;
		}
		return 1;
	}
	
}
public class MergeKSortedArray {

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
//		TripletComparator tripCom = new TripletComparator();
//		PriorityQueue<Triplet> pq = new PriorityQueue<>(tripCom);
//		for( int i = 0; i < input.size(); i++ ) {
//			if( input.get(i) != null ) {
//				Triplet a = new Triplet();
//				a.elem = input.get(i).get(0);
//				a.rowIdx = i;
//				a.colIdx = 0;
//				pq.add(a);
//			}
//			
//		}
//		ArrayList<Integer> ans = new ArrayList<Integer>();
//		
//		while ( !pq.isEmpty() ) {
//			
//			Triplet a = pq.remove();
//			ans.add( a.elem );
//			
//			if( a.colIdx + 1 < input.get( a.rowIdx ).size() ) {
//				Triplet b = new Triplet();
//				b.elem = input.get( a.rowIdx ).get( a.colIdx + 1);
//				b.rowIdx = a.rowIdx;
//				b.colIdx = b.colIdx + 1;
//				pq.add(b);
//			}
//		}
//		return ans;
		
		PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>();
		int x = input.size();
		for(int i = 0; i < x; i++ ) {
			for( int j = 0; j < input.get(i).size() ; j++ ) {
				
				heap2.add(input.get(i).get(j));
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.addAll(heap2);
		
		Collections.sort(ans);
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		while(k > 0) {
			int n = s.nextInt();
			ArrayList<Integer> current = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				current.add(s.nextInt());
			}
			input.add(current);
			k--;
		}
		ArrayList<Integer> output = mergeKSortedArrays(input);
		for(int i : output) {
			System.out.print(i + " ");
		}
		
		s.close();
	}
}
