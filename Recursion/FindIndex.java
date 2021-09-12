package Recursion;

public class FindIndex {
    public static int findIndex(int input[], int x) {
    	return findIndex(input, 0, x);
    }
    private static int findIndex(int input[], int start, int x)
    {
    	if(start >= input.length )
    	{
    		return -1;
    	}
    	if(input[start] == x)
    	{
    		return start;
    	}
    	
    	int ans = findIndex(input, start + 1, x);
    	return ans;
    }
    		
	public static void main(String[] args) {
       
        int a[] = {8,10,8,5,4,7,6};
        int x = 1;
        int ans = findIndex(a, x);
        System.out.println(ans);
	}

}
