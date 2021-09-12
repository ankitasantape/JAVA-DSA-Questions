package Recursion;

public class PrintN_Numbers {
    public static void print(int n) {
//    	if(n >= 1 ){
//			print(n-1);
//			System.out.print(n+" ");
//		  
//		}
//    	//System.out.println();
//    	//System.out.print(n+" ");
    	
    	if(n == 1)
    	{
    		System.out.print(n + " ");
    		return;
    	}
    	print(n-1);
    	System.out.print(n + " ");
    	
    	
    }
	public static void main(String[] args) {
        int n  =  4;
        print(n);   
	}

}
