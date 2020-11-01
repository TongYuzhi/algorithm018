import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            ans.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return ans;
    }
}
// @lc code=end

/**
 *  approch 1 recursive
 * 
 * class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);

        return ans;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}

 */

/**
 *  approch 2 iterative
 * 
 * class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> rightNode = new Stack<>();

        while (root != null) {
            ans.add(root.val);
            if (root.right != null) {
                rightNode.push(root.right);
            }
            root = root.left;
            if (root == null && !rightNode.isEmpty()) {
                root = rightNode.pop();
            }
        }
        return ans;
    }
}
 */
