import java.lang.reflect.Array;
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
        char[] chsOne = s.toCharArray();
        char[] chsTwo = t.toCharArray();

        Arrays.sort(chsOne);
        Arrays.sort(chsTwo);

        return Arrays.equals(chsOne, chsTwo);
    }
}
// @lc code=end

/**
 * hash table
 * 
 * public boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] bucket = new int[26];
        char[] charsOne = s.toCharArray();
        char[] charsTwo = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            bucket[charsOne[i] - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (--bucket[charsTwo[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
 */

/**
 *  api sort
 * 
 * if (s.equals(t)) {
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
 */
