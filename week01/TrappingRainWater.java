import java.util.Deque;
import java.util.LinkedList;

import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration.Hidden;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    // approch 3   double pointers
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int ans = 0;

        while (left < right && height[left] <= height[left + 1]) left++;
        while (left < right && height[right] <= height[right - 1]) right--;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            if (leftHeight <= rightHeight) {
                while (left < right && leftHeight >= height[++left]) {
                    ans += leftHeight - height[left];
                }
            } else {
                while (left < right && rightHeight >= height[--right]) {
                    ans += rightHeight - height[right];
                }
            }
        }
        return ans;
    }
}
// @lc code=end

/**
 *      approch 1 brute
 * 
 *    public int trap(int[] height) {
        int ans = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            int maxRight = 0;

            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }
 */

 /**
  *     approch 2 Dynamic Programing

  public int trap(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int len = height.length;

        int[] largeFromLeft = new int[len];
        int[] largeFromRight = new int[len];

        largeFromLeft[0] = height[0];
        largeFromRight[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            largeFromLeft[i] = Math.max(height[i], largeFromLeft[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            largeFromRight[i] = Math.max(height[i], largeFromRight[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(largeFromLeft[i], largeFromRight[i]) - height[i];
        }
        return ans;
    }
  */

  /**
   *    approch 3 double pointers
   * 
   * public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int ans = 0;

        while (left < right && height[left] <= height[left + 1]) left++;
        while (left < right && height[right] <= height[right - 1]) right--;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            if (leftHeight <= rightHeight) {
                while (left < right && leftHeight >= height[++left]) {
                    ans += leftHeight - height[left];
                }
            } else {
                while (left < right && rightHeight >= height[--right]) {
                    ans += rightHeight - height[right];
                }
            }
        }
        return ans;
    }
   */