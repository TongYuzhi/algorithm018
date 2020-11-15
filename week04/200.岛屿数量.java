import java.util.LinkedList;
import java.util.Queue;

import jdk.internal.jshell.tool.resources.l10n;
import sun.awt.www.content.image.gif;

/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
// @lc code=end

/** bfs
 * 
 * public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int islands = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(i * colNum + j);
                    grid[i][j] = '0';
                    islands++;
                    while (!queue.isEmpty()) {
                        int temp = queue.poll();
                        int row = temp / colNum;
                        int col = temp % colNum;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            grid[row-1][col] = '0';
                            queue.offer((row - 1) * colNum + col);
                        }
                        if (row + 1 < rowNum && grid[row+1][col] == '1') {
                            grid[row+1][col] = '0';
                            queue.offer((row + 1) * colNum + col);
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            grid[row][col-1] = '0';
                            queue.offer(row * colNum + col - 1);
                        }
                        if (col + 1 < colNum && grid[row][col+1] == '1') {
                            grid[row][col+1] = '0';
                            queue.offer(row * colNum + col + 1);
                        }
                    }
                }
            }
        }
        return islands;
    }
 */

/**
 *  approach 1 dfs
 * 
 * 
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row >= grid.length || row < 0 
            || col >= grid[row].length || col < 0 || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
 */
