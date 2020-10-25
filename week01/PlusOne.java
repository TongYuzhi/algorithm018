import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int sum = 0;
        int abdicate = 0;
        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            carry = sum / 10;
            abdicate = sum % 10;
            digits[i] = abdicate;
        }
        if (carry != 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
// @lc code=end
