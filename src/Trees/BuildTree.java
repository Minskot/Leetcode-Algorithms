package Trees;
import java.util.*;

/*
105:从前序与中序遍历序列构造二叉树
给定两个整数数组preorder, inorder，其中preorder是二叉树的前序遍历，
inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点

*/
// 从前序遍历中，每次第一个节点就是当前二叉树子树的根节点，
// 然后在中序遍历中，根节点左边的部分就是二叉树的左子树，根节点右边的部分就是二叉树的右子树
// 递归解答，在每个前序遍历中找到根节点，然后在中序遍历中分为左子树和右子树

import java.util.HashMap;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen=preorder.length;
        int inLen=inorder.length;

        if (preLen!=inLen){
            throw new RuntimeException("Incorrect input data.");
        }

        Map<Integer,Integer> map=new HashMap<>(preLen);
        for (int i=0;i<inLen;i++) map.put(inorder[i],i);
        // 将中序遍历的元素加入哈希表，输入一个元素，返回他的索引顺序
        // 如果不在哈希表中预存节点，每次递归都要在中序数组里查找根节点位置，时间复杂度O(n^2):
        return buildTree(preorder,0,preLen-1,map,0,inLen-1);

    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               Map<Integer, Integer> map, int inLeft, int inRight) {
        /*
        为什么递归方法中，不需要传入中序遍历的数组？
        递归方法，从前序遍历顺序中取出根节点：需要preorder
        在中序遍历中，找到根节点的位置，需要map，但是不需要中序遍历序列本身
         */

        // 在实现函数中，主要的参数包括先序遍历数组，先序遍历的前后索引，哈希映射表，中序遍历的前后索引
        if(preLeft>preRight||inLeft>inRight) return null;
        // 注意这里的终止条件：必须是大于，如果写成了大于等于：会漏掉最后一个节点
        int rootVal=preorder[preLeft];  // 从前序遍历中取出根节点
        TreeNode root=new TreeNode(rootVal);  // 找到这个根节点在中序遍历中的位置
        int pIndex=map.get(rootVal);

        root.left= buildTree(preorder,preLeft+1, preLeft+(pIndex-inLeft),
                        map,inLeft,pIndex-1);
        root.right=buildTree(preorder,preLeft+(pIndex-inLeft)+1,preRight,
                map,pIndex+1, inRight);
        /*
        左子树前序范围：[preLeft+1, preLeft+leftSize]
        左子树中序范围：[inLeft, pIndex-1]
        右子树前序范围：[preLeft+leftSize+1, preRight]
        右子树中序范围：[pIndex+1, inRight]
         */


        return root;
    }
}
