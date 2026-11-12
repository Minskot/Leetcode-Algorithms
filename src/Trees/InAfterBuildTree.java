package Trees;
// 代码随想录公开课：106. 从中序遍历和后序遍历数组构建二叉树：


import java.util.Map;

public class InAfterBuildTree {
    Map<Integer,Integer > map;
    public TreeNode InAfterBuildTree(int[] postorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put (inorder[i],i);

        }
        return findNode (inorder,0,inorder.length,postorder,0,postorder.length)
    }

    public TreeNode findNode(int [] inorder, int inBegin, int inEnd, int []postorder, int postBegin,int postEnd){
        if(inBegin>=inEnd||postBegin>=postEnd) return null;
        int rootIndex=map.get(postorder[postEnd-1]);
        // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root=new TreeNode(inorder[rootIndex]); // 构造节点

    }



}


