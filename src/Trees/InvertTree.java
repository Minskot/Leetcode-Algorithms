package Trees;// This is leetcode 226 invert tree:
// 反转一个二叉树，
// 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

/**
 * Definition for a binary tree node.
 * public class Trees.TreeNode {
 *     int val;
 *     Trees.TreeNode left;
 *     Trees.TreeNode right;
 *     Trees.TreeNode() {}
 *     Trees.TreeNode(int val) { this.val = val; }
 *     Trees.TreeNode(int val, Trees.TreeNode left, Trees.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class InvertTree {
    // 三种解法：前序遍历，中序遍历，后序遍历

    public TreeNode invertTree(TreeNode root) {

        if(root==null) return null;

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;

        invertTree (root.left);
        invertTree (root.right);

        return root;
    }

}
