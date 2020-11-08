import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //approach 2 : O(n) without map
    private int pre = 0;
    private int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return creatTree(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode creatTree(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = creatTree(preorder, inorder, node.val);
        node.right = creatTree(preorder, inorder, stop);
        return node;
    }
}
// @lc code=end

/**
 *  approach 1 : use map, easy to understand
 * 
 * public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        Map<Integer, Integer> rootMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            rootMap.put(inorder[i], i);
        }
        return creatTree(preorder, inorder, rootMap, 0, len - 1, 0, len - 1);
    }

    private TreeNode creatTree(int[] preorder, int[] inorder, Map<Integer, Integer> rootMap, 
                                int preLeft, int preRight,
                                int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        //root index in preorder [root, [left], [right]]
        int preRootIndex = preLeft; 
        //root index in inorder [[left], root, [right]]
        int inRootIndex = rootMap.get(preorder[preRootIndex]); 

        TreeNode root = new TreeNode(preorder[preRootIndex]); //creat root
        int leftSubTreeSize = inRootIndex - inLeft; 

        //according to the index of root in inorder, get the number of left
        //subtree and right subtree,then recursive to creat them
        root.left = creatTree(preorder, inorder, rootMap,
                                preLeft + 1, preLeft + leftSubTreeSize, 
                                inLeft, inRootIndex - 1);
        root.right = creatTree(preorder, inorder, rootMap, 
                                preLeft + leftSubTreeSize + 1, 
                                preRight, inRootIndex + 1, inRight);
        return root;
    }
 */
