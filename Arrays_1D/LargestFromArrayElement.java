package Arrays_1D;

import java.util.Scanner;

public class LargestFromArrayElement {
    public static int[] takeInput()
    { 
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
    	int[] a = new int[n];
    	for(int i = 0; i < n; i++)
    	{
    		a[i] = s.nextInt();
    	}
    	s.close();
    	return a;
    	
    }
    public static int largest(int[] a)
    {
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < a.length; i++)
    	{
    		if(a[i] > max)
    		{
    			max = a[i];
    		}
    	}
    	return max;
    }
    public static int smallest(int[] a)
    {
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < a.length; i++)
    	{
    		if(a[i] < min)
    		{
    			min = a[i];
    		}
    	}
    	return min;
    }
   
    public static void print(int[] a)
    {
    	int size = a.length;
    	for(int i = 0; i < size; i++)
    	{
    		System.out.print(a[i] + " ");
    	}
    	System.out.println();
    }
	public static void main(String[] args) {
     
		int []a = takeInput();
		print(a);
		int largest = largest(a);
		System.out.println("Largest "+largest);
		int smallest = smallest(a);
		System.out.println("Smallest "+smallest);
		
	}

}
