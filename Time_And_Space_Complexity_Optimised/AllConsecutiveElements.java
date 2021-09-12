package Time_And_Space_Complexity_Optimised;

import java.util.Arrays;

public class AllConsecutiveElements {
    
	public static boolean allConsecutiveEle(int a[], int n) {
		
		Arrays.sort(a);
		//2 3 4 5 6 7
		int s = a[0];
		for(int i = 0; i < n; i++) {
			//System.out.println(i);
			if(a[i] != s) {
				//System.out.println(a[i] + " " + i);
				return false;
			}
			s++;
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		int n = 6;
		int a[] = {1,9,2,4,0,3};
		int a1[] = {3,7,2,5,4,6};
		boolean ans = allConsecutiveEle(a1 , n);
		System.out.println(ans);
	}

}
