/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    /**
     *  2 : 10  4 : 100  8 : 1000
     *  3 : 11  5 : 101  9 : 1001
     * 
     *  偶数的1的个数和偶数/2 的1的个数是相同的
     *  奇数的1的个数就是上一个数再加1，因为就是
     *  大了最后一位1
     *  因此可以写出递推公式：
     *  dp[i] = dp[i-1] + 1  if (i & 1) == 1
     *  dp[i] = dp[i>>1]     if (i & 1) == 0
     * 
     *  另一个思考方式是，i 和 i >> 1 只有一位不同，
     *  i >> 1 是 i 移除一位的结果，因此也可以写作：
     *  dp[i] = dp[i>>1] + (i & 1)
     * 
     *  还有一种方法，就是根据最后设置位
     *  x & (x-1) 可以将最后一位1置为0，所以可以得到：
     *  dp[i] = dp[x & (x-1)] + 1
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i-1)] + 1;
        }
        return res;
    }
}
// @lc code=end

/**
 * public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
 */

/**
 * 
 * public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = res[i>>1] + (i & 1);
        }
        return res;
    }
 */

/**
 * 
 * public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            res[i] = ((i & 1) == 0) ? res[i >> 1] : (res[i - 1] + 1);
        }
        return res;
    }
 */