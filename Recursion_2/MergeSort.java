package Recursion_2;

public class MergeSort {
	public static void mergeSort(int[] input){
		
		mergeSort(input, 0, input.length - 1);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	private static void mergeSort(int []input, int si, int ei) {
//		System.out.println(si + " " + ei);
		if(si >= ei) {
			return;
		} else {
		int mid = (si + ei)/2;
		mergeSort(input, si, mid);
		mergeSort(input, mid + 1, ei);
		merge(input, si, ei);
		}
	}
	
	private static void merge(int[] input,int si, int ei) {
		//System.out.print(input.length + " ");
		int mid = (si + ei) / 2;
		//System.out.print(si+" "+ei);
		//System.out.print(mid + " ");
		int n1 = mid - si + 1;
		//System.out.print(n1 + " " );
		int n2 = ei - mid;
		//System.out.println(n2 + " ");
		int left[] = new int[n1];
		int right[] = new int[n2];
		
		for(int i = 0; i < n1; ++i) {
			
			left[i] = input[si + i];
		}
		
		for(int j = 0; j < n2; ++j) {
			
			right[j] = input[mid + 1 + j];
		}
		
		int i = 0, j = 0, k = si;
		
		while(i < n1 && j < n2) {
			if(left[i] <= right[j] ) {
				
				input[k] = left[i];
				i++;
			} else {
				input[k] = right[j];
				j++;
				
			}
			k++;
		}
		
		while( i < n1) {
			input[k] = left[i];
			i++;
			k++;
		}
		
		while( j < n2) {
			input[k] = right[j];
			j++;
			k++;
		}
		
	}
	public static void main(String[] args) {
         //  int a[] = {2, 1, 5, 2, 3};
		 for(int n = 10; n <= 10000000; n *= 10 ) {
	        	int []arr = new int[n];
	        	for(int i = 0; i < arr.length; i++) {
	        		arr[i] = arr.length - i;
	        	}
	        	
	        	long startTime = System.currentTimeMillis();
	        	mergeSort(arr);
	            long endTime = System.currentTimeMillis();
	            System.out.println("Time by selection sort for " + n + " is "+ (endTime  - startTime));
	      }
           
	}

}
