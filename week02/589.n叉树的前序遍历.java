import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            Collections.reverse(node.children);

            for (Node nd : node.children) {
                stack.push(nd);
            }
        }
        return ans;
    }
}
// @lc code=end

/**
 *  approch 1 recursive
 * 
 * private List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        pre(root);       

        return ans;
    }

    private void pre(Node root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        for (Node node : root.children) {
            pre(node);
        }
    }
 */
