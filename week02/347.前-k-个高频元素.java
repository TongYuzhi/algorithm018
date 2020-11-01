import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[] {};
        }
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1); //count the frequency
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return count.get(o1) - count.get(o2); 
            }
        });

        for (int key : count.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else if (count.get(key) > count.get(heap.peek())) {
                heap.remove();
                heap.add(key);
            }
        }
        int[] ans = new int[k];
        int index = k - 1;

        while (!heap.isEmpty()) {
            ans[index--] = heap.poll();
        }
        return ans;
    }
}
// @lc code=end

