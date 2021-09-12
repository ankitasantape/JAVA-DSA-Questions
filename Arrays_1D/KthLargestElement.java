package Arrays_1D;

public class KthLargestElement {
    public static void kthLargestElement(int []a, int k)
    {
    	for(int i = 0; i < a.length - 1; i++)
    	{
    		for(int j = i+1; j < a.length; j++)
    		{
    			if(a[i] < a[j])
    			{
    				int temp = a[i];
    				    a[i] = a[j];
    				    a[j] = temp;
    			}
    			
    		}
    		System.out.print(a[i]+" ");
    		if( i == k-1)
			{
				System.out.println("Largest element at index "+k+" is "+a[i]);
				break;
			}
    	}
    	
    }
	public static void main(String[] args) {
       int a[] = {5,8,12,7,6,2,4};
       int k = 4;
       kthLargestElement(a,k);
       
	}

}
