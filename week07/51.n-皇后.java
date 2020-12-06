import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.jvm.hotspot.gc.shared.CollectedHeap;
import sun.security.provider.DSAKeyFactory;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        Set<Integer> columns = new HashSet<>();
        Set<Integer> leDiagonals = new HashSet<>();
        Set<Integer> riDiagonals = new HashSet<>();
        
        List<List<String>> res = new ArrayList<>();

        solveNQueens(n, queens, 0, res, columns, leDiagonals, riDiagonals);

        return res;
    }

    private void solveNQueens(int n, int[] queens, int row,
                                List<List<String>> res, 
                                Set<Integer> columns,
                                Set<Integer> leDiagonals,
                                Set<Integer> riDiagonals) {
        if (row == n) {
            List<String> board = piant(n, queens);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            int leDiagonal = row + i;
            int riDiagonal = row - i;
            if (leDiagonals.contains(leDiagonal)) {
                continue;
            }
            if (riDiagonals.contains(riDiagonal)) {
                continue;
            }
            queens[row] = i;
            columns.add(i);
            leDiagonals.add(leDiagonal);
            riDiagonals.add(riDiagonal);
            solveNQueens(n, queens, row + 1, res, columns, leDiagonals, riDiagonals);
            queens[row] = -1;
            columns.remove(i);
            leDiagonals.remove(leDiagonal);
            riDiagonals.remove(riDiagonal);
        }
    }

    private List<String> piant(int n, int[] queens) {
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(String.valueOf(row));
        }
        return board;
    }
}
// @lc code=end

/**
 * 
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }
        int[] queens = new int[n];
        Arrays.fill(queens, -1);

        Set<Integer> colums = new HashSet<>();
        Set<Integer> leDiagonals = new HashSet<>();
        Set<Integer> riDiagonals = new HashSet<>();

        List<List<String>> res = new ArrayList<>();

        solveNQueens(queens, n, 0, res, colums, leDiagonals, riDiagonals);

        return res;
    }

    private void solveNQueens(int[] queens, int n, int row,
                                List<List<String>> res,
                                Set<Integer> colums,
                                Set<Integer> leDiagonals,
                                Set<Integer> riDiagonals) {
        if (row == n) {
            List<String> board = piant(queens, n);
            res.add(board);
        }
        for (int i = 0; i < n; i++) {
            if (colums.contains(i)) {
                continue;
            }
            int leDiagonal = row - i;
            int riDiagonal = row + i;

            if (leDiagonals.contains(leDiagonal)) {
                continue;
            }
            if (riDiagonals.contains(riDiagonal)) {
                continue;
            }
            queens[row] = i;
            colums.add(i);
            leDiagonals.add(leDiagonal);
            riDiagonals.add(riDiagonal);
            solveNQueens(queens, n, row + 1, res, colums, leDiagonals, riDiagonals);
            queens[row] = -1;
            colums.remove(i);
            leDiagonals.remove(leDiagonal);
            riDiagonals.remove(riDiagonal);
        }
    }

    private List<String> piant(int[] queens, int n) {
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(String.valueOf(row));
        }
        return board;
    }
 */
