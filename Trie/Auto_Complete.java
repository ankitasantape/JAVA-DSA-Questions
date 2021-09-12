package Trie;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*Auto complete
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
import java.util.ArrayList;

public class Auto_Complete {
	private TrieNode root;
	public int count;
	public Auto_Complete() {
		root = new TrieNode('\0');
	}
    // Recursive add function
	private void add(TrieNode root, String word){
		// when we reach to the end of the string then we will set last char of given string as terminating
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		// first, get the ascii value of that char
		int childIndex = word.charAt(0) - 'a';
		// get the child at that index if this char is present in the children array
		TrieNode child = root.children[childIndex];
		// if child is not present inside the children array 
		if(child == null){
			// create new child of this char
			child = new TrieNode(word.charAt(0));
			// and insert new child into the children array
			root.children[childIndex] = child;
			// after inserting child, increment the childcount 
			root.childCount++;
		}
		// one word has been added or if it already present then add next char of the the string and add the updated child becoz new char will be insert into the child of child
		add(child, word.substring(1));
	}

	public void add(String word){
		        add(root, word);
	}
	
	public void remove(TrieNode root, String word ) {
		
		        if( word.length() == 0 ) {
		        	root.isTerminating = false;
		        }
		        // first, get the ascii value of that char
				int childIndex = word.charAt(0) - 'a';
				// get the child at that index if this char is present in the children array
				TrieNode child = root.children[childIndex];
				// if child is not present inside the children array 
				if(child == null){
					return;
				}
				// if child is exists then then remove it
				remove( child, word.substring(1));
				
				//niche ke code ko skip krke humne ek childCount variable liye hai jisase hum
				//har bar child ke child count krne ke liye travel nahi krna padega
				
				if( !child.isTerminating && child.childCount == 0 ) {
					// children array ke us index pe null add kr dete
					root.children[childIndex] = null;
					// aur actually us child ko bhi null kr dete
					child = null;
					root.childCount--;
				}
				//we can remove that node if it has no child and that childNode is non-terminating
//				if( !child.isTerminating ) {
//					//count the children of current childNode
//					int numChild = 0;
//					for( int i = 0; i < 26; i++ ) {
//						if( child.children[i] != null ) {
//							numChild++;
//						}
//					}
//					if( numChild == 0 ) {
//						root.children[childIndex] = null;
//						child = null;
//						root.childCount--;
//					}
//				}
				
	}
	
	public void remove(String word) {
		remove(root, word);
	}
	
	private TrieNode search(TrieNode root, String word) {
		// if word length is zero then return root only becoz there is no child of that word
		if(word.length() == 0) {
			return root;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];
        // search kiya but nahi mila wo char of word to return null
		if(child == null) {
			return null;
		}
        // search for next word into child of child node
		return search(child,word.substring(1));
	}
    public TrieNode search(String word) {
		return search(root,word);
	}
	public void printPossibleWords( TrieNode root, String word, String output ) {
		if( root.isTerminating) {
			System.out.println(word + output);
		}
		//To find a given word in trie then need to traverse with each and every child 
		// Jitane length ka array hai usako traverse krna padega 
		for( int i = 0; i < root.children.length; i++ ) {
			// if we reach at end of the trie then print its possible words 
			if( root.children[i] != null ) {
				// in output append the current child data 
				printPossibleWords(root.children[i], word, output + root.children[i].data );
			}
		}
	}
	public void autoComplete(ArrayList<String> input, String word) {
		Auto_Complete trie = new Auto_Complete();
        // add given arraylist into trie
		for( String string : input ) {
			trie.add(string);
		}
		// search given word is present inside trie or not
		TrieNode t = trie.search(word);
		// if not found then return nothing 
		if( t == null ) {
			return;
		}
        
        printPossibleWords(t, word, "");
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
    	Auto_Complete t = new Auto_Complete();
		int n = Integer.parseInt(br.readLine().trim());
        ArrayList<String> input = new ArrayList<String>();
        String[] words = br.readLine().split("\\s");
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
		String pattern = br.readLine();
		t.autoComplete(input, pattern);
	}
}
