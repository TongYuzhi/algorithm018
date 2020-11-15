import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) {
            return 0;
        }
        int len = ratings.length;
        int[] count = new int[len]; //time / space O(n)

        Arrays.fill(count, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                count[i] = count[i-1] + 1;
            }
        }
        int sum = count[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                count[i] = Math.max(count[i], count[i+1] + 1);
            }
            sum += count[i];
        }
        return sum;
    }
}
// @lc code=end

/**
 * public int candy(int[] ratings) {
        if (ratings == null || ratings.length < 1) {
            return 0;
        }
        int len = ratings.length;
        int[] comparedWithLeft = new int[len];
        int[] comparedWithRight = new int[len];

        Arrays.fill(comparedWithLeft, 1);
        Arrays.fill(comparedWithRight, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                comparedWithLeft[i] = comparedWithLeft[i-1] + 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                comparedWithRight[i] = comparedWithRight[i+1] + 1;
            }
        }
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += Math.max(comparedWithLeft[i], comparedWithRight[i]);
        }
        return sum;
    }
 */
