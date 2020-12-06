import java.util.HashSet;
import java.util.Set;

import jdk.internal.joptsimple.internal.Rows;

/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }
        slove(board);
    }

    private boolean slove(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            
                            if (slove(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

