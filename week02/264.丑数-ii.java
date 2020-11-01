import java.util.List;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] uglyNumbers = new int[n];

        uglyNumbers[0] = 1;

        for (int i = 1; i < uglyNumbers.length; i++) {
            uglyNumbers[i] = Math.min(uglyNumbers[index2] * 2, Math.min(uglyNumbers[index3] * 3, uglyNumbers[index5] * 5));
            if (uglyNumbers[i] == uglyNumbers[index2] * 2) index2++;
            if (uglyNumbers[i] == uglyNumbers[index3] * 3) index3++;
            if (uglyNumbers[i] == uglyNumbers[index5] * 5) index5++;
        }
        return uglyNumbers[n-1];
    }
}
// @lc code=end

