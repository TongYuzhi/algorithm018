/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    // dp[i][0] means not have stock now
    // dp[i][1] means have stock now

    // dp[i][0] = max{dp[i-1][0], dp[i-1][1] + prices[i]}
    // dp[i][1] = max{dp[i-1][1], dp[i-1][0] - prices[i]}
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;

        for (int price : prices) {
            int newBuy = Math.max(buy, sell - price);
            int newSell = Math.max(sell, buy + price);

            buy = newBuy;
            sell = newSell;
        }
        return sell;
    }
}
// @lc code=end

/**
 * greedy
 * 
 * if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfi = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfi += Math.max(0, prices[i] - prices[i-1]);
        }
        return maxProfi;
 */

/**
 * dp
 * 
 * if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            int newBuy = Math.max(buy, sell - prices[i]);
            int newSell = Math.max(sell, buy + prices[i]);
            buy = newBuy;
            sell = newSell;
        }
        return sell;
 * 
 */
