/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    /**
     *  dp[i] 表示以 s[i] 结尾的前缀子串有多少种解码方法
     * 
     *  dp[i] = dp[i-1]  if s[i] != '0'
     *  dp[i] += dp[i-2]  if 1 <= s[i-1]s[i] <= 26
     * 
     *  如果s[i] != '0'，s[i]就可以单独解码，单独解码并
     *  不增加解码方法数: dp[i] = dp[i-1]
     *  
     *  然后我们再判断s[i] 和 s[i-1] 组合的数字是否合法，
     *  如果合法，说明 s[i] s[i-1]两位也可以作为一种新的
     *  解码方法存在，所以 dp[i] += dp[i-2]
     */
    public int numDecodings(String s) {
        if (s == null || s.length() < 1 || s.charAt(0) == '0') {
            return 0;
        }

        int len = s.length();
        char[] chs = s.toCharArray();

        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (chs[i] != '0') {
                dp[i] = dp[i-1];
            }
            int sum = (chs[i-1] - '0') * 10 + (chs[i] - '0');

            if (sum >= 10 && sum <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[len-1];
    }
}
// @lc code=end

/**
 * 
 * public int numDecodings(String s) {
        if (s == null || s.length() < 1 || s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];

        dp[0] = 1;

        char[] charArray = s.toCharArray();

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i-1];
            }
            int num = 10 * (charArray[i-1] - '0') + (charArray[i] - '0');

            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[len-1];
    }
 */