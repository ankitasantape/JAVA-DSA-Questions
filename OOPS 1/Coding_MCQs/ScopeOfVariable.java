package mcqs;

public class ScopeOfVariable {

	public static void main(String[] args) {
//	1)	   int a = 10;
//		        if(a > 5) {
//		            int b = 10;
//		        }
//		        System.out.println(b);
//		    }
//  2)
//		 int a = 10;
//	        if(a > 5) {
//	            a = 100;
//	        }
//	        System.out.println(a);
//  3)
//		 int a = 10;
//	        if(a > 5) {
//	            int a = 100;
//	        }
//	        System.out.println(a);
//	4)
//		 for(int i = 0; i < 3; i++) {
//		        System.out.print(i + " ");
//		        }
//		    System.out.print(i + " ");
//	5)
		 int a = 10;
		    while(a > 5) {
		        int b = 1;
		        System.out.print(b + " ");
		        a--;
		    }
	}
}
