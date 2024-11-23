// Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.
// Note: Stock must be bought before being sold.
// Examples:
// Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
// Output: 8
// Explanation: You can buy the stock on day 2 at price = 1 and sell it on day 5 at price = 9. Hence, the profit is 8.
// Input: prices[] = [7, 6, 4, 3, 1]
// Output: 0 
// Explanation: Here the prices are in decreasing order, hence if we buy any day then we cannot sell it at a greater price. Hence, the answer is 0.

class Solution {
    public int maximumProfit(int prices[]) {
        int n=prices.length;
        int profit=0,min=prices[0];
        for(int i=1;i<n;i++)
        {
            if(prices[i]>min)
            profit=Math.max(profit,prices[i]-min);
            else
            min=prices[i];
        }
        return profit;
    }
}
