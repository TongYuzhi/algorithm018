import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    /** approach 1
     *  spilt(" +") 可以分开多个空格
     * 
     *  approach 2
     *  先reverse整个字符串, 再逐个单词reverse
     *  a good example
     *  -> elpmaxe doog a
     *  -> example good a
     */
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
// @lc code=end

/**
 * public String reverseWords(String s) {
        char[] words = reverse(s.toCharArray(), 0, s.length() - 1);

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            if (words[i] != ' ') {
                words[end++] = words[i];
            } else if (i > 0 && words[i-1] != ' ') {
                reverse(words, start, end - 1);
                words[end++] = ' ';
                start = end;
            }
        }
        reverse(words, start, end - 1);

        return new String(words, 0, end > 0 && words[end - 1] == ' ' ? end - 1 : end);
    }

    private char[] reverse(char[] word, int start, int end) {
        while (start < end) {
            char temp = word[start];
            word[start++] = word[end];
            word[end--] = temp;
        }
        return word;
    }
 */

/**
 * public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
 */
