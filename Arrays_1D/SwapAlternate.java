package Arrays_1D;

import java.util.Scanner;

public class SwapAlternate {
	public static void swapAlternate(int arr[]) {
//    	if(arr.length % 2 == 0) // for even
//    	{
    		for(int i = 0; i < arr.length - 1; i += 2)
    		{
    			swap(arr, i, i + 1); 
    		}
    		
    //	}
    	
    }
	public static void take(int a[], int n)
	{
		Scanner s = new Scanner(System.in);
		for(int i = 0; i < n; i++)
		{
			a[i] = s.nextInt();
		}
		s.close();
	}
	public static void print(int [] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void swap(int arr[],int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
    
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int n;
        while(t != 0)
        {
        	n = s.nextInt();
        	int a[] = new int[n];
        	take(a,n);
        	swapAlternate(a);
        	print(a);
        	t--;
        }
        s.close();
	}

}
