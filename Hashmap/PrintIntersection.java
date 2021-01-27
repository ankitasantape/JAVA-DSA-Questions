package hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*Print Intersection

You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively. 
You need to print their intersection;
 An intersection for this problem can be defined when both the arrays/lists contain a particular value or to put it in other words, 
 when there is a common value that exists in both the arrays/lists.
Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in the order they appear in the second sorted array/list(ARR1).


Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

The first line of each test case or query contains an integer 'N' representing the size of the first array/list.

The second line contains 'N' single space separated integers representing the elements of the first the array/list.

The third line contains an integer 'M' representing the size of the second array/list.

The fourth line contains 'M' single space separated integers representing the elements of the second array/list.
Output format :
For each test case, print the intersection elements in a row, separated by a single space.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^6
0 <= M <= 10^6

Time Limit: 1 sec 
Sample Input 1 :
2
6
2 6 8 5 4 3
4
2 3 4 7 
2
10 10
1
10
Sample Output 1 :
2 3 4
10
Sample Input 2 :
1
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1 2 2
Explanation for Sample Output 2 :
Since, both input arrays have two '2's, the intersection of the arrays also have two '2's. 
The first '2' of first array matches with the first '2' of the second array. 
Similarly, the second '2' of the first array matches with the second '2' if the second array.

Approach 1: The first approach we can think is that we can run 2 loops. In the outer loop pick
one element of array 1 and then with the help of an inner loop check whether the same element
exists in array 2 or not. If the same element is found then, we found an intersection so we print it,
and to handle the case of duplicates, we can replace this element with minus infinity.
Pseudo Code for this approach:
Function intersection:
 For i = 0 to i less than size1:
 For j = 0 to j less than size2:
 If arr1[i] equal to arr2[j]:
 Print(arr2[j])
 arr2[j]=minus infinity
 break
Time Complexity for this approach: Time complexity for this approach is O(size1 * size2 ),
which is not good, hence, we are moving to the next approach.

Approach 2: A better solution for this problem is to sort both the arrays. Now, we have to find
the intersection of 2 sorted arrays:
1) Use two index variables i and j, initialize them as i = 0, j = 0
2) If arr1[i] is smaller than arr2[j] then increment i.
3) If arr1[i] is greater than arr2[j] then increment j.
4) If both are same then print any of them and increment both i and j.

Time Complexity for this approach: Time complexity for sorting both arrays will be
O(size1*log(size1) + size2*log(size2)) and then finding the intersection will have a time
complexity of O(size1+size2).

❏ Let us dry run the code for:
 Size1 of arr1 = 6
 arr1[] = 2 6 8 5 4 3
 Size2 of arr2 = 4
 arr2[] = 2 3 4 7

Approach 3: The best solution here is to use hashmaps to further reduce the time complexity of
this problem. To continue with the hashmaps we can proceed with the following steps:
1. Initialize an empty hashmap mapp.
2. Iterate through the first array, and put every element of this array in the mapp with its
corresponding count.
3. Now for every element of the second array, search it in the hashmap and if it is present
then print it and decrement its corresponding count. After decrement, if the corresponding
count becomes zero, then we should remove the element from the mapp.

Time Complexity for this approach: Time complexity for this approach is O(m+n) as searching
and inserting operations in hashmaps are performed in O(1) time.

Pseudo Code for this approach:
Function intersection:
 Create an empty hashmap mapp
 For i=0 to i less than size1:
 Increment the count of each element of this array in hashmap
 For i=0 to i less than size2:
 If any element of array2 exists in hashmap:
 Print(element)
 Decrement the count of that element in hashmap.
 If count corresponding to that element is zero
 Delete(element, mapp)
 ❏ Let us dry run the code for:
 Size1 of arr1 = 6
 arr1[] = 2 6 8 5 4 3
 Size2 of arr2 = 4
 arr2[] = 2 3 4 7
 
 Step1 : Creating an empty hashmap
 Step2 : Inserting each element of array1 with its count in the hashmap
         map<key,value> = < <2,1>, <6,1>, <8,1>, <5,1>, <4,1>, <3,1> >
 step3 : Going through each element of array2, here the first element is 2 and since 2 exists in hashmap
         so, print it and then decrement its count from the mapp and now move to the next element.
         map<key,value> = < <2,0>, <6,1>, <8,1>, <5,1>, <4,1>, <3,1> >
 step4 : Now, the second element 3 exists in hashmap so print it and then decrement its count from the
         mapp and now move to the next element.
          map<key,value> = < <2,0>, <6,1>, <8,1>, <5,1>, <4,1>, <3,0> >      
 step5 : The third element, 4 exists in hashmap so print it and then decrement its count from the mapp
         and now move to the next element. 
          map<key,value> = < <2,0>, <6,1>, <8,1>, <5,1>, <4,0>, <3,0> >
Now, when we move to 7, it does not exist in the hashmap, so, we do nothing.
Our final output will be:
2
3
4               
*/

public class PrintIntersection {

	/*Map 2 2  |  1 1
          1 1  |  2 2
          6 1  |  3 1
                  4 1 */	     
	public static void intersection(int[] arr1, int[] arr2) {
	    
		 //Arrays.sort(arr1);
	     Arrays.sort(arr2);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for( int i : arr1 ) {
			
			if( map.containsKey( i )) {
				//increment frequency of duplicate element
				map.put( i , map.get( i ) + 1);
			
			} else {
				
				map.put( i, 1 );
			}
		}
		
		for( int i : arr2 ) {
			
			if( map.containsKey( i ) && map.get(i) > 0 ) {
				// if element in arr2 appears in arr1 the print that element
				System.out.print( i + " ");
				// after printing element decrement its count
				map.put(i, map.get(i) - 1);
				
			}
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		int a1[] = { 2, 6, 8, 5, 4, 3 };
		int a2[] = { 2, 3, 4, 7 };
		
		int a3[] = { 10, 10 };
		int a4[] = { 10 };
		
		int a5[] = {2, 6, 1, 2};
		int a6[] = {1, 2, 3, 4, 2 };
		
		int a7[] = { 5, 8, 7, 4, 8 };            //{ 5, 1 } { 8, 2 } { 7, 1 }  { 4, 1}
		int a8[] = { 4, 6, 6, 10, 8, 5, 5, 1 }; // { 4, 1 } { 6, 2 } { 10, 1 } { 8, 1} { 5, 2 }
		
		intersection( a1, a2);
		intersection( a3, a4);
		intersection( a5, a6);
		intersection( a7, a8); // Ans = 4 5 8 
	}

}
