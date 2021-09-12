package Generic_Tree;

class Node<T> {
	T data;
	Node<T> next;

	public Node(T root) {
		this.data = root;
		this.next = null;
	}
}
public class QueueUsingLL<T> {
    
	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	
	public QueueUsingLL() {
		
		front = null;
		rear = null;
		size = 0;
		
	}
	

	public int getSize() { 
		
		return size;
    }


    public boolean isEmpty() { 
    	
    	return size == 0;
    }


    public void enqueue(T root) {
    	
       Node<T> newNode = new Node<T>(root);
     
       if ( size == 0 ) {	
    	
    	   front  = newNode;
    	   rear = newNode;
    	
       } else {
    		
    		rear.next = newNode;
    		rear = newNode;
    	}
    	
    	size++;
    }


    public T dequeue() throws QueueEmptyException {
    	
    	if ( size == 0 ) {
    		
    		throw new QueueEmptyException();
    	}
    	T temp = front.data;
    	
    	if ( size == 1 ) {
    		
    		temp = front.data;
    		
    		front = null;
    		
    		rear = null;
    		
    		size = 0;
    		
    	} 
    	else {
    	
    	    front = front.next;
    	
    	    size--;
    	}
		return temp;
    	
    }


    public T front() throws QueueEmptyException {
    	
    	if ( size == 0 ) {
 		   
    		throw new QueueEmptyException();
 	   }
 	   
 	   return front.data;
    }


	
}