/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[index] = nums[j];
                if (index != j) {
                    nums[j] = 0;
                }
                index++;
            }
        }
    }
}
// @lc code=end

/**
 * int index = 0; //recoid the next anti-zero position

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (i != index) {
                    nums[i] = 0;
                }
                index++;
            }
        }
 */
