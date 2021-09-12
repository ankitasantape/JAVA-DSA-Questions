package String;

public class SpecialStringAgain {
	static long substrCount(int n, String s) 
	{
		long ans = n;
		for(int i = 0; i < s.length() - 2; i++)
        {
           if(s.charAt(i) == s.charAt(i+1))
           {
        	   ans += 1;
           }
           if(s.charAt(i) == s.charAt(i + 2))
           {
        	   ans += 1;
           }
          
        }
		
		for(int i = 0; i < n-1; i++ ) {

      	         if(s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(--n))
      	         {
      		         ans += 1;
      	         }
           
		}
      return ans;
    }
	public static void main(String[] args) {
		String s = "abcbaba";
		//String s = "aadaa";
		int n = s.length();
		long ans = substrCount(n,s);
		System.out.println(ans);

	}

}
