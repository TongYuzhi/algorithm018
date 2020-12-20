import java.lang.annotation.Retention;

/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    /**
     *  String is immutable,if use trim(),it will creat
     *  a new string.If we want not use extra space,we 
     *  can only use pointer to skip the spaces
     */
    public int myAtoi(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int idx = 0;
        int len = s.length();

        while (idx < len && s.charAt(idx) == ' ') idx++;

        int sign = 1;

        if (idx < len && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            sign = s.charAt(idx++) == '-' ? -1 : 1;
        }

        int total = 0;

        while (idx < len) {
            int digit = s.charAt(idx) - '0';

            if (digit < 0 || digit > 9) break;

            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE % 10 < digit && Integer.MAX_VALUE / 10 == total)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            idx++;
        }
        return total * sign;
    }
}
// @lc code=end

/**
 * public int myAtoi(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int idx = 0;

        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }

        int sign = 1;

        if (idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')) {
            sign = s.charAt(idx++) == '-' ? -1 : 1;
        }

        int total = 0;

        while (idx < s.length()) {
            int digit = s.charAt(idx) - '0';

            if (digit < 0 || digit > 9) break;

            if (Integer.MAX_VALUE / 10 < total 
                    || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            idx++;
        }
        return total * sign;
    }
 */
