package Arrays_1D;

public class MergeSortCountingSwap {
	static long countInversions(int[] arr) {
		long count = 0;
        for(int i = 0; i < arr.length-1; i++)
        {
        	for(int j = i+1; j < arr.length; j++)
        	{
        		if(arr[i] > arr[j])
        		{
        			count++;
        			//System.out.println(count);
        			//System.out.println(arr[i]);
        			//System.out.println(arr[j]);
        			
        		}
        	}
        }
		 return count;
    }
	
	public static void swap(int []arr,int  i,int j)
	{
		int temp = arr[i];
		   arr[i]= arr[j];
		   arr[j] = temp;
	}
	public static void main(String[] args) {
         int []a = {2, 1, 3, 1, 2};
        // int []a = {1, 1, 1, 2, 2};

         long count = countInversions(a);
         System.out.println(count);
	}

}
