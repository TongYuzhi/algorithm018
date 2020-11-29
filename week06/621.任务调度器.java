import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    /**
     *  相同任务之间必须有 n 单位的冷却，所以我们根据任务的数量
     *  来安排顺序，任务出现得越多，就越早安排。
     * 
     *  比如 A,B,C,D,E, 对应的数量分别为 6，1，1，1，1，冷却时
     *  间为 2，那么我们先安排 A，再安排 B,C，刚好A的冷却时间结
     *  束，可以进行下一轮对A的安排。
     * 
     *  由此，我们设定 n + 1 个任务为一轮，每轮中，我们按照任务
     *  数量进行降序安排。
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length < 1) {
            return 0;
        }
        int[] bucket = new int[26];

        for (char ch : tasks) {
            bucket[ch - 'A']++;
        }
        Arrays.sort(bucket);

        int time = 0;

        while (bucket[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (bucket[25] == 0) {
                    break;
                }
                if (i < 26 && bucket[25 - i] > 0) {
                    bucket[25 - i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(bucket);
        }
        return time;
    }
}
// @lc code=end

