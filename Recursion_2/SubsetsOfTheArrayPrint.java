package Recursion_2;
/*Print Subsets of Array
Send Feedback
Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important. Just print the subsets in different lines.
Input format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 15
Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 */
public class SubsetsOfTheArrayPrint {
	public static void printSubsets(int input[]) {
        int a[] = new int[0];
        printSubsets(input, 0, a);
	}

	private static void printSubsets(int input[], int start, int[] output)
	{
		if(start == input.length) {
			for(int i = 0; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		int newOut[] = new int[output.length + 1];
		
		for(int i = 0; i < output.length; i++) {
			
			newOut[i] = output[i];
		}
		newOut[output.length] = input[start];
		
		printSubsets(input, start + 1, output);
		
		
		printSubsets(input, start + 1, newOut);
	
		
		
	}
	public static void main(String[] args) {

		int a[] = {15, 20, 12};
		printSubsets(a);
		
	}

}
