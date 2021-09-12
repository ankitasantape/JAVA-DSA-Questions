package Arrays_1D;

public class LargestNumberFormedFromAnArray {
    public static int[] largestNumFormedFromAnArray(int a[]) 
    {
       
       for(int i = 0; i < a.length-1; i++)
       {
    	   for(int j = i + 1; j < a.length; j++)
    	   {
    		   if((a[i]+a[j]) < (a[j]+a[i]))
    		   {
    			   System.out.println(a[i]+a[j]);
    			   System.out.println(a[j]+a[i]);
    			   int temp = a[i];
    			       a[i] = a[j];
    			       a[j] = temp;
    		   }
    		   
    	   }
       }
       return a;
    } 
	public static void main(String[] args) {
       int []a = {3,30,34,9};
       int[] ans = largestNumFormedFromAnArray(a);
       for(int i = 0; i < ans.length; i++)
       {
    	   System.out.print(ans[i]+ " ");
       }
	}

}
