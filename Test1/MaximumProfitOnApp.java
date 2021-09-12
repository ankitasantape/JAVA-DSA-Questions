package Test1;

import java.util.Arrays;

public class MaximumProfitOnApp {
    public static int maximumProfit(int budget[]) {
    	Arrays.sort(budget);
    	
    	int mid = (0 + (budget.length)) / 2;
    	
    	return mid * budget[mid];
    }
	public static void main(String[] args) {
		
	int NoOfBuyers = 4;
	int BudgetOfBuyers[] = { 30, 20, 53, 14 };
	
	int ans = maximumProfit(BudgetOfBuyers);
	System.out.println(ans);
	}

}
