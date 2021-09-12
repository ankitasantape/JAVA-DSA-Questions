package String;

public class MakingAnagrams {
	 static int makeAnagram(String a, String b) 
	 {
		 int noOfChars = 26;
		 int frq_a[] = new int[noOfChars];
		 int frq_b[] = new int[noOfChars];
		 int n = a.length(), m = b.length();
		 int count = 0;	
			for(int i = 0; i < n; i++)
			{
				int ch = (int) a.charAt(i);
				int position = ch - 97;
				frq_a[position]++;
			}
			for(int i = 0; i < m ; i++)
			{
                int ch = (int) b.charAt(i);
				int position = ch - 97;
				frq_b[position]++;
				
			}
			for(int i = 0; i < 26; i++)
			{
				int diff = Math.abs(frq_a[i] - frq_b[i]);
				count += diff;
			}
		    return count;
	 }
	public static void main(String[] args) 
	{
		String a = "cde";
		String b = "abc";
		int count = makeAnagram(a, b);
		System.out.println(count);

	}

}
