import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    /**
     *  这个题是要判断两个字符串的字符是否能互相成为映射，且是单映射
     *  
     *  除了哈希表，还可以通过判断字符上一次出现的位置是否相同
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (preIndexOfS[s.charAt(i)] != preIndexOfT[t.charAt(i)]) {
                return false;
            }
            preIndexOfS[s.charAt(i)] = i + 1;
            preIndexOfT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
// @lc code=end

/** 
 *  use containsValue(), it will cost O(n) time
 * 
 * public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (!map.containsValue(ch2)) {
                    map.put(ch1, ch2);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
 */

/**
 *  public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map.containsKey(ch1)) {
                if (map.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (set.contains(ch2)) return false;
                map.put(ch1, ch2);
                set.add(ch2);
            }
        }
        return true;
    }
 */