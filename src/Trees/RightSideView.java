package Trees;
// 199. 二叉树的右视图： 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

import java.util.*;
public class RightSideView {
    // 解法1：BFS层序遍历
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 创建数组列表
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                // 遍历当前层的所有节点
                TreeNode node = queue.poll();
                if (i == levelSize - 1) result.add(node.val);
                // 如果是当前层的最后一个节点，加入结果
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                // 先左后右，这样最右边的节点会在最后被处理
            }

        }
        return result;
    }

    //解法二：DFS先右后左，更简洁
    public List<Integer> rightSideView2 (TreeNode root){
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs (TreeNode node,int depth, List<Integer > result){
        if (node == null) return;
        // 如果当前深度还没有记录过节点，说明这是该层第一个（从右往左看的第一个）
        if (depth == result.size()) result.add(node.val);
        // 先遍历右子树，再遍历左子树
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }


    // 二叉树的右视图 抄写一遍

    public List<Integer> rightSideView3 (TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize= queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode node=queue.poll();
                if (i==levelSize-1) result.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);


            }
        }
        return result;

    }

    // 二叉树的右视图：深度优先搜索 dfs

    List<Integer> res=new ArrayList<>();

    public List <Integer> rightSideView(TreeNode root){
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int depth){
        if (root==null) return;
        if (depth==res.size()) res.add(root.val);

        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
















}

