import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.text.rtf.RTFEditorKit;

import sun.tools.tree.LessExpression;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1 || intervals[0].length < 1) {
            return new int[][] {};
        }
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];

            if (res.isEmpty() || res.get(res.size() - 1)[1] < left) {
                res.add(interval);;
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end

/**
 * public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return new int[][] {};
        }
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (list.isEmpty() || list.get(list.size() - 1)[1] < left) {
                list.add(intervals[i]);
            } else {
                list.get(list.size() - 1)[1] = Math.max(right, list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
 */
