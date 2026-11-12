package Trees;
// 236. 二叉树的最近公共祖先
// 递归：后序遍历：左子树，右子树，根节点

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null||root==p||root==q) return root;
        // 终止条件：找到p或q， 或者到达null

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        // 分别在左右子树中查找p和q

        if (left!=null&& right!=null) return root;
        // 如果左右子树都找到了，说明当前节点就是最近公共祖先

        return left!=null ? left:right;
        // 如果只在一边找到了，pq在同一边的子树上，返回找到的那一边
        // 左边找到了返回左边；右边找到了返回右边
        // 如果左右都是null，pq都不在当前子树，返回null


    }


    // leetcode示范解答：
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        if (down(p, q)){
            return p;
        }else if (down(q, p)){
            return q;
        }else {
            while (true){
                if (down(res.left, p) && down(res.left, q)){
                    res = res.left;
                }else if (down(res.right, p) && down(res.right, q)){
                    res = res.right;
                }else {
                    break;
                }
            }
        }
        return res;
    }

    private boolean down (TreeNode root, TreeNode q){
        if (root == null){
            return false;
        }
        if (root == q){
            return true;
        }
        if (down(root.left, q) || down(root.right, q)){
            return true;
        }else {
            return false;
        }
    }



}
