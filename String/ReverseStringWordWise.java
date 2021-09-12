package String;
/*Reverse String Word Wise
Send Feedback
Reverse the given string word wise. That is, the last word in given string should come at 1st place, last second word at 2nd place and so on. Individual words should remain as it is.
Input format :
String in a single line
Output format :
Word wise reversed string in a single line
Constraints :
0 <= |S| <= 10^7
where |S| represents the length of string, S.
Sample Input 1:
Welcome to Coding Ninjas
Sample Output 1:
Ninjas Coding to Welcome
Sample Input 2:
Always indent your code
Sample Output 2:
code your indent Always
*/
public class ReverseStringWordWise {
	public static String reverseWordWise(String input)
    {
// Approach 1
       String s[] = input.split(" ");
	   String ans = "";
	   for( int i = s.length - 1; i >= 0; i--)
	   {
	       ans += s[i] + " "; 
	   }
	   ans = ans.substring(0, ans.length() - 1);
	   return ans;
    }
//Approach 2
   public static String reverseWordWise2(String input)
   {
	   String rev = "";
	    input = " "+input;
	    int j = input.length() ;
	    for( int i = input.length() - 1; i >= 0 ; i--)
	    { 
	          if(input.charAt(i) == ' ') {
	           rev = rev + input.substring(i, j);
	            j = i; 
	          }
        }
       return rev;
	}
   
   public static String reverseWords(String s) {
       // removes all double spaces and splits each word to the array
//       String[] strArray = s.trim().replaceAll("\\s"," ").split("\\W"); 
       
       String[] strArr = s.trim().replaceAll("\s+"," ").split(" ");
//       for (int i = 0; i < strArr.length; i++) {
//    	   System.out.print(strArr[i] + " ");
//       }
       
       //reset our string since it is stored in strArray now
       s= "";
       // for the length of the array we will concatenate all strings
       for(int i = 1; i <= strArr.length; i++)
       {
           s+= strArr[strArr.length-i]+" ";
       }
       // return the new string and remove the space at the end of the string
       return s.substring(0, s.length() - 1);
   }
	public static void main(String[] args) 
	{
		String str = "Welcome to Coding Ninjas";
		String ans = reverseWordWise(str);
        System.out.println(ans);
        String s = "a good   example";
        String res = reverseWords(s);
        System.out.println(res);
	}

}
