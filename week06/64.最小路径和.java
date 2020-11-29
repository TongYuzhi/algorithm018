/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[rowNum-1][colNum-1];
    }
}
// @lc code=end

/**
 * public int minPathSum(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[rowNum-1][colNum-1];
 */
