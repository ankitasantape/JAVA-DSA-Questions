package Arrays_1D;

public class SegregateEvenOdd {
	 public static void segregateEvenOdd(int []a)
	    {
	        int j = a.length-1;
	        int i = 0;
	        while(i < j)
	        {
	            if(a[i] % 2 == 0)
	            {
	                i++;
	            } else if(a[i] % 2 != 0)
	            {
	                if(a[j] % 2 == 0)
	                {
	                    int temp = a[i];
	                        a[i] = a[j];
	                        a[j] = temp;
	                        j--;
	                        i++;
	                }else {
	                    j--;
	                }
	                
	            }
	        }
	    }
	 public static void segregateEvenOdd2(int []a)
	    {
	       int i = -1;
	       int j = 0;
	       while(j != a.length)
	       {
	    	   if(a[j] % 2 == 0)
	    	   {
	    		   i++; // 0
	    		   int temp = a[i];
	    		       a[i] = a[j];
	    		       a[j] = temp;
	    	   }
	    	   j++;
	       }
	    }
	public static void main(String[] args) {
		//int a[] = {2,3,6,5,1,7,8};
		int a[] = { 1, 3, 2, 4, 7, 6, 9, 10 }; 
		segregateEvenOdd2(a);
		for(int i = 0; i < a.length; i++)
		{
		    System.out.print(a[i]+" ");
		}
	}

}
