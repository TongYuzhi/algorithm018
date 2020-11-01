import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.print.DocFlavor.STRING;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return Collections.emptyList();
        }
        Map<String, List<String>> table = new HashMap<>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs); //every anagram has same sorted array
            String key = String.valueOf(chs);
            if (!table.containsKey(key)) {
                table.put(key, new ArrayList<>());
            }
            table.get(key).add(str);
        }
        return new ArrayList<>(table.values());
    }
}
// @lc code=end

