package Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class Dequeue {

	private LinkedList<Integer> list;
	private int capacity;
	
	public Dequeue( int capacity ) {
		
		this.capacity = capacity;
		list = new LinkedList<>();
	}
	public void insertFront(int input) {
		
		if ( list.size() == capacity ) {
			
			System.out.println(-1);
			return ;
		}
		   list.addFirst(input);
	}

	public void insertRear(int input) {
		 
		if ( list.size() == capacity ) {
			
			System.out.println(-1);
			return;
		}
		list.addLast(input);
	}

	public void deleteFront() {
		
        if ( list.isEmpty() ) {
			
			System.out.println(-1);
			return;
		}
		
		list.removeFirst();
	}

	public void deleteRear() {
		   
		if ( list.isEmpty() ) {
			
			System.out.println(-1);
			return;
		}
		
		list.removeLast();
	}

	public int getFront() {
		
		if ( list.isEmpty() ) {
			
			return -1;
		}
		
		return list.getFirst();
	}

	public int getRear() {
		
		if ( list.isEmpty() ) {
			
			return -1;
		}
		
		return list.getLast();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Dequeue dq = new Dequeue(10);

		while(true){
			int choice = s.nextInt(),input;
			switch (choice) {
			case 1:
				input = s.nextInt();
				dq.insertFront(input);
				break;
			case 2:
				input = s.nextInt();
				dq.insertRear(input);
				break;
			case 3:
				dq.deleteFront();
				break;
			case 4:
				dq.deleteRear();
				break;
			case 5:
				System.out.println(dq.getFront());
				break;
			case 6:
				System.out.println(dq.getRear());
				break;
			default:
				return ;
			}  
		}
	} 
}
