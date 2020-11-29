/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    /**
     * 规则：不能抢连续两家
     * 
     * 基本思路，标记当前家是抢了还是不抢
     * dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0]);
     * dp[i][1] = dp[i-1][0] + nums[i];
     * 如果这家不抢，那当前金额就是上一家抢或不抢的最大值
     * 如果这家抢，那值只能从上一家没抢的状态中来。
     * 
     * 进一步，我们可以优化空间消耗，只用一维数组来记录状态
     * dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
     * 如果第i个房子要偷，那状态只能从第i-2个房子的最大值过来，
     * 如果第i个房子不偷，那状态就可以从i-1个房子转移过来。
     * 
     * 再进一步，我们发现递推的时候其实只需要dp[i-1]和dp[i-2]
     * 两个值，所以我们可以只用两个值来递推，不需要数组了。
     */
    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = pre;
            pre = cur;
            cur = Math.max(temp + nums[i], cur);
        }
        return cur;
    }
}
// @lc code=end

/**
 *  space complexity: O(1)
 * 
 * public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;

        for (int num : nums) {
            int tmp = pre;
            pre = cur;
            cur = Math.max(cur, tmp + num);
        }
        return cur;
    }
 */

/**
 *  space complexity: O(n)
 * 
 * public int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len == 0 ? 0 : nums[0];
        }

        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[len-1];
    }
 */

/**
 * space complexity: O(n^2)
 * 
 * public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        return Math.max(dp[len-1][0], dp[len-1][1]);
    }
 */
