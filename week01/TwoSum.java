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
        if (nums == null || nums.length < 1) {
            return new int[] {};
        }
        Map<Integer, Integer> record = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (record.containsKey(temp)) {
                ans[0] = record.get(temp);
                ans[1] = i;
                return ans;
            }
            record.put(nums[i], i);
        }
        return new int[] {};
    }
    //use double pointers also can slove it,but it is slower
}
// @lc code=end

