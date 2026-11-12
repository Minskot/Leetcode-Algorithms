package Trees;

class IsValidBST{

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // 如果参数使用 Integer 而不是 Long，当树的节点值恰好等于Integer.MAX_VALUE 或 Integer.MIN_VALUE 时，算法会错误地返回 false。
    // 参数取到integer的最大最小值是合法的，但因为算法中要求节点的值严格大于小于边界值，所以当节点取最大最小值的时候会返回false

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;

        // 当前节点值必须在 (min, max) 范围内
        if (node.val <= min || node.val >= max) return false;

        // 左子树：最大值更新为当前节点值
        // 右子树：最小值更新为当前节点值
        return isValidBST(node.left, min, node.val)&&isValidBST(node.right, node.val, max);
    }
}


