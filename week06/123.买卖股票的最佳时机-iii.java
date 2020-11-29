/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    /**
     *  dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
     *  dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
     *  dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     *  dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
     *              = max(dp[i-1][1][1], -prices[i])
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int len = prices.length;
        int k = 2;

        int[][][] dp = new int[len][k+1][2];

        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);    
            }
        }
        return dp[len-1][k][0];
    }
}
// @lc code=end

/**
 * 
 * public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int len = prices.length;
        int indexTwo0 = 0;
        int indexTwo1 = -prices[0];
        int indexOne0 = 0;
        int indexOne1 = -prices[0];

        for (int i = 1; i < len; i++) {
            indexTwo0 = Math.max(indexTwo0, indexTwo1 + prices[i]);
            indexTwo1 = Math.max(indexTwo1, indexOne0 - prices[i]);
            indexOne0 = Math.max(indexOne0, indexOne1 + prices[i]);
            indexOne1 = Math.max(indexOne1, -prices[i]);
        }
        return indexTwo0;
    }
 */

/**
 * 
 * public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int len = prices.length;
        int[][][] dp = new int[len][3][2];
        
        //base case
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        
        for (int i = 1; i < len; i++) {
            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]);
        }
        return dp[len-1][2][0];
    }
 */