import org.graalvm.compiler.core.amd64.AMD64ArithmeticLIRGenerator.Maths;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int reachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= reachable) {
                reachable = i;
            }
        }
        return reachable == 0;
    }
}
// @lc code=end

/**
 *  public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > distance) {
                return false;
            }
            distance = Math.max(distance, i + nums[i]);
        }
        return true;
    }
 */

/**
 *  approach 1 greedy
 * 
 * int reachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= reachable) {
                reachable = i;
            }
        }
        return reachable == 0;
 */
