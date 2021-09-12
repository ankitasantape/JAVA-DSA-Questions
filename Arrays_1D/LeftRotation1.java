package Arrays_1D;

public class LeftRotation1 {
	 public static void rotate(int[] arr, int d) {
	    	int n = arr.length;
			
			int []rot = new int[d];
			// int i = 0;
	        int j = 0;
			while(j < d)
			{
				rot[j] = arr[j];
				// i++;
				j++;
			}
			int i = 0;
			while(i < n-d)
			{
				arr[i] = arr[i+d];
				// i++;
				i++;
			}
			
	        int z = arr.length-d;
			for(int k =0; k < d; k++)
			{
				    arr[z]=rot[k];
	            	z++;
			    
	        }
	        
		}
	public static void main(String[] args) {
		int []a = {1,2,3,4,5};
		int d = 3;
		rotate(a, d);
		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+" ");
		}

	}

}
