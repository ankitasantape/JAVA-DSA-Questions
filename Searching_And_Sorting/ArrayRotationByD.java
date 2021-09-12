package Searching_And_Sorting;

public class ArrayRotationByD 
{
    public static void rotate(int []arr, int d)
    {
    	int n = arr.length; //6
    	for(int i = n-1; i >= n / 2; i--)
    	{
    		int temp = arr[n - i - 1];
    		arr[n - i - 1] = arr[i]; 
    		arr[i] = temp;
    	}
    	
    	for(int i = 0; i < n; i++) 
    	{
    	    System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    	int k = n - d - 1;// 3
    	for(int i = k; i > k/2; i--)
    	{
    		int temp = arr[k - i];
    		  arr[k - i ] = arr[i];
    		  arr[i] = temp;
    	}
    	for(int i = 0; i < n; i++) 
    	{
        	System.out.print(arr[i]+" ");
        }
    	System.out.println();
    	int r = n - d;// r = 3
    
    	for(int j = n-1; j >= n/2; j--)
    	{
    		int temp = arr[n-j+2]; //7 - 6 + 2 = 3 // 2 
    		arr[n-j+2]  = arr[j-r] ;//arr[3] = arr[3] , arr[2] = [-1]
    		   arr[j-r] = temp;
    	}
    	for(int i = 0; i < n; i++) 
    	{
        	System.out.print(arr[i]+" ");
        }

    }
	public static void main(String[] args) 
	{
        int arr[] = {1,2,3,4,5,6,7};
        rotate(arr, 4);
        System.out.println();
	}

}
