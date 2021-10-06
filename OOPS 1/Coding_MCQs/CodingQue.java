package mcqs;

public class CodingQue {

	public static void main(String[] args) {
//		int a = 56, b = 876;
//		int t = 0;
//		while(b != 0)
//		{
//		   t += a;
//		   b--;
//		}
//		System.out.println(t);
        
        
        
//		char ch = 'b';
//		int i = 1;
//		while(ch >= 'a' && ch <= 'z')
//		{   
//			System.out.print(ch + " "+i+" ");
//			ch++;
//			i++;
//			
//        }
		
//		int number = 2630;
//		int even_counter = 0, num_rem = number;
//		while(num_rem != 0)
//		{
//			int digit = num_rem % 10;
//			if(digit != 0 && number % digit == 0)
//			{
//				even_counter++;
//			}
//			num_rem /= 10;
//		}
//		System.out.println(even_counter);
		
//		int n = 20, f = 1, i = 1, s = 0;
//		do {
//			f = f * i;
//			s = s + (i / f);
//			i++;
//		}while(i <= n);
//		System.out.println(s);
		
		int n = 127, i = 0, s = 0;
		while(n != 0)
		{
		   int r = n % 10;
		   System.out.print("r= "+r +" ");
		   int p = 8 ^ i;
		   System.out.print("p= "+p +" ");
		   s += r * p;
		   System.out.print("s= "+s +" ");
		   n /= 10;
		   i++;
			
		}
		System.out.println(s);
	}

}
