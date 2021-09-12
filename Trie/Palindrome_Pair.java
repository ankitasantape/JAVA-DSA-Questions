package Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*Palindrome Pair
Send Feedback
Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word, 
which itself is a palindrome.
The function should return either true or false. You don't have to print anything.
Input Format :
The first line of the test case contains an integer value denoting 'n'.

The following contains 'n' number of words each separated by a single space.
Output Format :
The first and only line of output contains true if the conditions described in the task are met and false otherwise.
Constraints:
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
Sample Output 1 :
true
Explanation of Sample Input 1:
"abc" and "cba" forms a palindrome
Sample Input 2 :
2
abc def
Sample Output 2 :
false
Explanation of Sample Input 2:
Neither their exists a pair which forms a palindrome, nor any of the words is a palindrome in itself. Hence, the output is 'false.'
Sample Input 3 :
2
abc mcba
Sample Output 3 :
true
*/
//class TrieNode {
//	char data;
//	boolean isTerminating;
//	TrieNode children[];
//	int childCount;
//
//	public TrieNode(char data) {
//		this.data = data;
//		isTerminating = false;
//		children = new TrieNode[26];
//		childCount = 0;
//	}
//}
public class Palindrome_Pair {
	private TrieNode root;
	public int count;

	public Palindrome_Pair() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return root.isTerminating;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}

   /*..................... Palindrome Pair................... */
	public static boolean checkPalindrome(String str)
    {
    	String rev = "";
    	for(int i = str.length() - 1; i >= 0 ; i--)
    	{
    		rev = rev + str.charAt(i);
    	}
    	
    	if(str.equals(rev))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

	public static String reverse( String str ) {
		String rev = "";
    	for(int i = str.length() - 1; i >= 0 ; i--)
    	{
    		rev = rev + str.charAt(i);
    	}
    	return rev;
	}
	public static boolean isPalindromePair(ArrayList<String> words) {
		   
//		for( int i = 0; i < words.size(); i++ ) {
//			
////			boolean ans = checkPalindrome( words.get(i) );
////			if(ans) {
////				return true;
////			}
//			
//			String revStr = reverse( words.get( i ));
//			PalindromePair suffixTrie = new PalindromePair();
//			for( int j = 0; j < revStr.length(); j++ ) {
//				suffixTrie.add(revStr.substring(j));
//			}
//			
//			for( String word : words ) {
//				if(suffixTrie.search(word)) {
//					return true;
//				}
////				if( checkPalindrome(word+words.get(i))) {
////					return true;
////				}
//			}
//		}
		
        ArrayList<String> s = new ArrayList<>();
        Palindrome_Pair suffixTrie = new Palindrome_Pair();
        for( int i = 0; i < words.size(); i++ ) {
        	suffixTrie.add(words.get(i));
        	s.add(reverse(words.get(i)));
        }
		for( int i = 0; i < words.size(); i++ ) {
			if ( suffixTrie.search(words.get(i))) {
				return true;
			}
			
		}
		return false;
	}

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static ArrayList<String> takeInput() throws IOException {
        ArrayList<String> words = new ArrayList<>();

        int n = Integer.parseInt(br.readLine().trim());

        if (n == 0) {
            return words;
        }
        
        String[] listOfWords; 
        listOfWords = br.readLine().split("\\s");
        

        for (int i = 0; i < n; ++i) {
            words.add(listOfWords[i]);
        }

        return words;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
      //  PalindromePair root = new PalindromePair();

        ArrayList<String> words = takeInput();
        System.out.println(isPalindromePair(words));
    } 

}
