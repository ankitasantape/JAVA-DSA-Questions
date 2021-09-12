package Stacks;

import java.util.Stack;

public class MinimumStack_1 {
    
	public static class MinStack{
		Stack<Integer> allData;
		Stack<Integer> minData;
		
		public MinStack() {
			allData = new Stack<>();
			minData = new Stack<>();
		}
		
		int size() {
			return allData.size();
		}
		
		void push(int val) {
			allData.push(val);
			
			if(minData.size() == 0 || val <= minData.peek()) {
				minData.push(val);
			}
		}
		
		int pop() {
			if(size() == 0) {
				System.out.println("Stack Underflow!");
				return -1;
			}else if(minData.peek() == allData.peek()) {
				return minData.pop();
			}
			return allData.pop();
		}
		
		int top() {
			if(size() == 0) {
				System.out.println("Stack Underflow!");
				return -1;
			}else {
				return allData.peek();
			}
			
		}
		
		int min() {
			if(size() == 0) {
				System.out.println("Stack Underflow!");
				return -1;
			}else {
				return minData.peek();
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
