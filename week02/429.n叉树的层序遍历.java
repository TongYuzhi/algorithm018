import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        traversal(root, 0);
        return ans;
    }

    private void traversal(Node node, int level) {
        if (ans.size() <= level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(node.val);
        for (Node child : node.children) {
            traversal(child, level + 1);
        }
    }
}
// @lc code=end

/**
 *  approch 1 recursive
 * 
 * private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        traversal(root, 0);
        return ans;
    }

    private void traversal(Node node, int level) {
        if (this.ans.size() <= level) {
            this.ans.add(new ArrayList<>());
        }
        this.ans.get(level).add(node.val);
        for (Node nd : node.children) {
            traversal(nd, level + 1);
        }
    }
 */

 /**
  *     approch 2 iterative

     if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = queue.size(); //curent level node's count
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                curLevel.add(cur.val);
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            ans.add(curLevel);
        }
        return ans;
  */