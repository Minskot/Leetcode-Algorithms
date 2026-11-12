package Trees;
import java.util.HashMap;
import java.util.Map;

// 437. 路径总和3

/*
给定一个二叉树的根节点root，和一个整数targetSum，
求该二叉树里节点值之和等于TargetSum的路径的数目

路径不需要从根节点开始，也不需要在叶子节点结束，
但是路径方向必须是向下的，只能从父节点到子节点
*/


// 节点值很大或者可能溢出的时候，使用long类型数字，由于本题中需要累加各节点的数值，所以和可能很大
public class PathSum {

    // 解法一：双重递归（暴力DFS）
    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // 包含当前节点的路径数 + 左子树的路径数 + 右子树的路径数
        return dfs(root, targetSum)+pathSum1(root.left,targetSum)+pathSum1(root.right,targetSum);
    }

    // 以 node 为起点，向下累加，和为 targetSum 的路径数
    private int dfs(TreeNode node, long targetSum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == targetSum) count++;
        count += dfs(node.left, targetSum - node.val);
        count += dfs(node.right, targetSum - node.val);
        return count;
    }


    // 解法二：前缀和+哈希表
    private int count = 0;
    private Map<Long, Integer> prefixSumCount = new HashMap<>();

    public int pathSum2(TreeNode root, int targetSum) {
        // 前缀和为0表示空路径
        prefixSumCount.put(0L, 1);
        dfs(root, 0L, targetSum);
        return count;
    }

    private void dfs(TreeNode node, long currSum, int targetSum) {
        if (node == null) return;

        // 当前路径和
        currSum += node.val;

        // 查找有多少个前缀和等于 currSum - targetSum
        // 这些前缀对应的路径结尾到当前节点的和正好是 targetSum
        count += prefixSumCount.getOrDefault(currSum - targetSum, 0);

        // 记录当前前缀和
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);

        // 递归左右子树
        dfs(node.left, currSum, targetSum);
        dfs(node.right, currSum, targetSum);

        // 回溯：移除当前前缀和（避免影响其他分支）
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
    }

}
