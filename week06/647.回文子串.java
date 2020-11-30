/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    /**
     *  1. DP
     *  dp[i][j] 表示在区间[i, j]的子串是否是一个回文串
     *  
     *  当只有一个字符时，比如 a，是一个回文串
     * 
     *  当有两个字符时，比如 aa，是一个回文串
     * 
     *  当有三个及以上的字符时，比如 ababa，这时候我们可以将两头
     *  去掉，看 bab这个子串，如果它是一个回文串，那 ababa 也是
     * 
     *  因此，在 s[i] == s[j] 时，我们还需要考察 dp[i+1][j-1]。
     * 
     *  2. 中心扩展法
     *  比如 ababa，选择最中间的 a 作为中心点，往两边扩散，第一次
     *  扩散后，left 指向 b，right 指向 b，这就得到了一个回文串。
     *  但是除了得到奇数的回文串，我们还要得到像 aaa 中的 aa 这样
     *  的偶数回文串，所以中心点不能只是单个字符，我们要得到abab，
     *  可以由中心点 ba 直接扩展得到。因此，中心点共有 2 * len - 1个。
     * 
     *  abba 共有 7 个中心点: a,b,b,a,ab,bb,ba
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length();
        int res = 0;
        char[] chs = s.toCharArray();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                while (left >= 0 && right < len && chs[left--] == chs[right++]) {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

/** 
 *  dp
 * 
 * public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length();
        int res = 0;
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if (chs[i] == chs[j] && (j - i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
 */

/**
 * 
 * public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int res = 0;
        int len = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 1; j++) { 
                int l = i;
                int r = i + j;
                while (l >= 0 && r < len && chars[l--] == chars[r++]) {
                    res++;
                }
            }
        }
        return res;
    }
 */
