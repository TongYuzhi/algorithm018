import java.beans.beancontext.BeanContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import javax.management.Query;

import jdk.internal.vm.compiler.word.WordBase;
import sun.awt.www.content.audio.basic;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    private int minChange = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        char[][] banks = new char[bank.length][];

        for (int i = 0; i < bank.length; i++) {
            banks[i] = bank[i].toCharArray();
        }

        dfs(start.toCharArray(), end.toCharArray(), banks, 0);

        return minChange == Integer.MAX_VALUE ? -1 : minChange;
    }

    private void dfs(char[] start, char[] end, char[][] bank, int change) {
        if (Arrays.equals(start, end)) {
            minChange = Math.min(change, minChange);
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            char[] piece = bank[i];
            if (piece == null) {
                continue;
            }
            int diffrent = 0;
            for (int j = 0; j < piece.length; j++) {
                if (piece[j] != start[j]) {
                    if (++diffrent > 1) {
                        break;
                    }
                }
            }
            if (diffrent == 1) {
                bank[i] = null;
                dfs(piece, end, bank, change + 1); 
                bank[i] = piece;
            }
        }
    }
}
// @lc code=end


/**
 *  approach 1 DFS
 * 
 * private int minChange = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        char[][] banks = new char[bank.length][8];
        for (int i = 0; i < bank.length; i++) {
            banks[i] = bank[i].toCharArray();
        }
        dfs(start.toCharArray(), end.toCharArray(), banks, 0);

        return minChange == Integer.MAX_VALUE ? -1 : minChange;
    }

    private void dfs(char[] start, char[] end, char[][] bank, int change) {
        if (Arrays.equals(start, end)) {
            minChange = Math.min(change, minChange);
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            char[] piece = bank[i];
            if (piece == null) {
                continue;
            }
            int diffrent = 0;
            for (int j = 0; j < start.length; j++) {
                if (start[j] != piece[j]) {
                    if (++diffrent > 1) {
                        break;
                    }
                }
            }
            if (diffrent == 1) {
                bank[i] = null;
                dfs(piece, end, bank, change + 1);
                bank[i] = piece;
            }
        }
    }
 */

 /**
  *  BFS

  public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        char[] basicGroup = new char[] {'A', 'C', 'G', 'T'};

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curStr = queue.poll();
                if (curStr.equals(end)) {
                    return level;
                }

                char[] curArray = curStr.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (char ch : basicGroup) {
                        curArray[i] = ch;
                        String next = String.valueOf(curArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
  */
