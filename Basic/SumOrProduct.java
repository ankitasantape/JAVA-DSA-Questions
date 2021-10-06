package Basic;
import java.util.Scanner;

public class SumOrProduct {

	public static void main(String[] args) {
		
			
			
				Scanner  sc = new Scanner(System.in);
		        int n=sc.nextInt();
		        int c = sc.nextInt();
		        int sum =0, pro = 1;
		        String s = "";
		       
		            switch(c)
		            {
		               case 1:
		                    for(int i = 1; i <= n ; i++)
		                    {
		                        sum += i; 
		                    }
		                    break;
		                case 2:
		                    for(int i = 1; i <= n; i++)
		                    {
		                        pro *= i;
		                    }
		                    break;
		                default:
		                    s = "-1";
		                    break;
		            }
		        
		        if (c == 1){ 
		            System.out.println(sum); 
		        }else if (c ==  2){ 
		            System.out.println(pro); 
		        }else{
		            System.out.println(s);
		        }
		     sc.close();   
	}
	
}


