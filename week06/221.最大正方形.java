/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    /**
     * dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
     * 
     * dp[i][j] 表示以 matrix[i-1][j-1] 为右下角的正方形的最大边长
     * 
     * 如果一个格子为1，我们要看它的左上角，左边，以及上边是不是也是1，
     * 如果都是1，说明当前格子可以加入到一个正方形中。
     * 
     * 这里dp比 matrix多了一列和一行，以便判断第一列第一行的dp值，因此
     * 是matrix[i-1][j-1]
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int width = matrix[0].length;

        int maxWidth = Integer.MIN_VALUE;
        int[] dp = new int[width + 1];

        for (char[] row : matrix) {
            int northWest = 0;
            for (int col = 0; col < width; col++) {
                int nextNorthWest = dp[col + 1];
                if (row[col] == '1') {
                    dp[col+1] = Math.min(dp[col], Math.min(dp[col+1], northWest)) + 1;
                    maxWidth = Math.max(maxWidth, dp[col+1]);
                } else {
                    dp[col + 1] = 0;
                }
                northWest = nextNorthWest;
            }
        }
        return maxWidth * maxWidth;
    }
}
// @lc code=end

/**
 *  space complexity: O(n)
 * 
 * public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int width = matrix[0].length;

        int res = 0;
        
        int[] dp = new int[width + 1];

        for (char[] row : matrix) {
            int northWest = 0;
            for (int i = 0; i < width; i++) {
                int nextNorthWest = dp[i + 1];
                if (row[i] == '1') {
                    dp[i + 1] = Math.min(dp[i], Math.min(dp[i+1], northWest)) + 1;
                    res = Math.max(res, dp[i + 1]);
                } else {
                    dp[i + 1] = 0;
                }
                northWest = nextNorthWest;
            }
        }
        return res * res;
    }
 */

/**
 *  space complexity: O(n^2)
 * 
 * public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;

        int res = 0;

        int[][] dp = new int[height+1][width+1];

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
 */
