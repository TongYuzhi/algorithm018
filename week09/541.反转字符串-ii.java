/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    /**
     *  我可能是个🐖吧，判断半天条件
     *  @time: 2020-12-19
     * 
     *  直接从所有2k的位置开始反转
     */
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chs = s.toCharArray();

        for (int i = 0; i < len; i += (k << 1)) {
            int left = i;
            int right = Math.min(len - 1, i + k - 1);
            reverse(chs, left, right);
        }
        return new String(chs);
    }

    private void reverse(char[] chs, int left, int right) {
        while (left < right) {
            char temp = chs[left];
            chs[left++] = chs[right];
            chs[right--] = temp;
        }
    }
}
// @lc code=end

/**
 * 
 * public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chs = s.toCharArray();

        for (int i = 0; i < len; i += (k << 1)) {
            int start = i;
            int end = Math.min(i + k - 1, len - 1);
            reverse(chs, start, end);
        }
        return new String(chs);
    }

    private void reverse(char[] chs, int start, int end) {
        while (start < end) {
            char temp = chs[start];
            chs[start++] = chs[end];
            chs[end--] = temp;
        }
    }
 */