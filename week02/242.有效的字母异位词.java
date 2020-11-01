import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] strOne = s.toCharArray();
        char[] strTwo = t.toCharArray();

        Arrays.sort(strOne);
        Arrays.sort(strTwo);

        return Arrays.equals(strOne, strTwo);
    }
}
// @lc code=end

/**     approch 1 use sort
 *   
 *    if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] charsOne = s.toCharArray();
        char[] charsTwo = t.toCharArray();

        Arrays.sort(charsOne);
        Arrays.sort(charsTwo);

        return Arrays.equals(charsOne, charsTwo);
 */
