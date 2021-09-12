package Queues;

public class QueueUsingArray {
       private int data[]; // array for storing data
       private int front; // index at which front element is stored 
       private int rear;  // index at which last element is stored
       private int size; // size - jo queue ka size nikal rha hoga
       
       public QueueUsingArray() {
    	   // front = -1 for empty queue 
    	   front = -1;
    	   // rear = -1 for empty queue
    	   rear = -1;
    	   size = 0;
    	   data = new int[10];
       }
       
       public QueueUsingArray( int capacity ) {
    	   front = -1;
    	   rear = -1;
    	   size = 0;
    	   data = new int[capacity];
       }
       
       public int size() {
    	   
    	   return size;
       }
       
       public boolean isEmpty() {
    	   
    	   return size == 0;
       }
       
       int front() throws QueueEmptyException {
    	   
    	   //whenever, front = -1 in that case size = 0 means queue is empty 
    	   if ( size == 0 ) {
    		 // directly object bna rhe and exception throw kr rhe, uska reference kahi pe store nhi kr rhe
    		   throw new QueueEmptyException();
//    		   QueueEmptyException e = new QueueEmptyException();
//    		   
//    		   throw e;
    	   }
    	   
    	   return data[front];
       }
       
      void enqueue ( int elem ) throws QueueFullException {
    	   
    	   if ( size == data.length ) {
    		  // throw new QueueFullException();
    		   doubleCapacity();
    	   }
    	   
    	   if ( size == 0 ) {
    		   
    		   front = 0;
    	   }
    	   size++;
    	     
    	   // Circular Queue
    	   rear = ( rear + 1 ) % data.length;
    	   

    	   //    	   rear++;

//    	   if ( rear == data.length ) {
//    		   
//    		   rear = 0;
//    	   }
    	   // Queue me data rear end se enter hota hai
    	   data[rear] = elem;
       }
       
    private void doubleCapacity() {
		
    	int temp[] = data;
		
    	data = new int[temp.length * 2];
		
    	int index = 0;
		
		for( int  i = front ; i < temp.length ; i++ ) {
			
			data[i] = temp[i];
			
			index++;
		}
		
		for ( int i = 0; i <= front - 1; i++ ) {
			
			data[index] = temp[i];
			
			index++;
		}
		
		front = 0;
		
		rear = temp.length - 1;
	}
    
	int dequeue() throws QueueEmptyException {
    	   
    	   if ( size ==  0 ) {
    		  
    		   QueueEmptyException e = new QueueEmptyException();
    		   throw e;
    	   }
    	   // Queue me data delete front end se hota hai
    	   int temp = data[front];
    	   size--;
    	   
    	   // Circular queue
    	   
    	   front = ( front + 1 ) % data.length;
//    	   front++;
//    	   if ( front == data.length ) {
//    		   
//    		   front = 0;
//    	   }
    	   
    	   
    	   if ( size == 0) {
    		   
    		   front = -1;
    		   rear = -1;
    	   }
    	   
    	   return temp;
       }
	
/* Let's just imagine one scenario for enqueue operation
 size = 3 , queue-> | 5 | 10 | 15 |IndexOutOfBound 
    
    operation | front | rear  | size
    enque(5)     0      0        1
    enque(10)    0      1        2
    enque(15)    0      2        3
    deque(5)     1      2        2 yha pe size = 2 hai to lgta hai ki hume ek aur elem insert kr skte hai but rear to last index pe hai hum uske bad elem insert nhi kr skte then How to handle this Scenario?
    enque(20)    1      3        3 yaha pe indexOutOfBound aa jayega becoz array ki size = 3 hai to array me index 2 tk hi hai aur rear to 3 pe chala gya mtlab ArrayIndexOutOfBound Exception throw krega
                                   
    so how to handle this situation? Jaisehi rear last index pe pahuch jaye uske bad rear to ++ nhi krenge but ye galat hoga na qki array me space to pada hai 0th index to hum mana kaise kr skte hai hum ek chiz kr skte hai rear ko reset kr skte hai 0th index pe
    hum rear ko ratate krke starting position pe reset kr skte hai kaise pata chala reset kr skte hai becoz size abhi tk end tk pahuchi nhi hai to ek aur index bacha hai to uspe add kr skte
   
   enqueue(int ele ){
     rear++; 
     if( rear == data.length ){
        rear = 0;               * So, this is circular queue qki hum rear ko reset kr pa rhe hai 
     }
     * We Can Skip This Line As Well
     * rear = (rear + 1) % data.length; 
     * Agar rear = 2 hai aur hume rear ho reset krna hai to rear = 0 pe to hum usee aise bhi likh skte hai
     * rear = ( 2 + 1 ) % 3 = 3 % 3 = 0    
   }    
     
   * This scenario for dequeue operation
   * size = 3 , queue-> | 5 | 10 | 15 |IndexOutOfBound 
    
    operation | front | rear | size |index| 0 |  1 |  2 |   
    enque(5)     0      0        0        | 5 |    |    |
    enque(10)    0      1        1        | 5 | 10 |    |
    enque(15)    0      2        3        | 5 | 10 | 15 |
    deque(5)     1      2        2        |   | 10 | 15 |
    deque(10)    2      2        1        |   |    | 15 |             
    enque(20)    2      0        2        | 20|    | 15 | front ka index 20 ko point kr rha hoga aur rear 15 ko point kr rha hoga, agar abhi hum next time dequeue krenge tb front ka element hi delete kr skte hai to 20 which is at front will be deleted which is wrong    
    deque(20)    3      0        1   ArrayIndexOutOfBoundException aayega to hume front ko bhi reset krna chahiye taki next time jb hume koi elem delete krna ho to wo 0th index ka elem delete ho nhi to firse Exception aayega
    
        int dequeue(){
            int temp = data[front];
	        front++;
	        if( front == data.length ){
	            front = 0;
	        }
	        // agar above 3 line ko skip krna hai to front = ( front + 1 ) % data.length kr skte hai
	        size--;
	     
	        if( size == 0 ){
	            front = -1;
	            rear = -1;
	        }
	        return temp;
	     }
            
*/	
	
/* 
     * queue me data rear end se enter hota hai so initially rear = -1 means empty queue
     * first we enter data at 0th index to first rear = 0( rear = rear + 1 = -1 + 1 = 0)
            rear++;  ( rear = 0 )
            data[rear] = elem; 
     * abhi queue me ek element aa gya hai to front(front = -1) ko bhi 0 kr dena chahiye front++(front = 0) rear ko pehle hi 0 kr diya ha
     * aur size++(size = 1) 
     * Phirse rear end pe enqueue krte ha rear++ data[rear] = ele & size++ abhi front ko ++ nhi krte qki insertion sirf rear end se hota hai na ki front end se
     * hume front sirf ek hi bar ++ krna hai jb size == 0 hota hai tb front = 0 krna hai
      
     void enqueue( int elem ) throws QueueFullException {     
            if( size == data.length ){
               throw new QueueFullException();
            }
            if( size == 0 ){
                front = 0;
            }
            rear++;
            size++;
            if( rear == data.length ){
                rear = 0;
            }
            data[rear] = ele;
     }
	
	 int dequeue() throws QueueEmptyException{
	      int temp = data[front];
	      front++;
	      size--;
	     
	      if( size == 0 ){
	          front = -1;
	          rear = -1;
	      }
	      return temp;
	  }    
	      
if 3 size ka array hai jb hum queue me se last element delete krte hai tb front & rear reset hojane chahiye 0 pe
front = 0 , rear = 0 but aise nhi ho rha,Aur humare code ke according front = 3, rear = 2, size = 0 aisa ho rha which is wrong 
to hume kya krna chahiye if( size == 0 ) hai to front and rear dono reset hone chahiye front = 0 & rear = 0 hone chahiye becoz queue me ek bhi element nhi bacha 	      

* Double the Size Of A Queue
  queue -> | 5 | 10 | 15 | 30 |
       
    operation | front | rear | size |index| 0 |  1 |  2 | 3  |  
    enque(5)     0      0        1        | 5 |    |    |    |
    enque(10)    0      1        2        | 5 | 10 |    |    |
    enque(15)    0      2        3        | 5 | 10 | 15 |    |
    enque(30)    0      3        4        | 5 | 10 | 15 | 30 |
    deque(5)     1      3        3        |   | 10 | 15 | 30 |            
    deque(10)    2      3        2        |   |    | 15 | 30 | 
    enque(25)    2      0        3        | 25|    | 15 | 30 |
    enque(30)    2      1        4        | 25| 30 | 15 | 30 |
    
                      rear   front              we have to double the capacity of this queue
     queue -> | 25  |  30  |  15  |  30  | ==>  2 * length of original queue
     
     first copy this array not like that we have done some previous data structure like array and stack 
     we have to copy from front to end of queue which is half part and remaining part from 0 to front-1
     
    copied queue -> | 25 | 30 | 5 | 10 |   |   |   |   |  
        
    
  
*/
}
