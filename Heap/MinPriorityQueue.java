package Heap;

import java.util.ArrayList;
import java.util.Scanner;
/*Code : Remove Min

Implement the function RemoveMin for the min priority queue class.
For a minimum priority queue, write the function for removing the minimum element present. Remove and return the minimum element.
Note : main function is given for your reference which we are using internally to test the code.

*Sample Input : 1 3 1 4 1 63 1 21 1 9 2 3 1 7 3 4 5 3 3 -1
*Sample Output: 
3
3
4
4
false */
public class MinPriorityQueue {

	ArrayList<Integer> heap = new ArrayList<>();
	
	public MinPriorityQueue(){
		heap = new ArrayList<>();
	}
	
	int size() {
		return heap.size();
	}
	
	Boolean isEmpty() {
		return heap.size() == 0;
	}
	
	int getMin() throws PriorityQueueException {
		if(heap.isEmpty()) {
			
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	
	void insert( int element ) {
		heap.add( element );

// Value insert krdi ab check kro kya given tree heap order property follow krti hai? 
// Check krna hai to Upheapify krna padega	
		
	    upheapify(heap);
		
	}
	// Time Complexity - O(nlogn) Space Complexity - O(n)
	void upheapify(ArrayList<Integer> heap ) {
		int childIndex = heap.size() - 1;
		int parentIndex = ( childIndex - 1 )/ 2;
		
		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {

				return;
			}
		}
	}
	
    int removeMin() throws PriorityQueueException {
		
    	if(isEmpty()) {
    		
    		throw new PriorityQueueException();
    	}
    	int val = heap.get(0);
    	heap.set(0, heap.get(heap.size() - 1) );
    	heap.remove( heap.size() - 1);
    	downheapify(heap);
    	
		return val;
	}
    // Time Complexity - O(nlogn) Space Complexity - O(n)
    void downheapify(ArrayList<Integer> heap) {
    	int parentIndex = 0;
    	int leftChildIndex =  1;
    	int rightChildIndex = 2;
    	int minIndex = parentIndex;
		while ( leftChildIndex < heap.size() ) {
		
// hume 3no node ko compare krna padega( root, leftchild & rightchild) jiski value choti hogi usko root banana padega means parent index pe sbse choti wali value jayege
			
			if ( heap.get(leftChildIndex) < heap.get(minIndex)) {
				
				minIndex = leftChildIndex;
			}
			if ( rightChildIndex < heap.size() &&  heap.get(rightChildIndex) < heap.get(minIndex)) {
				
				minIndex = rightChildIndex;
			}
			
			if( minIndex == parentIndex ) {
				break;
			}
			else {
				
				int temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(minIndex));
				heap.set(minIndex, temp);
				
				parentIndex = minIndex;
				leftChildIndex = 2 * parentIndex + 1;
				rightChildIndex = 2 * parentIndex + 2;
				
			} 
		}
    }
	public static void main(String[] args) throws PriorityQueueException {
		Scanner s = new Scanner(System.in);
		MinPriorityQueue pq = new MinPriorityQueue();
		int choice = s.nextInt();
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					pq.insert(element);
					break;
				case 2 : // getMin
				try {
					System.out.println(pq.getMin());
				} catch (PriorityQueueException e) {
					return;
				}
					break;
				case 3 : // removeMin
				System.out.println(pq.removeMin());
					break;
				case 4 : // size
					System.out.println(pq.size());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = s.nextInt();
		}
		
		s.close();
	}

	
	
}
