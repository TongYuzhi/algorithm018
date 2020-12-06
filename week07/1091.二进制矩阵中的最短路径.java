import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import jdk.vm.ci.meta.PrimitiveConstant;

/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {
    private int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int rowNum = grid.length;
        int colNum = grid[0].length;

        if (grid[0][0] == 1 || grid[rowNum - 1][colNum - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        boolean[][] visited = new boolean[rowNum][colNum];
        visited[0][0] = true;

        int minPath = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[0] == rowNum - 1 && cur[1] == colNum - 1) {
                    return minPath + 1;
                }
                for (int i = 0; i < dir.length; i++) {
                    int nextRow = cur[0] + dir[i][0];
                    int nextCol = cur[1] + dir[i][1];

                    if (nextRow < 0 || nextRow >= rowNum || nextCol < 0 || nextCol >= colNum || grid[nextRow][nextCol] != 0 || visited[nextRow][nextCol]) {
                        continue;
                    }
                    queue.offer(new int[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
            minPath++;
        }
        return -1;
    }
}
// @lc code=end

/**
 *  little changed
 *  space complexity : O(1) .. but it will change origin value
 * 
 * private int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int rowNum = grid.length;
        int colNum = grid[0].length;

        if (grid[0][0] == 1 || grid[rowNum - 1][colNum - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        grid[0][0] = 2;

        int minPath = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[0] == rowNum - 1 && cur[1] == colNum - 1) {
                    return minPath + 1;
                }
                for (int i = 0; i < dir.length; i++) {
                    int nextRow = cur[0] + dir[i][0];
                    int nextCol = cur[1] + dir[i][1];

                    if (nextRow < 0 || nextRow >= rowNum || nextCol < 0 || nextCol >= colNum || grid[nextRow][nextCol] != 0) {
                        continue;
                    }
                    queue.offer(new int[] {nextRow, nextCol});
                    grid[nextRow][nextCol] = 2;
                }
            }
            minPath++;
        }
        return -1;
    }
 */

/**
 *  time complexity : O(n^2)
 *  space complexity : O(n^2)
 * 
 * private int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int rowNum = grid.length;
        int colNum = grid[0].length;

        if (grid[0][0] == 1 || grid[rowNum - 1][colNum - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        boolean[][] visited = new boolean[rowNum][colNum];
        visited[0][0] = true;

        int minPath = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[0] == rowNum - 1 && cur[1] == colNum - 1) {
                    return minPath + 1;
                }
                for (int i = 0; i < dir.length; i++) {
                    int nextRow = cur[0] + dir[i][0];
                    int nextCol = cur[1] + dir[i][1];

                    if (nextRow < 0 || nextRow >= rowNum || nextCol < 0 || nextCol >= colNum || grid[nextRow][nextCol] != 0 || visited[nextRow][nextCol]) {
                        continue;
                    }
                    queue.offer(new int[] {nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
            minPath++;
        }
        return -1;
    }
 */

 /**
  * 
  private int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 1}};

    private int step = 1;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int rowNum = grid.length;
        int colNum = grid[0].length;

        if (grid[0][0] == 1 || grid[rowNum - 1][colNum - 1] == 1) {
            return -1;
        }

        PriorityQueue<int[]> queue = 
                    new PriorityQueue<>((a1, a2) -> 
                        (Math.max(rowNum - a1[0], colNum - a1[1]) + step * 3) 
                        - (Math.max(rowNum - a2[0], colNum - a2[1]) + step * 3));
        queue.offer(new int[] {0, 0});
        grid[0][0] = 2;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                System.out.println(cur[0] + " " + cur[1]);
                if (cur[0] == rowNum - 1 && cur[1] == colNum - 1) {
                    return step;
                }
                for (int i = 0; i < dir.length; i++) {
                    int nextRow = cur[0] + dir[i][0];
                    int nextCol = cur[1] + dir[i][1];

                    if (nextRow < 0 || nextRow >= rowNum 
                                    || nextCol < 0 || nextCol >= colNum 
                                    || grid[nextRow][nextCol] != 0) {
                        continue;
                    }
                    queue.offer(new int[] {nextRow, nextCol});
                    grid[nextRow][nextCol] = 2;
                }
            }
            step++;
        }
        return -1;
    }
  */
