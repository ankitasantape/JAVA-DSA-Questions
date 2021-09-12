package Stacks;

public class StackUse {

	public static void main(String[] args) throws StackFullException  {
		
		// stack obj se sirf functions ko access kr skte hai but array aur top ko access nhi kr skte becoz they are private if they were public then we could access top and array then external user could be set top = 100 then gadbad ho jati  
		StackUsingArray stack = new StackUsingArray(3);
		
		for ( int i = 1; i <= 5; i++ ) {
			
			stack.push(i);
		}

		while ( !stack.isEmpty() ) {
			
			try {
				
				System.out.println(stack.pop());
			
			} catch (StackEmptyException e) {
				
				//never reach here
				//e.printStackTrace();
			}
		}
	}

}
