package Recursion_2;

public class QuickSort {
	public static void quickSort(int[] input) {
		
		quickSort(input, 0, input.length - 1);
		
	}
	private static void quickSort(int []input, int si, int ei) {
		if(si >= ei) { return ; }
		
		int pivotPos = partition(input, si, ei);
		               quickSort(input, si, pivotPos - 1);
		               quickSort(input, pivotPos + 1, ei);
	}
	private static int partition(int[] input, int si, int ei) {
        int pivot = input[si];
        int i = si ;
        
		for(int j = si + 1 ; j <= ei; j++) {
			if(input[j] < pivot) {
				i++;
				
				int temp = input[j];
				 input[j] = input[i];
				 input[j] = temp;
			}
		}
		int temp = input[i ];
		input[i ] = input[si ];
		input[si] = temp;
		
		return i + 1;
	}
	public static void main(String[] args) {
           int a[] = {10,18,19,9,2,6,11};
           quickSort(a);
           for(int i = 0; i < a.length; i++) {
   			System.out.print(a[i] + " ");
   		}
	}

}
