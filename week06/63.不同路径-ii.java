import jdk.internal.jshell.tool.resources.l10n;

/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];

        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i-1];
                }
            }
        }
        return dp[width-1];
    }
}
// @lc code=end

/**
 * 
 * public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int width = obstacleGrid[0].length;
        int[] dp = new int[width];

        dp[0] = 1;

        for (int[] row : obstacleGrid) {
            for (int i = 0; i < width; i++) {
                if (row[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i-1];
                }
            }
        }
        return dp[width-1];
    }
 */
