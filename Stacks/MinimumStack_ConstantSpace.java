package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class MinimumStack_ConstantSpace {
    public static class MinStack{
    	Stack<Integer> data;
    	int min;
    	
    	public MinStack() {
    		data = new Stack<>();
    	}
    	
    	int size() {
    		return data.size();
    	}
    	
    	void push(int val) {
    		if(data.isEmpty()) {
    			data.push(val);
    			min = val;
    		}else if(val >= min) {
    			data.push(val);
    		}else {
    			min = val;
    			data.push(val + val - min);
    		}
    	}
    	
    	int pop() {
    		if(size() == 0) {
    			System.out.println("Stack Underflow");
    			return -1;
    		}else {
    			if(data.peek() >= min) {
    				return data.pop();
    			}else {
    				int val = min;
//    				we need to restore min value
    				min = 2 * min - data.pop();
    				return val;
    			}
    		}
    	}
    	
    	int top() {
    		if(size() == 0) {
    			System.out.println("Stack Underflow");
    			return -1;
    		}else {
    			if(data.peek() >= min) {
    				return data.peek();
    			}else {
    				return min;
    			}
    		}
    	}
    	
    	int min() {
    		if(size() == 0) {
    			System.out.println("Stack Underflow");
    			return -1;
    		}else {
    			return min;
    		}
    	}
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MinStack st = new MinStack();
		while(n > 0) {
			st.push(sc.nextInt());
			n--;
		}
		
		System.out.println(st.min());
		sc.close();
		
	}

}
