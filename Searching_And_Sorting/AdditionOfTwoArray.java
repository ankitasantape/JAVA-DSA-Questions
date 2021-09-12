
package Searching_And_Sorting;

public class AdditionOfTwoArray {
	public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
    	int n = arr1.length;
        int m = arr2.length;
        int k = output.length- 1;
        int cy = 0;
        int i = n-1, j = m-1;
        while(k >= 0 )
        {
        	int d = cy;
        	if(i >= 0)
        	{
        		d += arr1[i];
        	}
        	if(j >= 0)
        	{
        		d += arr2[j];
        	}
        	cy = d / 10;
        	d = d % 10;
        	output[k] = d;
        	i--;
        	j--;
        	k--;
        }

        k = output.length;
        for(int l = 0; l < k; l++) 
        {
            System.out.print(output[l] + " ");
        }
       
        
        
        
        
    }
	public static void main(String[] args) {
		int arr1[] = {6,2,4};
		int arr2[] = {7,5,6};
		int []output = new int[arr1.length > arr2.length ? (arr1.length + 1) : (arr2.length + 1) ];
		sumOfTwoArrays(arr1, arr2,output);
	}

}
