import java.util.Stack;

/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    /**
     *  子串的末位 s[i] 要么是 '(', 要么是 ')'
     *  
     * 1.如果是 '('，那以它为结尾的子串一定不是有效括号子串，dp[i] = 0
     * 2.如果是 ')'，以它为结尾的子串有可能是有效括号子串，此时需要考察
     *   前一位 s[i-1]:
     *   1. s[i-1] 是 '('，那么它与s[i]组成了一对有效括号，子串长度保
     *      底为 2，此时需要继续考察 s[i-2]:
     *      1. s[i-2] 不存在，那么有效子串长度为 2: dp[i] = 2
     *      2. s[i-2] 存在，那么 dp[i]需要加上以 s[i-2 结尾的子串长度:
     *         dp[i] = dp[i-2] + 2
     *   2. s[i-1] 是 ')'，那么 s[i-1]和s[i]就是 "))"，说明s[i]前面已
     *      经有一组已经考察过的子串，且这个长度为 dp[i-1]，这时候我们跨
     *      过这个子串，看这组考察过的子串前面的一个字符，即 s[i-dp[i-1]-1]
     *      1. s[i-dp[i-1]-1]不存在，或为')'，那说明s[i]找不到匹配的左
     *         括号，直接 dp[i] = 0
     *      2. s[i-dp[i-1]-1]是 '('，与 s[i] 匹配，那么有效子串长度就为:
     *         (2 + 跨过的 dp[i-1] + 前方的 dp[i-dp[i-1]-2])
     *         
     *         1.dp[i-dp[i-1]-2]不存在, 那 dp[i] = 2 + dp[i-1]
     *         2.dp[i-dp[i-1]-2]存在, dp[i] = 2 + dp[i-1] + dp[i-dp[i-1]-2]
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
// @lc code=end

/**
 * 
 * public int longestValidParentheses(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                } else if (i - dp[i-1] > 0 
                        && s.charAt(i - dp[i-1] - 1) == '(') {
                    dp[i] = dp[i - 1] 
                                + ((i - dp[i-1]) >= 2 
                                    ? dp[i - dp[i-1] - 2] : 0) 
                                + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
 */

 /**
  *  stack

  public int longestValidParentheses(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
  */