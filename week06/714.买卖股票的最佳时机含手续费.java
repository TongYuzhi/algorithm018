/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    /**
     *  设置每次买入时交手续费
     * 
     *  dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[0])
     *  dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[0] - fee);
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int len = prices.length;
        int buy = -prices[0] - fee;
        int sell = 0;

        for (int i = 1; i < len; i++) {
            int temp = buy;
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, temp + prices[i]);
        }
        return sell;
    }
}
// @lc code=end

/**
 *  space complexity: O(n^2)
 * 
 * public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }
        return dp[len-1][0];
    }
 */
