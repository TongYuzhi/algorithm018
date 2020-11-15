import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsSet = new HashSet<>(wordList);
        if (wordsSet.isEmpty() || !wordsSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();
        int minLength = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tempSet = beginSet;
                beginSet = endSet;
                endSet = tempSet;
            }
            Set<String> set = new HashSet<>();
            for (String word : beginSet) {
                char[] curArray = word.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curArray[i] = c;
                        String next = String.valueOf(curArray);
                        if (endSet.contains(next)) {
                            return minLength + 1;
                        }
                        if (!visited.contains(next) && wordsSet.contains(next)) {
                            set.add(next);
                            visited.add(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
            minLength++;
            beginSet = set;
        }
        return 0;
    }
}

// @lc code=end

/**
 *  two-ends bfs
 * 
 * public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int minLength = 1;
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> tempSet = new HashSet<>();
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    char old = wordArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[i] = c;
                        String target = String.valueOf(wordArray);

                        if (endSet.contains(target)) {
                            return minLength + 1;
                        }

                        if (!visited.contains(target) && wordSet.contains(target)) {
                            tempSet.add(target);
                            visited.add(target);
                        }
                    }
                    wordArray[i] = old;
                }
            }
            beginSet = tempSet;
            minLength++;
        }
        return 0;
    }
 */

/**  BFS 
 * 
 * Set<String> wordSet = new HashSet<>(wordList);
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int minLength = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curString = queue.poll();
                if (curString.equals(endWord)) {
                    return minLength;
                }
                char[] curArray = curString.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (char ch : alphabet) {
                        curArray[i] = ch;
                        String next = String.valueOf(curArray);
                        if (!visited.contains(next) && wordSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
            minLength++;
        }
        return 0;
 */

 /**
  *  DFS (Time Limit Exceeded)

  private int minLength = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String[] wordsArray = new String[wordList.size()];
        wordsArray = wordList.toArray(wordsArray);
        dfs(beginWord, endWord, 1, wordsArray);
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    private void dfs(String beginWord, String endWord, int length, String[] wordsArray) {
        if (beginWord.equals(endWord)) {
            minLength = Math.min(minLength, length);
            return;
        }
        for (int j = 0; j < wordsArray.length; j++) {
            String word = wordsArray[j];
            if (word == null) {
                continue;
            }

            char[] wordArray = word.toCharArray();
            char[] beginArray = beginWord.toCharArray();

            int diffrent = 0;
            for (int i = 0; i < wordArray.length; i++) {
                if (wordArray[i] != beginArray[i]) {
                    if (++diffrent > 1) {
                        break;
                    }
                }
            }
            if (diffrent == 1) {
                wordsArray[j] = null;
                dfs(word, endWord, length + 1, wordsArray);
                wordsArray[j] = word;
            }
        }
    }
  */
