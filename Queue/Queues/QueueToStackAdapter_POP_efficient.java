package Queues;
import java.util.*;
public class QueueToStackAdapter_POP_efficient {

	public static class QueuetoStackAdapter{
		Queue<Integer> mainQ;
		Queue<Integer> helperQ;
		
		public QueuetoStackAdapter() {
			mainQ = new ArrayDeque<>();
			helperQ = new ArrayDeque<>();
		}
		
		int size() {
			return mainQ.size();
		}
//		push linear time me chalna chahiye
		void push(int val) {
			while(mainQ.size() > 0) {
				helperQ.add(mainQ.remove());
			}
			
			mainQ.add(val);
			
			while(helperQ.size() > 0) {
				mainQ.add(helperQ.remove());
			}
		}
		
//		pop and top constant time me chalne chahiye
		int pop() {
			if(size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}else {
				return mainQ.remove();
			}
		}
		
		int top() {
			if(size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}else {
				return mainQ.peek();
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
