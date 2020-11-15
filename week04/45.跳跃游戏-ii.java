/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int end = 0;
        int steps = 0;
        int maxPosition = 0;

        //[0, nums.length - 2]
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                steps++;
                end = maxPosition;
            }
        }
        return steps;
    }
}
// @lc code=end

/**
 * public int jump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int end = 0;
        int steps = 0;
        int maxPosition = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
 */
