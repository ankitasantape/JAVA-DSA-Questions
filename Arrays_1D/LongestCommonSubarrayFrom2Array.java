package Arrays_1D;

public class LongestCommonSubarrayFrom2Array {
    public static int longestCommonSubarrayLength(int a1[], int a2[])
    {
    	int length = 0;
    	for( int i = 0; i < a1.length; i++)
    	{
    	    for(int j = 0; j < a2.length; j++)
    	    {
    	    	
    	    }

    	}
    	return length;
    }
	public static void main(String[] args) {
		int a1[] = {1,2,8,2,1};
		int a2[] = {8,2,1,4,7};
        int ans = longestCommonSubarrayLength(a1,a2);	
        System.out.println(ans);

	}

}
