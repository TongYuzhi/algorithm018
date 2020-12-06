import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();

        dfs(0, 0, n, "", res);

        return res;
    }

    private void dfs(int left, int right, int n, String str, List<String> res) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left < n) dfs(left + 1, right, n, str + "(", res);
        if (right < left) dfs(left, right + 1, n, str + ")", res);
    }
}
// @lc code=end

