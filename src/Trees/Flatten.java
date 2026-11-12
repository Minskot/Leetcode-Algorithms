package Trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 114. 将二叉树展开为链表：
/*
给你二叉树的根结点 root ，请你将它展开为一个单链表：(实际上就是一条单边树)
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
由于是前序遍历，本节点-》左孩子-》右孩子
在之后的操作中，处理当前节点时，先保存当前的左右子树，
将当前节点的左子树移动到当前节点的右子树，然后在右子树的末尾，再接上原来的右子树
*/

public class Flatten {
    // 解法一：递归，最优解
    public void flatten1 (TreeNode root){
        if(root==null) return;

        // 递归展开左子树和右子树
        flatten1(root.left);
        flatten1(root.right);

        // 保存左右子树、
        TreeNode left=root.left;
        TreeNode right=root.right;

        // 将左子树移到右子树的位置
        root.left=null;
        root.right=left;

        // 找到当前右子树的末尾，接上原来的右子树
        TreeNode cur=root;
        while( cur.right!=null) cur=cur.right;
        cur.right=right;

    }

    // 方法二：前序遍历+重新连接
    public void flatten2 (TreeNode root){
        if (root==null) return;
        List<TreeNode> list=new ArrayList<>();
        preorder(root,list);

        for (int i=0;i<list.size()-1;i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
    }

    private void preorder(TreeNode node, List<TreeNode> list){
        if (node==null) return;
        list.add(node);
        preorder(node.left,list);
        preorder(node.right,list);
    }

    // 解法三：Morris遍历；空间O（1）；

}
