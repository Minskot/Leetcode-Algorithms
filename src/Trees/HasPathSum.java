package Trees;
// 代码随想录解法：112. 路径总和：
// 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
// 使得这条路径上所有节点值相加等于目标和

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root==null) return false;
        targetSum-=root.val;
        if (root.left==null||root.right==null) return targetSum==0;
        if (root.left!=null){
            boolean left=hasPathSum(root.left,targetSum);
            if (left) return true;
        }
        if (root.right!=null){
            boolean right=hasPathSum(root.right,targetSum);
            if (right) return true;
        }
        return false;
    }

    
    // 简洁方法：
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root==null) return false;
        // 为空退出
        if (root.left==null&&root.right==null) return root.val==targetSum;
        // 叶子节点是否符合
        return hasPathSum2(root.left, targetSum-root.val)||hasPathSum2(root.right,targetSum-root.val);

    }


}
