package Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*Code: Search word in Trie
Send Feedback
Implement the function SearchWord for the Trie class.
For a Trie, write the function for searching a word. Return true if the word is found successfully, otherwise return false.
Note : main function is given for your reference which we are using internally to test the code.
*/

/*Count Words in Trie
Send Feedback
You are given the Trie class with following functions -
1. insertWord
2. removeWord
Now, you need to create one more function (named "countWords" ) which returns the number of words currently present in Trie in O(1) time complexity.
Note : You can change the already given functions in the Trie class, if required.
Sample Input 1:
1 there
1 their
3
-1
Sample Output 2:
2
Sample Input 2:
1 a
1 ab
1 abcd
3
2 abcd
2 abcd
3
-1
Sample Output 2:
3
2
*/
/*Pattern Matching
Send Feedback
Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.
Input Format :
The first line of input contains an integer, that denotes the value of n.
The following line contains n space separated words.
The following line contains a string, that denotes the value of the pattern p.
Output Format :
The first and only line of output contains true if the pattern is present and false otherwise.
Constraints:
Time Limit: 1 sec
Sample Input 1 :
4
abc def ghi cba
de
Sample Output 1 :
false
Sample Input 2 :
4
abc def ghi hg
hi
Sample Output 2 :
true
Sample Input 3 :
4
abc def ghi hg
hif
Sample Output 3 :
false
*/
/*  Auto complete
Send Feedback
Given n number of words and an incomplete word w. You need to auto-complete that word w.
That means, find and print all the possible words which can be formed using the incomplete word w.
Note : Order of words does not matter.
Input Format :
The first line of input contains an integer, that denotes the value of n.
The following line contains n space separated words.
The following line contains the word w, that has to be auto-completed.
Output Format :
Print all possible words in separate lines.
Constraints:
Time Limit: 1 sec
Sample Input 1 :
7
do dont no not note notes den
no
Sample Output 2 :
no
not
note
notes
Sample Input 2 :
7
do dont no not note notes den
de
Sample Output 2 :
den
Sample Input 3 :
7
do dont no not note notes den
nom
Sample Output 3 :
(Empty) There is no word which starts with "nom"
*/
class TrieNode {
	
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	
	public TrieNode( char data ) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}

public class Pattern_Matching {
 
	private TrieNode root;
	private int count;
	
	public Pattern_Matching() {
		root = new TrieNode('\0');
		count = 0;
	}
	
	public int countWords() {
		
		return count;
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

	public void remove( String word ) {
		if( remove(root, word )) {
			this.count--;
		}
	}
	
	private boolean remove(TrieNode root, String word) {
		
		if(word.length() == 0){
			if(root.isTerminating) {
				root.isTerminating = false;
				return true;
			}
			else {
				return false;
			}
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		boolean ans = remove(child, word.substring(1));
		// We can remove child node only if it is non terminating and its number of children are 0	

		if(!child.isTerminating && child.childCount == 0){
			root.children[childIndex] = null;
			child = null;
			root.childCount--;
		}
		return ans;
		
//		if( !child.isTerminating) {
//			int numChild = 0;
//			for( int i = 0; i < 26; i++ ) {
//				if( child.children[i] != null ) {
//					numChild++;
//				}
//			}
//			
//			if( numChild == 0 ) {
//				//we can delete child 
//				root.children[childIndex] = null;
//				child = null;
//				root.childCount--;
//			}
//		}
	}

	private boolean search( TrieNode root, String word ) {
		
		if( word.length() == 0 ) {
			
			return root.isTerminating;
		}
		
		int childIndex = word.charAt(0) - 'a'; // 'n' - 'a' = 14
		TrieNode child = root.children[childIndex]; 
		if( child == null ) {
		
			return false;
		}
		
		return search( child, word.substring(1)) ;
	}
	
	public Boolean search(String word){
		
		   return search( root, word);
	}
	
	public void add( String word ) {
		
		if(add( root, word)) {
			this.count++;
		}
	}

	private boolean add(TrieNode root, String word) { // word = note
		
		if( word.length() == 0 ) {
			
			if (!root.isTerminating) {
				root.isTerminating = true;
				return true;
			
			} else {
			
				return false;
			}
		}
		
		int childIndex = word.charAt(0) - 'a'; // 'n' - 'a' = 14
		TrieNode child = root.children[childIndex]; 
		if( child == null ) {
			child = new TrieNode( word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		
	    return	add( child, word.substring(1));
	}

	public boolean patternMatching(ArrayList<String> vect, String pattern) {

		   for( int i = 0; i < vect.size(); i++ ) {
			   
			   //take string from vect 
			   String str = vect.get(i);
			   Pattern_Matching suffixeTrie = new Pattern_Matching();
			   for( int j = 0; j < str.length(); j++ ) {
				  
				   suffixeTrie.add( str.substring(j));
			   }
			   if( suffixeTrie.search(pattern)) {
				   return true;
			   }
		   }
		   
		   return false;
	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws IOException {
		//This is for search() and countWords() funtion
//		Trie t = new Trie();
//		t.add("a");
//        t.add("ab");
//        System.out.println(t.search("news"));
//        t.remove("news");
//        System.out.println(t.search("news"));
//        System.out.println(t.countWords());
		
//		Trie t = new Trie();
//        String[] string = br.readLine().split("\\s");
//        int choice = Integer.parseInt(string[0]);
//        String word = "Null";
//        if (string.length!=1)        
//        {
//            word = string[1];
//        }
//        		
//		
//		while(choice != -1) {
//			switch(choice) {
//				case 1 : // insert
//					t.add(word);
//					break;
//				case 2 : 
//					t.remove(word);
//					break;
//				case 3 : 
//					System.out.println(t.countWords());
//					break;
//				default :
//						return;
//			}
//            string = br.readLine().split("\\s");
//            choice = Integer.parseInt(string[0]);
//            if (string.length!=1)
//            {
//                word = string[1];
//            }
//		}
		
		//For PatternMatching()
		Pattern_Matching t = new Pattern_Matching();
		int n = Integer.parseInt(br.readLine().trim());
        ArrayList<String> input = new ArrayList<String>();
        String[] words = br.readLine().split("\\s");
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
		String pattern = br.readLine();
		System.out.println(t.patternMatching(input, pattern));
	}
}
