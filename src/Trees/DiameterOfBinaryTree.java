package Trees;

// 二叉树的直径
public class DiameterOfBinaryTree {
    int maxDiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }
  private int depth(TreeNode node){
        if (node==null) return 0;
        int leftDepth=depth(node.left);
        int rightDepth=depth(node.right);

        maxDiameter=Math.max(maxDiameter,leftDepth+rightDepth);
        return Math.max(leftDepth,rightDepth)+1;
    }



}
