package Method_Overloading;

public class Sum {
     public void getSum()
     {
    	 System.out.println(4+5);
     }
     public void getSum(int a, int b)
     {
    	 System.out.println(a+b);
     }
     public void getSum(int a, int b, int c)
     {
    	 System.out.println(a + b + c);
     }
     public static void main(String[] args)
     {
    	 Sum obj = new Sum();
    	 obj.getSum();
    	 obj.getSum(12, -56);
         obj.getSum(18, 67, -89);
     }
}
