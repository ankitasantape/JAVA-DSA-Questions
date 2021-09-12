package Stacks;

public class TwoStacksInAnArray {

	public class TwoStack {
		int data[];
		int tos1;
		int tos2;
		
		public TwoStack(int cap) {
			data = new int[cap];
			tos1 = -1;
			tos2 = data.length;
		}
		
		int size1() {
			return tos1 + 1;
		}
		
		int size2() {
			return data.length - tos2;
		}
		
		void push1(int val) {
		   	if(tos2 == tos1 + 1) {
		   		System.out.println("Stack Full");
		   	}else {
		   		tos1++;
		   		data[tos1] = val;
		   	}
		}
        void push2(int val) {
        	if(tos2 == tos1 + 1) {
		   		System.out.println("Stack Full");
		   	}else {
		   		tos2--;
		   		data[tos2] = val;
		   	}
		}
        
        int pop1() {
        	if(size1() == 0) {
            	System.out.println("Stack underflow");
            	return -1;
            }else {
            	int val = data[tos1];
            	tos1--;
            	return val;
            }
		}

		int pop2() {
			if(size2() == 0) {
            	System.out.println("Stack underflow");
            	return -1;
            }else {
            	int val = data[tos2];
            	tos2++;
            	return val;
            }
		}

		int peek1() {
            if(size1() == 0) {
            	System.out.println("Stack underflow");
            	return -1;
            }else {
            	int val = data[tos1];
            	return val;
            }
		}

		int peek2() {
			if(size2() == 0) {
            	System.out.println("Stack underflow");
            	return -1;
            }else {
            	int val = data[tos2];
            	return val;
            }
		}
	}
	public static void main(String[] args) {
		
	}

}
