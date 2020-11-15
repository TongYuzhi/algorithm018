import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=126 lang=java
 *
 * [126] 单词接龙 II
 */

// @lc code=start
class Solution {
    //little confused here, need to practice more time
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = getChildren(beginWord, endWord, wordSet);
        List<String> path = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        path.add(beginWord);
        findLadders(beginWord, endWord, map, path, res);

        return res;
    }

    private void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String next : map.get(beginWord)) {
            path.add(next);
            findLadders(next, endWord, map, path, res);
            path.remove(path.size() - 1);
        }
    }

    private Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> wordSet) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);

        boolean isFound = false;
        boolean isBackWord = false;

        while (!beginSet.isEmpty() && !isFound) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
                isBackWord = !isBackWord;
            }
            Set<String> set = new HashSet<>();
            for (String cur : beginSet) {
                visited.add(cur);
                for (String next : getNext(cur, wordSet)) {
                    if (visited.contains(next) || beginSet.contains(next)) {
                        continue;
                    }
                    if (endSet.contains(next)) {
                        isFound = true;
                    }
                    set.add(next);
                    String parent = isBackWord ? next : cur;
                    String child = isBackWord ? cur : next;
                    if (!map.containsKey(parent)) {
                        map.put(parent, new ArrayList<>());
                    }
                    map.get(parent).add(child);
                }
            }
            beginSet = set;
        }
        return map;
    }

    private List<String> getNext(String cur, Set<String> wordSet) {
        List<String> nextList = new ArrayList<>();
        char[] curArray = cur.toCharArray();
        for (int i = 0; i < cur.length(); i++) {
            char old = curArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) {
                    continue;
                }
                curArray[i] = c;
                String next = String.valueOf(curArray);
                if (wordSet.contains(next)) {
                    nextList.add(next);
                }
            }
            curArray[i] = old;
        }
        return nextList;
    } 
}
// @lc code=end

/**
 * public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return Collections.emptyList();
        }
        Map<String, List<String>> map = getChildren(beginWord, endWord, wordSet);
        List<String> path = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        path.add(beginWord);
        findLadders(beginWord, endWord, map, path, res);

        return res;
    }

    private void findLadders(String beginWord, String endWord, Map<String, List<String>> map, List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String next : map.get(beginWord)) {
            path.add(next);
            findLadders(next, endWord, map, path, res);
            path.remove(path.size() - 1);
        }
    }

    private Map<String, List<String>> getChildren(String beginWord, String endWord, Set<String> wordSet) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        boolean isFound = false;
        boolean isBackWord = false;

        while (!beginSet.isEmpty() && !isFound) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
                isBackWord = !isBackWord;
            }
            Set<String> set = new HashSet<>();
            for (String cur : beginSet) {
                visited.add(cur);
                for (String next : getNext(cur, wordSet)) {
                    if (visited.contains(next) || beginSet.contains(next)) {
                        continue;
                    }
                    if (endSet.contains(next)) {
                        isFound = true;
                    }
                    set.add(next);
                    String parent = isBackWord ? next : cur;
                    String child = isBackWord ? cur : next;
                    if (!map.containsKey(parent)) {
                        map.put(parent, new ArrayList<>());
                    }
                    map.get(parent).add(child);
                }
            }
            beginSet = set;
        }
        return map;
    }

    private List<String> getNext(String cur, Set<String> wordSet) {
        List<String> nextList = new ArrayList<>();
        char[] curArray = cur.toCharArray();
        for (int i = 0; i < curArray.length; i++) {
            char old = curArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (old == c) {
                    continue;
                }
                curArray[i] = c;
                String next = String.valueOf(curArray);
                if (wordSet.contains(next)) {
                    nextList.add(next);
                }
            }
            curArray[i] = old;
        }
        return nextList;
    }
 */
