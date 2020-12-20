/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    /**
     *  dp[i][j] 表示t中[0, i)的子序列在s的[0, j)子序列
     *  中出现的次数
     * 
     *  当 s[j] == t[i] 时，有两个选择，要么选择s[j]，
     *  要么不选择s[j]
     * 
     *  比如 s: abbc  t:abc  s[3] == t[2], j = 3, i = 2
     *  需要找到有多少个 abc 在 abbc 中
     * 
     *  如果使用s[3],那么s和t的最后两个c匹配，我们只需要找
     *  abb 中有多少个 ab,对应 dp[i-1][j-1]
     *  
     *  如过不使用s[3]，那我们需要在abb中找有多少个abc,
     *  对应 dp[i][j-1]
     * 
     *  因此动态规划方程为 
     *  dp[i][j] = dp[i-1][j-1] + dp[i][j-1] (s[j-1] == t[i-1])
     *  dp[i][j] = dp[i][j-1] (s[j-1] != t[i-1])
     * 
     *  base case: 当t为空串时，空串是所有字符串的子串，因此
     *              dp[0][j] = 1
     */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
// @lc code=end

/**
 * public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
 */