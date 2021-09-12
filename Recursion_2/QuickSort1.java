package Recursion_2;

public class QuickSort1 {
    public static void quickSort(int[] input, int si, int ei) {
    	if(si >= ei) {
    		return;
    	}
    	int pivotPos = partition(input, si, ei);
    	               quickSort(input, si, pivotPos - 1);
    	               quickSort(input, pivotPos + 1, ei);
    }
	private static int partition(int[] input, int si, int ei) {
		int pivot = input[ei];
		int i = si - 1;
		for (int j = si; j < ei; j++) {
			if (input[j] < pivot) {
				i++;

				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
			}
		}

		int temp = input[i + 1];
		input[i + 1] = input[ei];
		input[ei] = temp;

		return i + 1;
	}
	public static void main(String[] args) {
           int a[] = {6, 2, 20, 8, 15, 3, 4};
           quickSort(a, 0, a.length - 1);
           for(int i = 0; i < a.length; i++) {
        	   System.out.print(a[i] + " ");
           }
	}

}
