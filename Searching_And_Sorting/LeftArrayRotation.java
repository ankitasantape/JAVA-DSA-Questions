package Searching_And_Sorting;

import java.util.Scanner;

public class LeftArrayRotation 
{   
	public static int[] leftArrayRotation(int[] a, int d)
	{
		int n = a.length;
		int j = d;
		int []rot = new int[n];
		int i = 0;
		while(j < n)
		{
			rot[i] = a[j];
			i++;
			j++;
		}
		j = 0;
		while(j < d)
		{
			rot[i] = a[j];
			i++;
			j++;
		}
		return rot;
		
	}

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t != 0) {
			int n = s.nextInt();
			int a[] = new int[n];
			for(int i = 0; i < n; i++)
			{
				a[i] = s.nextInt();
			}
			int d = s.nextInt();
		int []ans = leftArrayRotation(a, d);
		for(int i =0; i < ans.length; i++)
		{
			System.out.print(ans[i]+" ");
		}
		t--;
		}
		s.close();
	}

}
