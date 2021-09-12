package Function;

import java.util.Scanner;

public class PrintFahrenheitTable {
    public static void printFahrenheitTable(int start, int end, int step )
    {
    	for(int i = start; i <= end; i += step)
    	{
    		System.out.println(i+" "+(int)(5*(i - 32))/9);
    	}
    }
	public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int start = s.nextInt();
      int end   = s.nextInt();
      int step  = s.nextInt();
      printFahrenheitTable(start, end, step);
      s.close();
//MCQ Questions     
//	public static void func(int a, int b){
//	    System.out.println(a + b);
//	    }
//
//	    public static void main(String[] args) {
//	    int a = 7;
//	    func(a, 12);
////	    }
//	public static void demo(int a, int b){
//	    System.out.println(a + " " + b);
//	}
//
//	public static void main(String[] args) {
//	    int a = 5;
//	    int b = 15; 
//	    demo(a);
	}
      
   

}
