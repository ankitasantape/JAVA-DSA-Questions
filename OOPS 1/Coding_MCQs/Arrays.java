package mcqs;
public class Arrays {

	//public static void main(String[] args) {
//		int arr[] = new int[5];
//		System.out.println(arr[0]);
//		
//		char chArray[] = new char[15];
//		System.out.println(chArray[15]);
//		
//		boolean ar[] = new boolean[5];
//		System.out.println(ar[0]);
		
//		int[] arr = new int[5];
//		System.out.println(arr);
//		arr = new int[6];
//		System.out.println(arr);
		
	
		    
//		      int arr[] = new int[5];
//		      arr[1] = 10;
//		      arr = new int[2];
//		      System.out.println(arr[0]);  
		
//	    public static void change(int input[]){
//	        input[0] = 15;
//	        }
//
//	        public static void maipublic class Main {
	    public static void change(int input[]){
	    input = new int[5];
	    input[0] = 15;
	    }

	    public static void main(String args[]){
	        int arr[] = new int[5];
	        change(arr);
	        System.out.println(arr[0]);
	/*####“arr” is a reference to the array, which contains address of the array. 
	 * Hence we have passed this address to function “change”.
	 * So input and arr will refer to same array initially, 
	 * but in the first statement in function “change” input if made to refer to new integer array.
	 *  So input[0] = 15,will change the first element of this 
	 *  newly formed array and the array created in main will remain unchanged.
	 */
	    }
	}

		    
		
	//}

//}
