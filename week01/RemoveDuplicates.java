/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int val : nums) {
            if (i == 0 || val > nums[i-1]) {
                nums[i++] = val;
            }
        }
        return i;
    }
}
// @lc code=end

