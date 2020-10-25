/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        k = k % len;

        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        int temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
// @lc code=end

/**
 * approch 2 Brute Rotate
 * 
 * public void rotate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            int value = nums[len - 1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = value;
        }
    }
 */
