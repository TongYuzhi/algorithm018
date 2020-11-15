/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            }
            //here must to be nums[mid] >= nums[left],not '>'
            //because when array length is even,we always get
            //left value.
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

/**
 *  recursive
 * 
 * public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = ((right - left) >> 1) + left;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            int poistion = binarySearch(nums, target, left, mid - 1);
            if (poistion == -1) {
                poistion = binarySearch(nums, target, mid + 1, right);
            }
            return poistion;
        } else {
            int poistion = binarySearch(nums, target, mid + 1, right);
            if (poistion == -1) {
                poistion = binarySearch(nums, target, left, mid - 1);
            }
            return poistion;
        }
    }
 */

 /**
  *  iterative

  public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
  */