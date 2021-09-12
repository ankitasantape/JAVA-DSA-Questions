
package Searching_And_Sorting;

public class SelectionSort {
    public static void selectionSort(int arr[])
    {
    	for(int i = 0; i < arr.length  - 1; i++)// from 0 to n - 2
    	{
    		int min = arr[i];
    		int minIndex = i;
    		for(int j = i + 1; j < arr.length; j++)
    		{
    			if(arr[j] < min)
    			{
    				min = arr[j];
    				minIndex = j;
    			}
    		}
    		if(i != minIndex)
    		{
    		    arr[minIndex] = arr[i];
    			arr[i] = min;
    			
    		}
    	}
//    	for(int i = 0; i < arr.length; i++)
//    	{
//    		System.out.print(arr[i]+" ");
//    	}
    }
    
	public static void main(String[] args) {
        // int arr[] = {12,45,78,66,97};
        for(int n = 10; n <= 10000000; n *= 10 ) {
        	int []arr = new int[n];
        	for(int i = 0; i < arr.length; i++) {
        		arr[i] = arr.length - i;
        	}
        	
        	long startTime = System.currentTimeMillis();
        	selectionSort(arr);
            long endTime = System.currentTimeMillis();
            System.out.println("Time by selection sort for " + n + " is "+ (endTime  - startTime));
        }
	}

}
