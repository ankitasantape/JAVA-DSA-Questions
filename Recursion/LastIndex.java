package Recursion;

public class LastIndex {
    public static int lastIndex(int input[], int x) {
    	return lastIndex(input, input.length - 1,  x);
    }
    private static int lastIndex(int input[],int lastIndex, int x) {
    	if(lastIndex < 0)
    	{
    		return -1;
    	}
    	if(input[lastIndex] == x)
    	{
    		return lastIndex;
    	}
    	int ans = lastIndex(input, lastIndex - 1, x);
    	return ans;
    }
	public static void main(String[] args) {
           int a[] = { 9, 8, 9, 10};
           int x = 9;
           int ans = lastIndex(a, x);
           System.out.println(ans);
	}

}
