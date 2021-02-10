package LongestCommonSubsequence;

public class PrintLCS {

	public static void main(String[] args) {
		// Output - abcf
				String str1 = "acbcf";  
				String str2 = "abcdaf";

				System.out.println("DP : " + lcsDP(str1, str2));
 }
 private static String lcsDP(String s, String t) {
		int m = s.length();
		int n = t.length();
		int storage[][] = new int[m + 1][n + 1];
		String ans = "";
		// for first row
		for (int i = 0; i <= m; i++) {
			storage[i][0] = 0;
		}

		// for first column
		for (int i = 0; i <= n; i++) {
			storage[0][i] = 0;
		}

		for (int i = 1; i <= m; i++) {
			   for (int j = 1; j <= n; j++) {
				      if (s.charAt( i - 1) == t.charAt( j - 1 )) {
                  storage[i][j] = 1 + storage[i - 1][j - 1];
              } else {
                  storage[i][j] = Math.max(storage[i][j - 1], storage[i - 1][j]);
              }
			   }
		}
		int index = storage[m][n];
		int temp = index;
		char[] lcs = new char[index+1];
		lcs[index] = '\u0000';
		for( int i = m; i > 0 ;  ) {
			   for( int j = n; j > 0;  ) {
				      if( s.charAt(i-1) == t.charAt(j-1) )
				      {
					        lcs[index-1] = s.charAt(i-1);
					        i--;
					        j--;
					        index--;
				      }
				      else if( storage[i-1][j] > storage[i][j-1] ) {
					        i--;
				      }else {
					        j--;
				      }
			   }
		}
		for( int k = 0; k <= temp; k++ ) {
			ans += lcs[k];
		}
		return ans;
	}

}
