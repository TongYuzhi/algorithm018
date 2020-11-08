import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.graalvm.compiler.asm.sparc.SPARCAssembler.Br;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k || k <= 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(1, n, k, path, res);
        return res;
    }

    private void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (0 == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (begin > n - k + 1) {
            return;
        }
        dfs(begin + 1, n, k, path, res); //not pick
        path.addLast(begin);
        dfs(begin + 1, n, k - 1, path, res); //pick this
        path.removeLast();
    }
}
// @lc code=end

/**
 * 
 * public List<List<Integer>> combine(int n, int k) { List<List<Integer>> res =
 * new ArrayList<>(); if (n < k || k <= 0) { return res; } Deque<Integer> path =
 * new ArrayDeque<>(); dfs(1, n, k, path, res);
 * 
 * return res; }
 * 
 * private void dfs(int begin, int n, int k, Deque<Integer> path,
 * List<List<Integer>> res) { if (k == 0) { res.add(new ArrayList<>(path));
 * return; } if (begin > n - k + 1) { return; } dfs(begin + 1, n, k, path, res);
 * path.addLast(begin); dfs(begin + 1, n, k - 1, path, res); path.removeLast();
 * }
 */
