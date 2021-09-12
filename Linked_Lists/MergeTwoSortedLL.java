
package Linked_Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*Code : Merge two sorted LL
Send Feedback
You have been given two sorted(in ascending order) singly linked lists of integers.
Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.
Note :
Try solving this in O(1) auxiliary space.

No need to print the list, it has already been taken care.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains the elements of the first sorted singly linked list separated by a single space. 

The second line of the input contains the elements of the second sorted singly linked list separated by a single space. 
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element
Output :
For each test case/query, print the resulting sorted singly linked list, separated by a single space.

Output for every test case will be printed in a seperate line.
Constraints :
1 <= t = 10^2
0 <= N <= 10 ^ 4
0 <= M <= 10 ^ 4
Where N and M denote the sizes of the singly linked lists. 

Time Limit: 1sec
Sample Input 1 :
1
2 5 8 12 -1
3 6 9 -1
Sample Output 1 :
2 3 5 6 8 9 12 
Sample Input 2 :
2
2 5 8 12 -1
3 6 9 -1
10 40 60 60 80 -1
10 20 30 40 50 60 90 100 -1
Sample Output 2 :
2 3 5 6 8 9 12 
10 10 20 30 40 40 50 60 60 60 80 90 100*/


public class MergeTwoSortedLL {
   
	public static LinkedListNode<Integer> merge2SortedListAscending(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
    	
    	LinkedListNode<Integer> head3 , temp3, temp1 = head1, temp2 = head2;
    	 
    	if(head1 == null){
             return head2;
             
         }
         if(head2 == null) {
             return head1;
             
         }
    	if(temp1.data < temp2.data) {
    		head3 = temp1;
    		temp3 = temp1;
    		temp1 = temp1.next;
    		
    	} else {
    		head3 = temp2;
    		temp3 = temp2;
    		temp2 = temp2.next;
    		
    	}
    	
    	while ( temp1 != null && temp2 != null ) {
    		if ( temp1.data <= temp2.data ) {
    			temp3.next = temp1;
    			temp3 = temp1;
    			temp1 = temp1.next;
    			
    		} else if ( temp1.data > temp2.data ) {
    			temp3.next = temp2;
    			temp3 = temp2;
    			temp2 = temp2.next;
    			
    		}  
    	}
    	if( temp1 != null )
		{
			temp3.next = temp1; 
		}
		if( temp2 != null ) { 
		    temp3.next = temp2;
		}
		
		return head3;
    }
	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
    	
		   if(head == null || head.next == null) {
			
			   return head;
		   
		   }
   
		   LinkedListNode<Integer> newNode =  reverseLinkedListRec(head.next);
		  
		   head.next.next = head;
		  
		   head.next = null;
		   
		   return newNode;
		   
	}
	public static LinkedListNode<Integer> merge2SortedListDscending(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
    	
		LinkedListNode<Integer> head3 , temp3, temp1 = head1, temp2 = head2;
   	 
    	if(head1 == null){
             return head2;
             
         }
         if(head2 == null) {
             return head1;
             
         }
    	if(temp1.data < temp2.data) {
    		head3 = temp1;
    		temp3 = temp1;
    		temp1 = temp1.next;
    		
    	} else {
    		head3 = temp2;
    		temp3 = temp2;
    		temp2 = temp2.next;
    		
    	}
    	
    	while ( temp1 != null && temp2 != null ) {
    		if ( temp1.data <= temp2.data ) {
    			temp3.next = temp1;
    			temp3 = temp1;
    			temp1 = temp1.next;
    			
    		} else if ( temp1.data > temp2.data ) {
    			temp3.next = temp2;
    			temp3 = temp2;
    			temp2 = temp2.next;
    			
    		}  
    	}
    	if( temp1 != null )
		{
			temp3.next = temp1; 
		}
		if( temp2 != null ) { 
		    temp3.next = temp2;
		}
		
		return reverseLinkedListRec(head3);
		
	}
	public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
    	
		LinkedListNode<Integer> h3 = new LinkedListNode<Integer>(0);
    	
		LinkedListNode<Integer> t3 = h3;
    	
    	
    	while( true ) {
    		if(head1 == null) {
    			t3.next = head2;
    			break;
    		}
    		if(head2 == null) {
    			t3.next = head1;
    			break;
    		}
    		if( head1.data <= head2.data) {
    			t3.next = head1;
    			head1 = head1.next;
    			
    		} else {
    			
    			t3.next = head2;
    			head2 = head2.next;
    		}
    		t3 = t3.next;
    	}
    	
    	return h3.next;
    }
    
	public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        
    	LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
	
   public static void main(String[] args) throws NumberFormatException, IOException {
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            LinkedListNode<Integer> head1 = takeInput(); 
            LinkedListNode<Integer> head2 = takeInput(); 

            //LinkedListNode<Integer> newHead = mergeTwoSortedLinkedLists(head1, head2);
            //LinkedListNode<Integer> newHead = merge2SortedListAscending(head1, head2);
            LinkedListNode<Integer> new2Head = merge2SortedListDscending(head1, head2);
           // print(newHead);
            print(new2Head);
            
            t -= 1;
        }

    }

}
