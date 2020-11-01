import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        int[] ans = new int[2];
        Map<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (table.containsKey(temp)) {
                ans[0] = table.get(temp);
                ans[1] = i;
                return ans;
            }
            table.put(nums[i], i);
        }
        return ans;
    }
}
// @lc code=end

/**
 *  approch 1 hashmap
 * 
 * public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        Map<Integer, Integer> table = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target-nums[i])) {
                ans[0] = table.get(target-nums[i]);        
                ans[1] = i;
                return ans;
            }
            table.put(nums[i], i);
        }
        return new int[] {};
    }
}
 */

 /**
  *     approch 2 two pointers

  public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        int[] copyArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyArr);

        int[] ans = new int[2];
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = copyArr[left] + copyArr[right];
            if (sum == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (copyArr[ans[0]] == nums[i]) {
                ans[0] = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (copyArr[ans[1]] == nums[i]) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
  */
