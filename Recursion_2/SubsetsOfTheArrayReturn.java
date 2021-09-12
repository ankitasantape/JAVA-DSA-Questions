
package Recursion_2;
/*Return subset of an array
Send Feedback
Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :

Line 1 : Size of array

Line 2 : Array elements (separated by space)

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
public class SubsetsOfTheArrayReturn {
    public static int[][] subsets(int []input) {
    	      	   
    	  int ans[][] = subsets(input, 0);
    	  return ans;
    }
    private static int[][] subsets(int input[], int start) {
    	
    	if(start >= input.length) {
    	
    		int ans[][] = new int[1][0];
    		//System.out.println("empty" + start);
    		
    		return ans;
    	}
    	
    	int smallOutput[][] = subsets(input, start + 1);
    	
    	
    	// Jagged Array - Rows are fixed but columns are not
    	
    	int output[][] = new int[smallOutput.length * 2][]; //Total Number of rows in Outputarray = 2 * size Of smallArray
    	
    	int k = 0;                                          // Assume it is the value of count of row 
    	
    	int len = smallOutput.length;                        // Row length of small Output array
    	
    	//Copy the first run of smallOutputArray into Output array
    	
    	for(int i = 0; i < len; i++ ) {                      // iterating row of output array
    		
    		//kth row madhey smallOutput chya column etake colums create hoil
    		//output[0] = new int[1] {12}
    		//output[1] = new int[1] {20}
    		//output[2] = new int[2] {20,12}
    		//output[3] = new int[1] {15}
    		//output[4] = new int[2] {15,12}
    		//output[5] = new int[2] {15,20}
    		//output[6] = new int[3] {15,20,12}
    		
    		
    		output[k] = new int[smallOutput[i].length];
    		
    		for(int j = 0; j < smallOutput[i].length; j++ )                 //iterating columns of output array
    		{    
    		  //output[0][0] = smalloutput[0][0]
    		  //output[0][1] = smalloutput[0][1]
    		  //output[0][2] = smalloutput[0][2]
    			
    			output[k][j] = smallOutput[i][j];                           // copying values of column smallOutput into columns of Output Array
    			
    			//System.out.println(output[k][j]);
    		}
    		
    		k++;                                                           // incrementing the rows of output array
    	}
    //System.out.println(k);
    	
    for(int i = 0; i < len; i++) {
    		
    		//create same number of columns as it is the columns in smallOutput array w.r.t number of that row + add first ele to the 0th index
    		
    		output[k] = new int[smallOutput[i].length + 1];
    		
    		//System.out.println(start);
    		
    		output[k][0] = input[start];               //Storing the value of first column of smallOutput Array to to first column of output array
    		
    		//System.out.println(output[k][0]);
    		
    		for(int j = 1; j <= smallOutput[i].length; j++) 
    		{
    			output[k][j] = smallOutput[i][j - 1];
    		}
    		
    		k++;
    		
    	}
    	
    	return output;
    }
	public static void main(String[] args) {
		int a[] = {15, 20, 12};
		int ans[][] = subsets(a, 0);
		//Using Jagged Array
		for(int i = 0; i < ans.length; i++) {
			for(int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

}
