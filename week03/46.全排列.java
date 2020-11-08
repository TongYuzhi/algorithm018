import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.jvm.hotspot.gc.shared.CollectedHeap;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }
        int len = nums.length;
        boolean[] isUsed = new boolean[len];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, isUsed, len, path, res);

        return res;
    }

    private void dfs(int[] nums, boolean[] isUsed, int len, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            if (!isUsed[i]) {
                path.add(nums[i]);
                isUsed[i] = true;
                dfs(nums, isUsed, len, path, res);
                isUsed[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end

/**
 * 
 * public List<List<Integer>> permute(int[] nums) { if (nums == null ||
 * nums.length < 1) { return Collections.emptyList(); } int len = nums.length;
 * boolean[] isUsed = new boolean[len]; List<Integer> path = new ArrayList<>();
 * List<List<Integer>> res = new ArrayList<>();
 * 
 * dfs(nums, len, 0, isUsed, path, res);
 * 
 * return res; }
 * 
 * private void dfs(int[] nums, int len, int depth, boolean[] isUsed,
 * List<Integer> path, List<List<Integer>> res) { if (depth == len) {
 * res.add(new ArrayList<>(path)); return; } for (int i = 0; i < len; i++) { if
 * (!isUsed[i]) { path.add(nums[i]); isUsed[i] = true; dfs(nums, len, depth + 1,
 * isUsed, path, res); isUsed[i] = false; path.remove(path.size() - 1); } } }
 */
