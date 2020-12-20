import org.graalvm.compiler.nodes.calc.LeftShiftNode;

import sun.jvm.hotspot.debugger.cdbg.RefType;
import sun.rmi.log.ReliableLog.LogFile;

/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(reverse(word)).append(" ");
        }
        return sb.toString().trim();
    }

    private String reverse(String word) {
        char[] words = word.toCharArray();
        int left = 0;
        int right = words.length - 1;

        while (left < right) {
            char tmp = words[left];
            words[left++] = words[right];
            words[right--] = tmp;
        }
        return new String(words);
    }
}
// @lc code=end

/**
 * 
 * 
 * 
 * public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            res.append(reverse(str.toCharArray())).append(" ");
        }
        return res.toString().trim();
    }

    private String reverse(char[] chs) {
        int left = 0;
        int right = chs.length - 1;

        while (left < right) {
            char tmp = chs[left];
            chs[left++] = chs[right];
            chs[right--] = tmp;
        }
        return String.valueOf(chs);
    }
 */
