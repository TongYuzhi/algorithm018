import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.graalvm.compiler.word.Word;

import sun.security.provider.DSAKeyFactory;
import sun.text.normalizer.Trie;
import sun.text.resources.CollationData;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {

    class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.word = null;
            this.children = new HashMap<>();
        }

        private void insert(String word) {
            if (word == null || word.length() < 1) {
                return;
            }
            char[] words = word.toCharArray();
            Trie node = this;

            for (int i = 0; i < words.length; i++) {
                if (!node.children.containsKey(words[i])) {
                    node.children.put(words[i], new Trie());
                }
                node = node.children.get(words[i]);
            }
            node.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return Collections.emptyList();
        }
        Trie root = new Trie();

        for (String word : words) {
            root.insert(word);
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, res);
            }
        }
        return res;
    }

    private void search(char[][] board, int row, int col, Trie node, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        Trie curNode = node.children.get(board[row][col]);

        if (curNode == null) {
            return;
        }
        if (curNode.word != null && !res.contains(curNode.word)) {
            res.add(curNode.word);
        }

        char old = board[row][col];
        board[row][col] = '.';

        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < dir.length; i++) {
            search(board, row + dir[i][0], col + dir[i][1], curNode, res);
        }
        board[row][col] = old;
    }
}
// @lc code=end

/**
 * 
 * class Trie {
        String word;
        Map<Character, Trie> next;

        Trie() {
            this.word = null;
            this.next = new HashMap<>();
        }

        public void insert(String word) {
            if (word == null || word.length() < 1) {
                return;
            }
            char[] words = word.toCharArray();
            Trie node = this;

            for(int i = 0; i < words.length; i++) {
                if (!node.next.containsKey(words[i])) {
                    node.next.put(words[i], new Trie());
                }
                node = node.next.get(words[i]);
            }
            node.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, res);
            }
        }
        return res;
    }

    private void search(char[][] board, int row, int col, Trie root, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];
        if (!root.next.containsKey(ch)) {
            return;
        }

        Trie curNode = root.next.get(ch);
        if (curNode.word != null && !res.contains(curNode.word)) {
            res.add(curNode.word);
            return;
        }
        
        char old = board[row][col];
        board[row][col] = '.';

        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < dir.length; i++) {
            search(board, row + dir[i][0], col + dir[i][1], curNode, res);
        }
        board[row][col] = old;
    }
 */
