/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    /**
     *  分成两种情况。一次交易需要一买一卖，所以k > len/2 时，
     *  其实不能起到限制作用，我们就可以把它当成是可以无限交易
     *  的条件来做，即第二题。
     * 
     * 对于k < len/2 的条件，可以按照第三题的思路来做。
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 1 || k < 1) {
            return 0;
        }
        int len = prices.length;
        if ((len >> 1) <= k) {
            int buy = -prices[0];
            int sell = 0;

            for (int i = 1; i < len; i++) {
                int tempBuy = buy;
                buy = Math.max(buy, sell - prices[i]);
                sell = Math.max(sell, tempBuy + prices[i]);
            }
            return sell;
        }
        int[][][] dp = new int[len][k+1][2];

        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[len-1][k][0];
    }
}
// @lc code=end

