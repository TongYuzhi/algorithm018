/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] charsOne = text1.toCharArray();
        char[] charsTwo = text2.toCharArray();

        int lenOne = text1.length();
        int lenTwo = text2.length();

        int[][] dp = new int[lenOne + 1][lenTwo + 1];

        for (int i = 1; i <= lenOne; i++) {
            for (int j = 1; j <= lenTwo; j++) {
                if (charsOne[i-1] == charsTwo[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[lenOne][lenTwo];
    }
}
// @lc code=end

/**
 * public int longestCommonSubsequence(String text1, String text2) {
        char[] charsOne = text1.toCharArray();
        char[] charsTwo = text2.toCharArray();

        int lenOne = charsOne.length;
        int lenTwo = charsTwo.length;

        int[][] dp = new int[lenOne + 1][lenTwo + 1];

        for (int i = 1; i <= lenOne; i++) {
            for (int j = 1; j <= lenTwo; j++) {
                if (charsOne[i-1] == charsTwo[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[lenOne][lenTwo];
    }
 */
