import sun.reflect.generics.tree.Wildcard;

/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return reversePairsSub(nums, 0, nums.length - 1);
    }

    private int reversePairsSub(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        int mid = ((right - left) >> 1) + left;
        int res = reversePairsSub(nums, left, mid) + reversePairsSub(nums, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = 0;
        int r = mid + 1;
        int[] merged = new int[right - left + 1];

        while (i <= mid) {
            while (j <= right && nums[i] > 2L * nums[j]) j++;
            res += j - mid - 1;

            while (r <= right && nums[i] >= nums[r]) merged[k++] = nums[r++];
            merged[k++] = nums[i++];
        }
        while (r <= right) merged[k++] = nums[r++];

        System.arraycopy(merged, 0, nums, left, merged.length);

        return res;
    }
}
// @lc code=end

/**
 * 
 * public int reversePairs(int[] nums) {
        return reversePairsSub(nums, 0, nums.length - 1);
    }

    private int reversePairsSub(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = ((right - left) >> 1) + left;
        int res = reversePairsSub(nums, left, mid) + reversePairsSub(nums, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = 0;
        int p = mid + 1;
        int[] merged = new int[right - left + 1];

        while (i <= mid) {
            while (p <= right && nums[i] > 2L * nums[p]) p++;
            res += p - (mid + 1);

            while (j <= right && nums[i] >= nums[j]) merged[k++] = nums[j++];
            merged[k++] = nums[i++];
        }

        while (j <= right) merged[k++] = nums[j++];

        System.arraycopy(merged, 0, nums, left, merged.length);

        return res;
    }
 */
