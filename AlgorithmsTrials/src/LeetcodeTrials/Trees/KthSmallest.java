package LeetcodeTrials.Trees;

// 对二叉搜索树BST做中序遍历，得到的序列天然就是升序的，
// 所以第K个被访问道德节点就是第K小的元素

class KthSmallest{

    private int count=0;
    private int result=0;

    public int kthSmallest (TreeNode root, int k){
        if (k<=0) return -1;
        inorder(root,k);
        return result;
    }

    private void inorder (TreeNode node, int k){
        // 广度优先搜索，二叉树的中序遍历：
        if (node==null) return;
        inorder(node.left, k);

        count++;
        if (count==k){
            result=node.val;
            return;
        }
        inorder(node.right, k);
    }


    // 解法二：中序遍历，迭代，提前终止
    /* 
    public int kthSmallest2(TreeNode root, int k){

    }

    */  
}