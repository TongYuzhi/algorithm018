import java.util.HashSet;
import java.util.Set;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    /**
     *  persume 5 not in row[0]
     *  row[0] = row[0] | (1 << 5) = 0 | (1 << 5)
     *                             = 0000 0001 << 5
     *                             = 0010 0000
     *  check 5 in row[0]
     *  row[0] = (row[0] >> 5) & 1 = 0010 0000 >> 5 & 1
     *                             = 0000 0001 & 1
     *                             = 1
     */
    private static final int SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        int[] rowSet = new int[SIZE];
        int[] colSet = new int[SIZE];
        int[] squareSet = new int[SIZE];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int val = board[i][j] - '0';
                int squareIdx = i / 3 * 3 + j / 3;

                if (((rowSet[i] >> val) & 1) == 1
                        || ((colSet[j] >> val) & 1) == 1
                        || ((squareSet[squareIdx] >> val) & 1) == 1) {
                    return false;
                }
                rowSet[i] |= (1 << val);
                colSet[j] |= (1 << val);
                squareSet[squareIdx] |= (1 << val);
            }
        }
        return true;
    }
}
// @lc code=end

/**
 * 
 * public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        Set seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String str = "(" + board[i][j] + ")";
                if (!seen.add(str + i) || !seen.add(j + str) || !seen.add(i / 3 + str + j / 3)) {
                    return false;
                }
            }
        }
        return true;
    }
 */

/**
 * Set<Character>[] rowSet = new HashSet[board.length];
        Set<Character>[] colSet = new HashSet[board.length];
        Set<Character>[] squareSet = new HashSet[board.length];

        for (int i = 0; i < board.length; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            squareSet[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet[i].contains(board[i][j])
                        || colSet[j].contains(board[i][j])
                        || squareSet[i / 3 * 3 + j / 3].contains(board[i][j])) {
                    return false;
                }
                rowSet[i].add(board[i][j]);
                colSet[j].add(board[i][j]);
                squareSet[i / 3 * 3 + j / 3].add(board[i][j]);
            }
        }
        return true;
    }
 */

 /**
  * 
  private final static int SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        int[] rowArr = new int[SIZE];
        int[] colArr = new int[SIZE];
        int[] squareArr = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int squareIndex = i / 3 * 3 + j / 3;
                int value = board[i][j] - '0';
                
                if (((rowArr[i] >> value) & 1) == 1
                    || ((colArr[j] >> value) & 1) == 1
                    || ((squareArr[squareIndex] >> value) & 1) == 1) {
                        return false;
                }
                rowArr[i] = rowArr[i] | (1 << value);
                colArr[j] = colArr[j] | (1 << value);
                squareArr[squareIndex] = squareArr[squareIndex] | (1 << value);
            }
        }

        return true;
    }
  */
