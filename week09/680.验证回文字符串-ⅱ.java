import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    /**
     * 需要注意 while(left++ < right--) 是不行的。
     * 滞后自增发生在left和right比较之后，所以比较麻烦，对应着传下去
     * 的不是isPalindrome(s, left + 1, right) 而是 left - 1，这是
     * 要让left回退到刚在的状态，然后在调用的这个函数里先做了 --right
     * 这就相当于是将右边的字符减了一个
     */
    public boolean validPalindrome(String s) {
        int left = -1;
        int right = s.length();

        while (++left < --right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left - 1, right) || isPalindrome(s, left, right + 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (++left < --right) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }
}
// @lc code=end

