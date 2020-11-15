import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstaclsSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclsSet.add(obstacle[0] + " " + obstacle[1]);
        }
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // NOT ROW AND COLUMN!
        // I used to confused about this directions because
        // I think this is row and column in 2D matrix
        int x = 0;
        int y = 0;
        int direction = 0;
        int maxDistance = 0;

        for (int command : commands) {
            if (command == -2) {
                direction = (direction + 3) % 4;
            } else if (command == -1) {
                direction = (direction + 1) % 4;
            } else {
                int steps = 0;
                while (steps < command && !obstaclsSet.contains((x + directions[direction][0])
                                                                + " "
                                                                + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    steps++;
                }
            }
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }
        return maxDistance;
    }
}
// @lc code=end

/**
 * public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + " " + obstacle[1]);
        }
        // 0-North 1-East 2-South 3-West
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0;
        int y = 0;
        int direction = 0;
        int maxDistance = 0;

        for (int command : commands) {
            if (command == -1) { //turn right
                direction = (direction + 1) % 4; 
            } else if (command == -2) { //turn left
                direction = (direction + 3) % 4;
            } else { // move forward commands[i] steps
                int step = 0;
                while (step < command 
                    && !obstaclesSet.contains((x + directions[direction][0])
                                                + " " 
                                            + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
            }
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }
        return maxDistance;
    }
 */
