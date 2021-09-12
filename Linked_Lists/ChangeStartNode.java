package Linked_Lists;

import java.util.Scanner;

/*Change Start Node
Level EASY
Make the nth node from end of linked list as starting node.
You just need to return the head of new linked list, don't print the elements.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Line 2 : An integer N i.e. the position of new head from last node.
Output format :
Updated list elements (separated by space)
Constraints :
1 <= n <= 10^4
1<=N<=10^4
Sample Input :
1 2 3 4 5 6 -1
2
Sample Output :
5 1 2 3 4 6
*/
public class ChangeStartNode {
    
	public static ListNode<Integer> ChangeHead(ListNode<Integer> head, int n){
        
		   if( n == 0 || n == length(head) ) {
			  
			    return head;
		   }
		   
		   if(head == null) {
			   
			   return null;
		   }
	       ListNode<Integer> curr = head;
	      	       
	       int len = length(head);
	       
           if ( n > len) {
           
     	      n = n % len;
           }
        
	       int i = 1, count = len - n; 
	       
	       while( i < count) {
	    	   
	    	   curr = curr.next;
	    	   i++;
	       }
	      
	       ListNode<Integer> newNode = curr.next;
	       
	       curr.next = curr.next.next;
	       
	       while(curr != null) {
	    	
	    	   curr = curr.next;
	    			   
	       }
	      
	       newNode.next = head;
	       
	       
	      
	       return newNode;
		
    }
	public static int length(ListNode<Integer> head) {
			
			int len = 0;
			
			while(head != null) {
			
				head = head.next;
				
				len += 1;
			
			}
			
			return len;
			
	 }
	 public static void print(ListNode<Integer> head) {
	    	
	    	while (head != null) {
	    		
	    		System.out.print(head.data + " ");
	    		
	    		head = head.next;
	    	}
	    }
		 public static void main(String[] args) {
	        
			 Scanner s = new Scanner(System.in);
			
			int data = s.nextInt();
			
		    ListNode<Integer> head = null, tail = null;
			
			while( data != -1 ) {
			 
			   ListNode < Integer > newNode = new ListNode <> ( data  );
			
			   if(head == null) {
				
				   head = newNode;
				   
				   tail = newNode;
			   
			   } else {
				
				   tail.next = newNode;
				   
				   tail = newNode;
			   
			   }
			   
			   data = s.nextInt();
			}
			
			 int n = s.nextInt();
			 
			 head = ChangeHead(head, n);
			
			 print(head);
			 
			s.close();

		}

}
