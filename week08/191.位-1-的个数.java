/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }
}
// @lc code=end

/**
 *  懒蛋法
 * 
 * public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
 */

/**
 *  移动1的个数次
 * 
 * public int hammingWeight(int n) {
        int bits = 0;

        while (n != 0) {
            bits++;
            n &= (n - 1);
        }
        return bits;
    }
 */

/**
 *  移动32次
 * 
 * public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }
 */
