package Queues;

import java.util.Scanner;

public class DequeueUse {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);	
		 
		Dequeue queue = new Dequeue(10);

		while ( true ) {
			
			int choice = s.nextInt(), input;
			
			switch(choice) {
				case 1:
					    input = s.nextInt();
					    queue.insertFront(input);
					    break;

				case 2:
					    input = s.nextInt();
					    queue.insertRear(input);
					    break;

				case 3:
					    queue.deleteFront();
					    break;

				case 4:
					    queue.deleteRear();
					    break;
				
				case 5:
				        System.out.println(queue.getFront());
				        break;
				
				case 6:
				     
					    System.out.println(queue.getRear());
			            break;

				default: 
					   
					    return;
			}

			s.close();
		}
		
		
	}
	
	

}
