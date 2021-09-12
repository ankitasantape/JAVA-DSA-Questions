package Stacks;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapter_PUSH_efficient {

	public static class QueueToStackAdapter{
		Queue<Integer> mainQ;
		Queue<Integer> helperQ;
		
		public QueueToStackAdapter() {
			mainQ = new ArrayDeque<>();
			helperQ = new ArrayDeque<>();
		}
		
		public int size() {
		    return mainQ.size();	
		}
//		push constant hona chahiye
		void push(int val) {
			mainQ.add(val);
		}
//		pop and top linear hone chahiye
		int pop() {
			if(size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}else {
				while(mainQ.size() > 1) {
					helperQ.add(mainQ.remove());
				}
				int val = mainQ.remove();

				while(helperQ.size() > 1) {
					mainQ.add(helperQ.remove());
				}
				return val;
			}
		}
		
		int top() {
			if(size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}else {
				while(mainQ.size() > 1) {
					helperQ.add(mainQ.remove());
				}
				int val = mainQ.remove();
				helperQ.add(val);
				while(helperQ.size() > 1) {
					mainQ.add(helperQ.remove());
				}
				return val;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
