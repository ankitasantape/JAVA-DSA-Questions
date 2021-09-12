package Recursion;

public class Func {
    public static void func(int num)
    {
    	System.out.println(num);
//    	if(num < 0)
//    	{
//    		return;
//    	}
    	//System.out.print(num+ " ");
    	//func(num - 2);
    	//return func(num -1);
    	
    	if(num < 0)
    	{
    		return ;
    	}
    	if(num == 0)
    	{
    		System.out.println(num);
    		return;
    	}
    	func(num--);
    	System.out.print(num+" ");
  /*In function func when recursion call is being made, n-- is being passed as input. 
   * Here we are using post decrement operator, so argument passed to next function call is n and not n - 1. 
   * Thus there will be infinite recursion calls and StackOverflow exception.*/
    }
	public static void main(String[] args) {
//         int num = 5;
//         int ans = func(num - 1);
//         System.out.println(ans);
         //Since the base case is missing in the code, 
         //therefore there will be infinite recursion calls and hence StackOverflowError.
		
		int n = 5;
		func(n);
	}

}
