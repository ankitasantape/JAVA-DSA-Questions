package String;

import java.util.HashMap;

public class ValidStringByOccurenceOfChar {
	static String isValid(String s) 
	{
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
        	char c = s.charAt(i);
        	if(hm.containsKey(c))
        	{
        		hm.put(c, hm.get(c)+ 1);
        	}else {
        		hm.put(c, 1);
        	}
       }
      int count = 0;
      String ans = "YES";
       for(int i =0; i < s.length()-1; i++)
       {
    	   
    	   char c1 = s.charAt(i);
    	   char c2 = s.charAt(i+1);
    	   
//    	   if(hm.get(c1) != hm.get(c2) )
//    	   {
//    		  
//    	   } 
    	   if(count <= 2 && Math.abs(hm.get(c1) - hm.get(c2)) > 1 )
    	   {
    		   count++;
    		   ans = "NO";
    	   }
    	  // if(count <= 2 && Math.abs(hm.get(c1) - hm.get(c2)) > 1)
    	   else if(Math.abs(hm.get(c1) - hm.get(c2)) == 0)
    	   {
    		  return "YES"; 
    	   }
       }
       return ans;
    }
	public static void main(String[] args) 
	{
        String str = "aabbccddeefghi";
        String ans = isValid(str);
        System.out.println(ans);
	}

}
