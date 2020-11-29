/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    /**
     * 思路和打家劫舍Ⅰ一样，分成两种情况，要么不偷第一家，
     * 要么不偷最后一家，最后求两种情况的最大值
     */
    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 1 ? nums[0] : 0;
        }
        int len = nums.length;
        return Math.max(rob(nums, 0, len-1), rob(nums, 1, len));
    }

    private int rob(int[] nums, int start, int end) {
        int pre = 0;
        int cur = 0;
        for (int i = start; i < end; i++) {
            int temp = pre;
            pre = cur;
            cur = Math.max(cur, temp + nums[i]);
        }
        return cur;
    }
}
// @lc code=end

/**
 * public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;

        return Math.max(rob(nums, 0, len-1), rob(nums, 1, len));
    }

    private int rob(int[] nums, int start, int end) {
        int pre = 0;
        int cur = 0;

        for (int i = start; i < end; i++) {
            int tmp = pre;
            pre = cur;
            cur = Math.max(tmp + nums[i], cur);
        }
        return cur;
    }
 */
