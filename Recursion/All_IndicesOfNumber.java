package Recursion;

public class All_IndicesOfNumber {
	public static int[] allIndexes(int input[], int x) {
		
		return allIndexes(input, 0 , x);
	}
    private static int[] allIndexes(int input[],int start, int x) {
		
    	if(start == input.length)
		{
			int emptyAry[] = new int[0];
			return emptyAry;
		}
		int[] ans = allIndexes( input, start + 1, x);
		//System.out.println(ans[0] + " "+ ans[1] + " "+ans[2]);
	    //System.out.println(start);
		if(input[start] == x)
		{
			int[] a = new int[ans.length + 1];
			//System.out.println(ans.length);
			a[0] = start;
			//System.out.println( start);
			for(int i = 0; i < ans.length; i++)
			{
				a[i + 1] = ans[i];
				//System.out.println((i + 1) + " "+ans.length);
				//System.out.println(a[i+1] + " "+ ans[i]);
			}
			return a;
		
		} else {
			 
			return ans;
		}
		
	}
	
	public static void main(String[] args) {
		int n = 5;
		int a[] = {9, 7, 10, 1, 6 };
		int x = 8;
		int ans[] = allIndexes(a, x);
		for(int i = 0; i < ans.length; i++)
		{
			System.out.print(ans[i] + " ");
		}
	}

}
