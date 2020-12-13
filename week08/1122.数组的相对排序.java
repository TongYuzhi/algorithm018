import java.util.function.BiConsumer;

import jdk.dynalink.internal.InternalTypeUtilities;
import sun.jvm.hotspot.debugger.amd64.AMD64ThreadContext;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2 == null || arr2.length < 1) {
            return new int[] {};
        }
        int maxNum = Integer.MIN_VALUE;

        for (int num : arr1) {
            maxNum = Math.max(maxNum, num);
        }

        int[] bucket = new int[maxNum + 1];

        for (int num : arr1) {
            bucket[num]++;
        }

        int index = 0;
        int[] res = new int[arr1.length];

        for (int num : arr2) {
            while (bucket[num]-- > 0) {
                res[index++] = num;
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                res[index++] = i;
            }
        }
        return res;
    }
}
// @lc code=end

/**
 * public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2 == null || arr2.length < 1) {
            return new int[] {};
        }
        int maxNum = Integer.MIN_VALUE;
        for (int num : arr1) {
            maxNum = Math.max(maxNum, num);
        }
        int[] bucket = new int[maxNum + 1];

        for (int num : arr1) {
            bucket[num]++;
        }

        int index = 0;
        int[] res = new int[arr1.length];
        for (int num : arr2) {
            while (bucket[num]-- > 0) {
                res[index++] = num;
            }
        }

        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                res[index++] = i;
            }
        }
        return res;
    }
 */
