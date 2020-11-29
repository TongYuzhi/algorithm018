/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    /**
     *  因为有冷冻期，所以第i天持有股票的话，只可能是第i-2天买入的，或者
     *  第i-1天本身就持有的。
     * 
     *  dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     *  dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int len = prices.length;

        int preSell = 0;
        int curSell = 0;
        int curBuy = -prices[0];

        for (int i = 1; i < len; i++) {
            int nextSell = Math.max(curSell, curBuy + prices[i]);
            int nextBuy = Math.max(curBuy, preSell - prices[i]);
            preSell = curSell;
            curSell = nextSell;
            curBuy = nextBuy;
        }
        return curSell;
    }
}
// @lc code=end

/**
 *  space complexity: O(n^2)
 * 
 * public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], (i >= 2 ? dp[i-2][0] : 0) - prices[i]);
        }
        return dp[len-1][0];
    }
 */
