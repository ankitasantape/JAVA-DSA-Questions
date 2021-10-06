package mcqs;

public class PassByValue {
//	public static void doubleValue(int a ){
//	    a = a * 2;
//	}
//	public static void main(String[] args) {
//	    int a = 8;
//	    doubleValue(a);
//	    System.out.println(a);
//	}
	
//	public static int func(int a){
//	    a += 10;
//	    return a;
//	}
//
//	public static void main(String[] args) {
//	    int a = 5;
//	    func(a);
//	   
//	    System.out.println(a); }
	
	public static int square(int a){
	    int ans = a * a;
	    return ans;
	}

	public static void main(String[] args) {
	    int a = 4;
	    a = square(a);
	    System.out.println(a);
	}
	
}
