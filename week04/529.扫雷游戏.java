import javax.swing.border.Border;

/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    private static final int[] rowChange = {1, 0, -1, 0, 1, -1, 1, -1};
    private static final int[] colChange = {0, 1, 0, -1, 1, -1, -1, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];

        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return board;
        }

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            dfs(board, row, col);
        }
        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        int bombs = 0;
        for (int i = 0; i < rowChange.length; i++) {
            int newRow = row + rowChange[i];
            int newCol = col + colChange[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }
            if (board[newRow][newCol] == 'M') {
                bombs++;
            }
        }

        if (bombs > 0) {
            board[row][col] = (char) (bombs + '0');
        } else {
            board[row][col] = 'B';
            for (int i = 0; i < rowChange.length; i++) {
                int newRow = row + rowChange[i];
                int newCol = col + colChange[i];
                if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length || board[newRow][newCol] != 'E') {
                    continue;
                }
                dfs(board, newRow, newCol);
            }
        }
    }
}
// @lc code=end

/**
 * private static final int[] rowChange = {1, 0, -1, 0, 1, -1, 1, -1};
    private static final int[] colChange = {0, 1, 0, -1, 1, -1, -1, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (row < 0 || row >= board.length 
                    || col < 0 ||  col >= board[row].length) {
            return board;
        }

        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            dfs(row, col, board);
        }
        return board;
    }

    private void dfs(int row, int col, char[][] board) {
        int bombs = 0;
        for (int i = 0; i < rowChange.length; i++) {
            int newRow = row + rowChange[i];
            int newCol = col + colChange[i];

            if (newRow < 0 || newRow >= board.length 
                    || newCol < 0 || newCol >= board[newRow].length) {
                continue;
            }
            if (board[newRow][newCol] == 'M') {
                bombs++;
            }
        }
        if (bombs > 0) {
            board[row][col] = (char) (bombs + '0');
        } else {
            board[row][col] = 'B';
            for (int i = 0; i < rowChange.length; i++) {
                int newRow = row + rowChange[i];
                int newCol = col + colChange[i];
                if (newRow < 0 || newRow >= board.length 
                        || newCol < 0 ||  newCol >= board[newRow].length
                        || board[newRow][newCol] != 'E') {
                    continue;
                }
                dfs(newRow, newCol, board);
            }
        }
    }
 */
