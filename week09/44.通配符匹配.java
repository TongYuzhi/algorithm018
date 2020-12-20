/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    /**
     *  dp[i][j] 表示 p 前 i 个字符和 s 前 j 个字符是否匹配
     */
    public boolean isMatch(String s, String p) {
        int len1 = p.length();
        int len2 = s.length();

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        dp[0][0] = true;

        for (int i = 1; i <= len1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

