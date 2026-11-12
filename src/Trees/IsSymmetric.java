package Trees;
import java.util.Queue;
import java.util.LinkedList;

// 检验一个二叉树是否对称

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root){
        if (root==null) return true;
        //iterative approach:递归解法
        return (isMirror(root.left,root.right));
    }
    private boolean isMirror(TreeNode left,TreeNode right){
        if (left==null&&right==null) return true;
        if ((left==null&&right!=null)||(left!=null&&right==null)) return false;
        return (left.val==right.val&&left.left==right.right);
    }

    //解法2 迭代：使用队列
    public boolean isSymmetric2(TreeNode root){
        if (root==null) return true;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();

            if (left==null&&right==null) continue;
            if (left==null||right==null) return false;
            if (left.val!=right.val) return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);

        }
        return true;
    }
}







