/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start

//f(n) = f(n-1) + f(n-2)
class Solution {
    public int climbStairs(int n) {
        int[] record = new int[n + 1];

        return climbStairs(0, n, record);
    }

    private int climbStairs(int level, int n, int[] record) {
        if (level > n) {
            return 0;
        }
        if (level == n) {
            return 1;
        }
        if (record[level] > 0) {
            return record[level];
        }
        return record[level] = climbStairs(level + 1, n, record)
                                + climbStairs(level + 2, n, record);
    }
}
// @lc code=end

/**
 *  recursive
 * 
 * public int climbStairs(int n) {
        int[] record = new int[n + 1];

        return climbStairs(0, n, record);
    }

    private int climbStairs(int level, int n, int[] record) {
        if (level > n) {
            return 0;
        }
        if (level == n) {
            return 1;
        }
        if (record[level] > 0) {
            return record[level];
        }
        record[level] = climbStairs(level + 1, n, record)
                        + climbStairs(level + 2, n, record);
        return record[level];
    }
 */

/**
 *  dynamic programming
 * 
 * if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }

        int f1 = 1;
        int f2 = 2;
        int f3 = 3;

        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
 */
