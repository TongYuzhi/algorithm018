import java.util.Stack;

import jdk.nashorn.internal.runtime.WithObject;

/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                stack.push(S.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                sb.append(stack.pop());
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

/**
 * public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);

        for (int i = 0, j = S.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetter(S.charAt(i))) i++;
            while (i < j && !Character.isLetter(S.charAt(j))) j--;
            if (i < j) {
                sb.setCharAt(i, S.charAt(j));
                sb.setCharAt(j, S.charAt(i));
            }
        }
        return sb.toString();
    }
 */

/**
 *  Stack
 * 
 * public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                stack.push(S.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                sb.append(stack.pop());
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
 * 
 */

/**
 * 
 * public String reverseOnlyLetters(String S) {
        char[] chs = S.toCharArray();
        int start = 0;
        int end = S.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetter(chs[start])) {
                start++;
            }
            while (start < end && !Character.isLetter(chs[end])) {
                end--;
            }
            if (start < end) {
                char temp = chs[start];
                chs[start++] = chs[end];
                chs[end--] = temp;
            }
        }
        return new String(chs);
    }
 */