package Stacks;

public class StackUsingArray {
//arr and top should be private becoz koi bhi external user same package me StackUsingArray ka obj bna ke data[] and top ko access kr skte hai aur change bhi kr skte hai to hume iska access kisiko bhi nhi dena except StackUsingArray Class itself
     private  int a[];
     private  int top = -1; //top is the index of topmost element of a stack 
	
     public StackUsingArray() {
		
    	 // initially 10 size ka array set krenge
		a = new int[10];
//top = 0 means stack ke 0th index pe element pada hai if stackEmpty represent krna hai to top = -1 hi set krna padega becoz -1 is invalid index   	
		top = -1;
	 }
     // Agar hume stack ki size change krni hai to
     public StackUsingArray( int capacity ) {
 		
 		a = new int[capacity];
 		top = -1;
 	 }
     /* Kya public static boolean isEmpty(){} funtion static ho skta hai? static variables are those who belongs to whole class, naya stack banana mtlab stack ka ek object banana jaise Student class ke liye naya student banana mtlab Student class ka object banana
        So, naya Stack banana mtla Stack class ka naya obj banana, to kya sare Stack ke liye isEmpty() fun common hone chahiye nahi bilkul nahi every stack should its own func jo batayega ki wo wala stack empty hai ya nahi to ye shared property nahi hai sare stack ki ye hr StackUsingArray ki individual property hai to static nahi krna chahiye ese   */
     public boolean isEmpty() {
    	
    	 return (top == -1);
     }
     
     public int size() {
    	 
    	 // size = - 1 + 1 = 0
    	 return top + 1;
     }
     
     public int top() throws StackEmptyException {
    	 
// if top = -1 and u r going return a[top] in this case stack is empty that means u will be gonna return element from empty stack then it will throw stackEmptyException()  
    	 if(size() == 0) {
    		 
    		 StackEmptyException e = new StackEmptyException();
    		 throw e;
    	 }
    	 // Jo element stack ke top pe pada hoga wo element return krega 
    	 return a[top];
     }
     
     // Time Complexity - O(1) ,but in case of doubleCapacity() func calling then puch() fun takes O(n) time complexity which is very rare  
     public void push( int elem ) throws StackFullException {
    	 
    	 // In case size of stack equal ho gya hai array of size then stack full ho chuka hai aur aise me hume stack me insert nhi kr skte so hume StackFullException throw krni chahiye 
    	 if ( size() == a.length) {
    		 
//    		 StackFullException e = new StackFullException();
    		 
//    		 throw e;
    		 
    		 /* If we want to double the size of the array */ 
    		 
    		
    		 doubleCapacity();
    	 }
    	 // initially, top = -1 hoga so we need increment it by 1 then top++(top = -1 + 1 = 0 ) => top = 0 hoga aur stack ke 0th index pe element insert hoga
    	 top++; 
    	 
    	 a[top] = elem ;
     }
    // Time Complexity - O(n)
     private void doubleCapacity() {
		
    	 int temp[] = a;
		 
		 a = new int[ 2 * temp.length ];
		 
		 for( int i = 0; i <= top; i++ ) {
			 
			 a[i] = temp[i];
		 }
		 
	}

	public int pop() throws StackEmptyException {
    	// Jaise EmptyStack me kuch insert nhi kr skte waisehi EmptyStack se kuch pop nhi kr skte 
        if(size() == 0) {
    		 
    		 StackEmptyException e = new StackEmptyException();
    		 throw e;
    	 }
        // hume array of top ka element temp me store krke top ko 1 se decrement kr rhe hai but actually array se remove nhi kr rhe sirf array ki size decrement kr rhe taki top ka element return krne ke bad next top usse chota index hi top banega isliye hum top ko top-- kr rhe   
        int temp = a[top];
        // new top banane ke liye this top ko 1 se sift krke piche le aayenge means top-- krenge
        top--;
        return temp;
     }
}
