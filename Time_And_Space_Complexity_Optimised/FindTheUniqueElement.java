package Time_And_Space_Complexity_Optimised;
/*           Find the Unique Element

Given an integer array of size 2N + 1. In this given array, N numbers are present twice and one number is present only once in the array.
You need to find and return that number which is unique in the array.
Note : Given array will always contain odd number of elements.
Input format :
Line 1 : Array size i.e. 2N+1
Line 2 : Array elements (separated by space)
Output Format :
Unique element present in the array
Constraints :
1 <= N <= 10^6
Sample Input :
7
2 3 1 6 3 6 2
Sample Output :
1    */
public class FindTheUniqueElement {
	public static int findUnique(int[] arr){
		int n = arr.length;      
		int res = arr[0];                    // res = 1
		for(int i = 1; i < n; i++)//  res=1^2=1^2^3=1^2^3^2=1^2^3^2^1 = 3 
		{
		    res = res ^ arr[i];
			
		}
		return res;

	}

	public static void main(String[] args) {
           int a[] = {2,3,1,6,3,6,2};
           int ans = findUnique(a);
           System.out.println(ans);
	}

}
