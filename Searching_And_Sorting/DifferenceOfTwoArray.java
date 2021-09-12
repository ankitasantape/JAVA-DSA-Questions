package Searching_And_Sorting;

public class DifferenceOfTwoArray {
    public static void differenceOfTwoArray(int []a1, int []a2, int diff[])
    {
    	int i = a1.length - 1;
    	int j = a2.length - 1;
    	int k = diff.length - 1;
    	int cy = 0;
    	while(k >= 0)
    	{
    		int d = cy;
    		if(j >= 0)
    		{
    			d = a2[j] - d;
    		}
    		
    		if(i >= 0)
    		{
    			d = a1[i] - d;
    		}
    		
    		d = d % 10;
    		diff[k] = d;
    		i--;
    		j--;
    		k--;
    	}
    	
    }
	public static void main(String[] args) 
	{
		int a1[] = {5,4,5,6};
		int a2[] = {4,5,6,7};
        int diff[] = new int[a1.length > a2.length ? a1.length : a2.length];
        differenceOfTwoArray(a1, a2, diff);
        for(int i =0; i < diff.length; i++)
        {
        	System.out.print(diff[i]+" ");
        }
	}

}
