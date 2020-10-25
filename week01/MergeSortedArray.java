import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tailOne = m - 1;
        int tailTwo = n - 1;
        int mainTail = m + n - 1;

        while (tailOne >= 0 && tailTwo >= 0) {
            nums1[mainTail--] = nums1[tailOne] > nums2[tailTwo] 
                                ? nums1[tailOne--] : nums2[tailTwo--];
        }
        while (tailTwo >= 0) {
            nums1[mainTail--] = nums2[tailTwo--];
        }
    }
}
// @lc code=end

/** approch 2 I think it can't be writed in the interview 
 * 
 *  public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
 */
