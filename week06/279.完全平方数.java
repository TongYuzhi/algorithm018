/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    /**
     *  dp[i] = min(dp[i], dp[i-j*j] + 1)
     * 
     *  dp[i]在第一轮中被赋为最大完全平方数个数，因为1也是完全
     *  平方数，所以一个数本身就是能分解的最多的完全平方数个数
     * 
     *  i - j * j 中，j * j 表明了 j * j 是一个完全平方数，所
     *  以将 n 拆分成了 (一个完全平方数 + n1)，n1 就是一个子问题
     * 
     *  j * j 越大，i - j * j就越小，一轮遍历之后就可以得到该数
     *  可以被分解成的最大完全平方数的个数，这里要加 1，因为 j * j
     *  也是一个完全平方数，要加上它
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

