/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    //暴力将每个点都当作是中心点，然后两边扩，如果符合
    //回文串的条件，回文子串数 +1；
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int res = 0;
        int len = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 1; j++) { //j=0 为奇数中心点
                int l = i;
                int r = i + j;
                while (l >= 0 && r < len && chars[l--] == chars[r++]) {
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

