package String;

public class AlternatingCharacters {
	static int alternatingCharacters(String s) {
		
		s = s + " ";
		int count = 0;
		char []c = s.toCharArray();
	    for(int i = 0; i < s.length() - 1 ;i++ )
	    {   
	    	if(c[i] == c[i+1])
	    	{
	    		count++;
	    	}
	    	

	    }
        return count;

    }
	public static void main(String[] args) {
		String str = "BABAB";
		int c = alternatingCharacters(str);
		System.out.println(c);

	}

}
