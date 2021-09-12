package Binary_Tree;

//class QueueEmptyException extends Exception {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//}

//class Node<T> {
//	T data;
//	Node<T> next;
//	Node(T data){
//		this.data = data;
//	}
//}
//class QueueUsingLL<T> {
//
//		private Node<T> head;
//		private Node<T> tail;
//		private int size = 0;
//
//		public int size(){
//			return size;
//		}
//
//		public boolean isEmpty(){
//			if(size == 0){
//				return true;
//			}
//			return false;
//		}
//
//		public T front() throws QueueEmptyException{
//			if(size == 0){
//				QueueEmptyException e = new QueueEmptyException();
//				throw e;
//			}
//
//			return head.data;
//		}
//
//
//		public void enqueue(T element){
//			Node<T> newNode = new Node<T>(element);
//
//			if(head == null){
//				head = newNode;
//				tail = newNode;
//			}
//			else{
//				tail.next = newNode;
//				tail = newNode;
//			}
//
//			size++;
//		}
//
//		public T dequeue() throws QueueEmptyException{
//			if(head == null){
//				QueueEmptyException e = new QueueEmptyException();
//				throw e;
//			}
//			if(head == tail){
//				tail = null;
//			}
//			T temp = head.data;
//			head = head.next;
//			size--;
//			return temp;
//		}
//}
//
//
