package Basic;

import java.util.Scanner;

public class PrimesOfN {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++)
        {
        	int count = 0;
        	for(int j = i; j >= 1; j--)
        	{
        		if(i % j == 0)
        		{
        			count += 1; 
        		}
        	}
        	if(count == 2)
        	{
        		System.out.println(i);
        	}
        }
        sc.close();
	}

}
