package Recursion_2;


/*Return subsets sum to K

Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. 
But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 
Constraints :
1 <= n <= 20
Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1            */
public class SubsetSumToKReturn {
	
	public static int[][] subsetsSumK(int input[], int k) {
	
		int an[][] = subsetsSumK(input, 0, k);
		
		return an;

	}
	private static int[][] subsetsSumK(int input[], int start , int k) {
	     
		if(start == input.length) {
			
			if( k == 0) {
			
				int ans[][] = new int[1][0];
				
				return ans;
			
			} else {
			
				int ans[][] = new int[0][0];
				
				return ans;
			}
		}
		int temp1[][] = subsetsSumK(input, start + 1, k);
		
		int temp2[][] = subsetsSumK(input, start + 1, k - input[start]);
		
		int output[][] = new int[temp1.length + temp2.length][];
		
		for(int r = 0; r < temp1.length; r++) {
			
			output[r] = new int[temp1[r].length];
			
			for(int c = 0; c < output[r].length; c++) {
			    
				output[r][c] = temp1[r][c];
				//System.out.println(output[r][c] + r +" "+c);
			}
		}
		
		//System.out.println(temp1.length);
		for(int r = 0; r < temp2.length; r++) {
			
			//System.out.println(temp2[r].length);
			output[r + temp1.length] = new int[temp2[r].length + 1];
			
			output[r + temp1.length][0] = input[start];
			
			for(int c = 1; c < output[r + temp1.length].length; c++) {
			
				output[r + temp1.length][c] = temp2[r][c-1]; 
			
			}
			
		}
		
		
		
		return output;
		
				
	}
	public static void main(String[] args) {
		
		int a[] = {5,12, 3, 17, 1, 18, 15, 3, 17 };
		
		int k = 6;
		
		int ans[][] = subsetsSumK(a, k);
		
		for(int i = 0; i < ans.length; i++) {
		
			for(int j = 0; j < ans[i].length; j++) {
			
				System.out.print(ans[i][j]+ " ");
			
			}
			
			System.out.println();
		}
	}

}
