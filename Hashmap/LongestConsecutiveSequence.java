package hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
Longest Consecutive Sequence
Send Feedback
You are given an array of unique integers that contain numbers in random order. You have to find the longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains starting and ending element. If the length of the longest possible sequence is one, then the output array must contain only single element.
Note:
1. Best solution takes O(n) time.
2. If two sequences are of equal length, then return the sequence starting with the number whose occurrence is earlier in the array.
Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
The following line contains n space separated integers, that denote the value of the elements of the array.
Output format:
The first and only line of output contains starting and ending element of the longest consecutive sequence. If the length of longest consecutive sequence, then just print the starting element.
Constraints :
0 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
Sample Output 1 :
8 12 
Sample Input 2 :
7
3 7 2 1 9 8 41
Sample Output 2 :
7 9
Explanation: Sequence should be of consecutive numbers. Here we have 2 sequences with same length i.e. [1, 2, 3] and [7, 8, 9], but we should select [7, 8, 9] because the starting point of [7, 8, 9] comes first in input array and therefore, the output will be 7 9, as we have to print starting and ending element of the longest consecutive sequence.
Sample Input 3 :
7
15 24 23 12 19 11 16
Sample Output 3 :
15 16

Steps: 
First find out some consecutive subsequences
<11,12> <15,16> <19> <23,24>

Easiest Approach1 : 1)Sort the array - O(nlogn)
                    2)Then, traverse whole array and find longest consecutive subsequence 
Time Complexity - O(nlogn)
Efficient Approach2 : 
Consider, eg. 9,1,8,6,3,4,2,7,10,15  
Let's find out the length of longest subsequence   
Let's search which is the longest subsequence of which 9 is part of or we should say containing 9 what is the maximum length that we can achieve
let's keep a variable maxLength to store maximum length and one variable is start to store starting element of a sequence       
So, 9 is curr element now find subsequence of which 9 is part so search for 10,11,12,13 but 10 is here so 10 and 9 can be a sequence but there is not 11 so there is no sense to find for 12,13,.. so if we are going to search every element and search for it will take order of n time O(n) so we should not do that 
We can use HashMap, so push every element into map that I have
     map<<9,>,<1,>,<8,>,<6,>,<3,>,<4,>,<2,>,<7,>,<10,>,<15,>> so this will be the key and now just forget about the value
     if 9 is in the hashmap and I have to look for 10, I have to just 
     then search for 10, whether 10 is present in the map or not, so we are not going to search for every element and searching now we can quickly find out in the hashmap in O(1) time 
     then search for 10, if 10 is in the map then it's cool, increment length by 1, length = 2
     then search for 11, if 11 is not present in the map or not ? Ans is not then
     if I go ahead from 9 then the maxLenght I should say that I can achieve maxLength = 2 map<<9,><10,>> and 9 can obviously the part of sequence <,10,11, ..> sequence from 9 starting from 9 ( start = 9 ) , 9 is obviously an one answer but it can be that 8,7 there are in the array and 9 is part of that sequence so you should look for that also
     So, now you can have traversed from 9 to greater than 9 and you can have traversed go back from 9 and look for number smaller than 9 which are consecutive and look for 8,7,6,.. and so on
Now, again starting from 9 , and looking for element which smaller than 9,    
     Now, search for 8, 8 is in map and increment length by 1, length = 3
          search for 7, 7 is in map and increment length by 1, length = 4
     then search for 6, 6 is in map and increment length by 1, length = 5  
     then search for 5, 5 is not in map you should stop so 9 is a part of sequence which is of length 5 I should note down the start element of the sequence which is startc = 6 , startc is used to store the start of current sequence obviously compare the maximum you have  
     if( length > maxLength ) { // if 5 > 2 then update maxLength by length and update start
        maxLength = length      // maxLength = 5
        start = 6
     } 
     So, 9 is part of a sequence which is started from 6 and ending at 10 <<6>,<7>,<8>,<9>,<10>> and is of lenght = 5 so this is 1 sequence
Now, start from 1 , and looking for element which greater than 1,
     search for 2, 2 is in map and increment length by 1, length = 2
     search for 3, 3 is in map and increment length by 1, length = 3
     search for 4, 4 is in map and increment length by 1, length = 4
     search for 5, 5 is not in map we should stop and I should go back from 1
Now, again starting from 1 , and looking for element which less than 1,     
     search for 0, 0 is not in map so longest sequence including 1 is <<1,><2,>,<3,><4,>> of length = 4
      if( length > maxLength ) { // if 4 > 5 ? false then there is no sense to update maxLength and start
        maxLength = length      
        start = will not update 
     } 
Now, start from 8 , and looking for element which greater than 8, now I have to looking for sequence which is longest I should say sequence which is of 8 is part of, now if you closely recall I have already done this for 9, 
     9 is part of a sequence and 8 is present we did considerate in the sequence starting from 9 in the sequence including 9 I don't think we should repeat the process for 8 again what will be doing, we will be looking for 8,9,10,11 and so on and looking back for 7,6 and so on but we already did this for 9 so we should not repeat the process once again
     becoz we have already included the sequence of which 8 is part of so we should not repeat this 
     So how are we going keep a mark/check around it to not repeat, what should we do?
     Keys are obviously an array element and values of map should be boolean, initially all of them should be true  
   HashMap<Integer,Boolean> = map<<9,true>,<1,true>,<8,true>,<6,true>,<3,true>,<4,true>,<2,true>,<7,true>,<10,true>,<15,true>>
     As soon as I traverse all element in array I should mark it as false becoz I considered it for some sequence atleast
     So, initially from true it should be false for 9 now you are actually exploring around 9 
     find element which are just greater and smaller than 9 and mark it as false 
     for 9, mark 9,8,7,6,10 as false
     for 1, mark 1,2,3,4, as false
     HashMap<Integer,Boolean> = map<<9,false>,<1,false>,<8,false>,<6,false>,<3,false>,<4,false>,<2,false>,<7,false>,<10,false>,<15,true>>
     Now when I come across 8 again I should not start looking for consecutive sequence of 8 becoz 8 is already false becoz I already visited sequence including 8 so should not repeat the process again becoz that is redundant
     for 15, since it is true becoz we have not explored 15 or sequence including 15 yet so we will do that for 15 start looking forward from 15 so 16 is not there so there is no point moving ahead and then look back from 15 and 14 also is not there so there is no point looking back
     so the longest sequence include 15 is of length 1 and obviously this is not good length than any other so we should stop
*/
public class LongestConsecutiveSequence {

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		
          HashMap<Integer, Boolean> map = new HashMap<>();			
          ArrayList<Integer> result = new ArrayList<>();
          //insert all value from array into map
          for( int val : arr ) {
        	     map.put( val, true );
          }
          // map<<9,true>,<1,true>,<8,true>,<6,true>,<3,true>,<4,true>,<2,true>,<7,true>,<10,true>,<15,true>>

          for( int val : arr ) {
        	    //To avoid repeated traversing of an elements
        	    if( map.containsKey( val - 1 )) {
        		     //if val 1 less than val is present in map mark as false means already a part of any subsequence 
        		     map.put( val, false );
        	    }
         }
        // map<<15,true>,<24,true>,<23,true>,<12,,true>,<19,true>,<11,true>,<16,true>>
          
       int start = 0, maxLen = Integer.MIN_VALUE;  
		   for (int val : arr) {
            // if value is true which means that this val is not the part of any subsequence
			      if (map.get(val) == true) {
                int len = 1;
                // initially, value ko 1 se increment krenge aur find krenge does it exists in map if yes then increment the length of the the subsequence by curr length then increment val by length++, 
				       while (map.containsKey(val + len)) {
                      len++;
				       }
				   // Compare length of two subsequence and update maxLen with len
				   if( maxLen < len ) {
					     maxLen = len;
					     start = val;
				   }
			}
		}
         
		for( int i = 0; i < maxLen; i++ ) {
			   result.add( start + i);
		}
    return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner( System.in );
		
		int n = s.nextInt();
		int arr[] = new int[n];
		
		for( int i = 0; i < n; i++ ) {
			
			arr[i] = s.nextInt();
		}
		
		ArrayList<Integer> ans = longestConsecutiveIncreasingSequence( arr );
		
		for( int i : ans ) {
			System.out.println(i);
		}
		
		s.close();
	}

}
