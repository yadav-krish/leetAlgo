// The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.
// Note: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

// Examples:
// Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
// Output: 865
// Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.

class Solution {
    public int maximumProfit(int prices[]) {
        int n=prices.length;
        if(n==1)
        return 0;
        int sum=0;
        int prev=prices[0];
        for(int i=1;i<n;i++)
        {
            if(prices[i]>prev)
            sum+=(prices[i]-prev);
            prev=prices[i];
        }
        return sum;
    }
}
