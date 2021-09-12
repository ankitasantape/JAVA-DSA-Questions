package Arrays_1D;

public class CountMinimumOperationToCheckPalindrome {
    public static int findMinOps(int a[])
    {
    	int ans = 0;
    	for(int i = 0, j = a.length - 1; i <= j;)
    	{
    		if(a[i] == a[j])
    		{
    			i++;
    			j--;
    		} 
    		else if (a[i] < a[j])
    		{
    			i++;
    			a[i] += a[i-1];
    			ans++;
    		} 
    		else 
    		{
    			j--;
    			a[j] -= a[j+1];
    			ans++;
    		}
    	}
    	for(int i = 0; i < a.length; i++)
    	{
    		System.out.print(a[i]+" ");
    	}
    	return ans;
    }
	public static void main(String[] args) {
		// int a[] = {1, 4, 5, 9, 1};
		int a[] = {11, 14, 15, 99};
		//int a[] = {15, 4, 15};
		System.out.println( "Count minimun number of Operations to make array palindome "+findMinOps(a));
	}

}
