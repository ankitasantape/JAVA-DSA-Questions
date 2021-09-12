package String;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class cAPSLOCK {
    public static String cAPSlOCK(String str)
    {   
    	String ans  = "";
    	if(str.charAt(0) >= 97 && str.charAt(0) <= 122)
		{
			int s = (int)(str.charAt(0)) - 32 ; 
			ans += (char) s;
		} else {
			ans += str.charAt(0);
		}
    	for(int i = 1; i < str.length(); i++)
    	{
    		
    		if(str.charAt(i) >= 65 && str.charAt(i) <= 90)
    		{
    			int s = (int)(str.charAt(i)) + 32 ; 
    			ans += (char) s;
    		} else {
    			ans += str.charAt(i);
    		}
    	}
    	return ans;
    	
    }
    public static String setWord(String word)
    {

    	word = word.toLowerCase();
    	word = word.substring(0,1).toUpperCase()+word.substring(1);
    	return word;
    	
    	
    }
	public static void main(String[] args)  {
        //String str = "cAPS";
       // String str = "Lock";
       // String ans = cAPSlOCK(str);
	  //	System.out.println(ans);
		
		//		 Scanner sc = new Scanner(System.in);
//	        String str = sc.nextLine() ;
//		BufferedReader userInput = new BufferedReader (new InputStreamReader (System.in));
//	    String word = userInput.readLine();
//        String ans = setWord(word);
//        System.out.println(ans);
		
		
		//This code is executed by codeforces compiler
        Scanner ip = new Scanner(System.in);
        String x = ip.next();
        StringBuilder buf = new StringBuilder(x);
        System.out.println(buf.toString());
        if(x.equals(buf.toString().toUpperCase()))
            System.out.println(buf.toString().toLowerCase());
        else if(buf.substring(0,1).equals(buf.substring(0,1).toLowerCase()))
        {
            if(buf.substring(1).equals(buf.substring(1).toUpperCase()))
                System.out.println(buf.substring(0, 1).toUpperCase()+buf.substring(1).toLowerCase());
            else
                System.out.println(x);
        }
        else
            System.out.println(x);
        ip.close();
		
		
		
		
	}

}
