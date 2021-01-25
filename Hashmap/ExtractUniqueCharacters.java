package hashMap;


import java.util.HashMap;
import java.util.Scanner;

/*Extract Unique characters
Send Feedback
Given a string, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same.
Input format :
String S
Output format :
Output String
Constraints :
0 <= Length of S <= 10^8
Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde
*/
public class ExtractUniqueCharacters {

    public static String uniqueChar(String str){
		
    	String output = "";
		HashMap<Character, Integer> exist = new HashMap<>();
		
		for( int i = 0;i < str.length(); i++ ) {
			// if char already map me contain hai then skip kro
			if( exist.containsKey( str.charAt(i) )) {
				
				continue;
			}
			// append not contain char into map
			output += str.charAt(i) ;
			// if char not contain inside map then insert that char into map 
			exist.put( str.charAt(i), 1);
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		
		System.out.println( uniqueChar(str) );
		
		s.close();
	}

}
