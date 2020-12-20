import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=818 lang=java
 *
 * [818] 赛车
 */

// @lc code=start
class Solution {
    /**
     *  这是我这两个月以来做过最难受的dp, R.I.P
     *  @time: 2020-12-18
     * 
     *  position: 0 -> 1 -> 3 -> 7 -> 15
     *  speed:    1 -> 2 -> 4 -> 8 -> 16
     * 
     *  position的变化其实就是 2^n - 1，我们可做加减的
     *  数值也只有 2^n - 1
     * 
     *  现在要到达 target，有三种情况:
     *      1. target本身就是 2^n-1，那我们只需要n个A
     * 
     *      2. 我们走 n 步，越过 target，这时候我们再
     *         通过 R 回头，然后再走 (2^n - 1) - target
     *         往前走的距离是 2^n-1，需要n个A，回头需要1
     *         个R，然后还需要走的距离就是 (2^n-1-target),
     *         我们只需要再得到回头走的这段距离需要的步数
     * 
     *      3. 我们走 n 步，不越过 target，这时候我们就先
     *         回头，往回走一点，假设这时回头走了back的距离，
     *         back肯定是小于 2^n-1的，不然我们刚开始就白走
     *         了。但是要回头走多少呢？我们肯定没法直接决定
     *         出一个精确的数值，所以需要在这里循环，试往回
     *         走多少能用的步数最小。
     *         之前走了 n 步，然后又走了back，这时候距离target
     *         还剩 target - (2^n-1 - back) 要走。
     * 
     *  现在来考虑dp方程怎么写。
     *  我们假设dp[i]就等于 target = i时，需要的最小步数。
     * 
     *  对应的三种情况如下：
     *      1. i = 2^n - 1, 即走n步直接到达i
     *         dp[i] = n
     *      2. 先走 forward 步越过i,再回头
     *         根据上面的分析，我们需要回头走的距离是
     *         2^forward - 1 - i。
     *         dp[i] = min(dp[i], forward + 1 + dp[2^forward - 1 - i])
     *      3. 先走 forward 步，此时还没有到 i，直接先回头，
     *         走一段之后再回头向前走到达i。
     *         我们先回头走的距离是 2^back-1，然后再回头走到i的
     *         距离是 i - ((2^forward-1)-(2^back-1))
     *         dp[i] = min(dp[i], forward + back + dp[i - ((2^forward-1)-(2^back-1))])
     */ 
    public int racecar(int target) {
        if (target <= 0) {
            return 0;
        }
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= target; i++) {
            for (int forward = 1; (1 << forward) - 1 < (i << 1); forward++) {
                int forwardDistance = (1 << forward) - 1;
                if (forwardDistance == i) {
                    dp[i] = forward;
                } else if (forwardDistance > i) {
                    dp[i] = Math.min(dp[i], forward + 1 + dp[forwardDistance - i]);
                } else {
                    for (int backward = 0; backward < forward; backward++) {
                        int backwardDistance = (1 << backward) - 1;
                        dp[i] = Math.min(dp[i], backward + forward + 2 + dp[i - forwardDistance + backwardDistance]);
                    }
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

/**
 * public int racecar(int target) {
        if (target <= 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 1}); // position 0, speed 1

        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 1);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();

                if (cur[0] == target) {
                    return level;
                }

                int[] next = new int[] {cur[0] + cur[1], cur[1] << 1};
                String key = next[0] + " " + next[1];

                if (!visited.contains(key) && next[0] > 0 && next[0] < (target << 1)) {
                    queue.offer(next);
                    visited.add(key);
                }

                next = new int[] {cur[0], cur[1] > 0 ? -1 : 1};
                key = next[0] + " " + next[1];

                if (!visited.contains(key) &&  next[0] > 0 && next[0] < (target << 1)) {
                    queue.offer(next);
                    visited.add(key);
                }
            }
            level++;
        }
        return -1;
    }
 */

/**
 *  DP
 * 
 * public int racecar(int target) {
        //处理边界
        if (target <= 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= target; i++) {
            //先向前走 forward 步
            for (int forward = 1; (1 << forward) - 1 < (i << 1); forward++) {
                //向前走了forwardDistance
                int forwardDistance = (1 << forward) - 1;
                //对应第一种情况，走了forward步直接到达i
                if (forwardDistance == i) {
                    dp[i] = forward;
                } else if (forwardDistance > i) { //对应第二种情况，越过了i
                    // +1 是因为回头需要一个R指令
                    dp[i] = Math.min(dp[i], 
                            forward + 1 + dp[forwardDistance - i]);
                } else { //对应第三种情况，没有越过i
                    //先回头走backward步
                    for (int backward = 0; backward < forward; backward++) {
                        int backwardDistance = (1 << backward) - 1;
                        //第一个+1是还没到达i，先回头，使用一个R
                        //第二个+1是回头走了backwardDistance，再使用R回头走向i
                        dp[i] = Math.min(dp[i], 
                                forward + 1 + backward + 1 + dp[i - forwardDistance + backwardDistance]);
                    }
                }
            }
        }
        return dp[target];
    }
 */
