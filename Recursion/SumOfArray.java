package Recursion;

import java.util.Arrays;

public class SumOfArray {
    public static int sum(int input[])
    {
    	if(input.length == 1)
    	{
    		return input[0];
    	}
    	
    	return input[0] + sum(Arrays.copyOfRange(input, 1, input.length));
    }
    
    public static int sum2(int input[], int n)
    {
    	if(n == 1)
    	{
    		return input[0];
    	}
    	
    	return input[n - 1] + sum2(input, n - 1);
    }
    public static int sum3(int input[])
    {
    	if(input.length <= 0)
    	{
    		return input[0];
    	}
    	int smallAry[] = new int[input.length - 1];
    	int sum = 0;
    	for(int i = 1; i < input.length; i++) {
    		smallAry[i - 1] = input[i]; 
            sum += input[i];
    		
    	}
        int smallAns = sum3(smallAry);
    	
    	return smallAns;
    }
	public static void main(String[] args) {
        int a[] = {9, 8, 9};
        int ans = sum(a);
        int ans2 = sum2(a, a.length);
        System.out.println(ans);
        System.out.println(ans2);
	}

}
