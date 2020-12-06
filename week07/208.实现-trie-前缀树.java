import org.graalvm.compiler.word.Word;

/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
    private boolean isEnd;
    private Trie[] next;

    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        char[] words = word.toCharArray();
        Trie node = this;

        for (int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            if (node.next[n] == null) {
                node.next[n] = new Trie();
            }
            node = node.next[n];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);

        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);

        return node != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        char[] chs = prefix.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            node = node.next[chs[i] - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

/**
 * 
 * class Trie {
    private boolean isEnd;
    private Trie[] next;

    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }
    
    public void insert(String word) {
        if (word == null || word.length() < 1) {
            return;
        }
        Trie cur = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int n = words[i] - 'a';
            if (cur.next[n] == null) {
                cur.next[n] = new Trie();
            }
            cur = cur.next[n];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }
}
 */