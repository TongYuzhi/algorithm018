import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Collections.emptyList();
        }
        int len = nums.length;
        boolean[] isUsed = new boolean[len];
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, len, isUsed, path, res);

        return res;
    }

    private void dfs(int[] nums, int len, boolean[] isUsed, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            isUsed[i] = true;
            dfs(nums, len, isUsed, path, res);
            isUsed[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
// @lc code=end

/**
 * 
 * public List<List<Integer>> permuteUnique(int[] nums) { if (nums == null) {
 * return Collections.emptyList(); } List<List<Integer>> res = new
 * ArrayList<>(); List<Integer> path = new ArrayList<>();
 * 
 * Arrays.sort(nums);
 * 
 * int len = nums.length; boolean[] isUsed = new boolean[len];
 * 
 * dfs(nums, len, isUsed, path, res);
 * 
 * return res; }
 * 
 * private void dfs(int[] nums, int len, boolean[] isUsed, List<Integer> path,
 * List<List<Integer>> res) { //terminator if (path.size() == len) { res.add(new
 * ArrayList<>(path)); return; } //process curent logic for (int i = 0; i < len;
 * i++) { if (isUsed[i]) { continue; } if (i > 0 && nums[i] == nums[i - 1] &&
 * !isUsed[i - 1]) { continue; } path.add(nums[i]); isUsed[i] = true; //drill
 * down dfs(nums, len, isUsed, path, res); //reverse state isUsed[i] = false;
 * path.remove(path.size() - 1); } } }
 */
