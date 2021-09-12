package Stacks;

import java.util.Stack;

public class StackToQueueAdapter_Add_efficient {
	public static class StackToQueueAdapter{
		Stack<Integer> mainS;
		Stack<Integer> helperS;
		
		public StackToQueueAdapter() {
			mainS = new Stack<>();
			helperS = new Stack<>();
		}
		
		int size() {
			return mainS.size();
		}
//		add constant time me chalna chahiye
		void add(int val) {
			
			mainS.push(val);
			
		}
//		remove and peek constant time me implement krne hai
		int remove() {
			if(size() == 0) {
				System.out.println("Queue underflow!");
				return -1;
			}else {
				while( mainS.size() > 1) {
					helperS.push(mainS.pop());
				}
				
				int val = mainS.pop();
//				helperS.push(val);
				
				while(helperS.size() > 0) {
				   mainS.push(helperS.pop());	
				}
				
				return val;
			}
		}
		
		int peek() {
			if(size() == 0) {
				System.out.println("Queue underflow!");
				return -1;
			}else {
				while( mainS.size() > 1) {
					helperS.push(mainS.pop());
				}
				
				int val = mainS.pop();
				helperS.push(val);
				
				while(helperS.size() > 0) {
				   mainS.push(helperS.pop());	
				}
				
				return val;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
