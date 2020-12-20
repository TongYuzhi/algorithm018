import javax.swing.text.Style;

import org.graalvm.compiler.lir.StandardOp.SaveRegistersOp;

import sun.jvm.hotspot.oops.RetData;

/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    /**
     * dp[i][j] 表示字符串 i 到 j 是不是一个回文串
     * 
     * if i -j = 0   dp[i][j] = true
     * if i - j = 1  dp[i][j] = s[i] == s[j]
     * if i - j > 1  dp[i][j] = s[i] == s[j] && dp[i+1][j-1]
     */

    int start = 0;
    int maxLen = 1;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            extendFromCenter(s.toCharArray(), i, i);
            extendFromCenter(s.toCharArray(), i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void extendFromCenter(char[] chs, int i, int j) {
        while (i >= 0 && j < chs.length && chs[i] == chs[j]) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            maxLen = j - i - 1;
            start = i + 1;
        }
    }
}
// @lc code=end

/**
 * 
 *  中心扩散
 * 
 * private int start;
    private int maxLen;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        maxLen = 1;
        int len = s.length();
        for (int i = 0; i < len-1; i++) {
            extendFromCenter(s.toCharArray(), i, i);
            extendFromCenter(s.toCharArray(), i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void extendFromCenter(char[] chs, int i, int j) {
        while (i >= 0 && j < chs.length && chs[i] == chs[j]) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            maxLen = j - i - 1;
            start = i + 1;
        }
    }
 */

/**
 *  最外层循环用 l (j和i的差值) 来循环  DP
 * 
 * public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int len = s.length();
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[len][len];

        String res = "";

        for (int l = 0; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = chs[i] == chs[j];
                } else {
                    dp[i][j] = chs[i] == chs[j] && dp[i+1][j-1];
                }
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
 */
