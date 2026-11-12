package Trees;

import java.util.ArrayList;
import java.util.List;


/*
        public List<Integer> inorderTra(Trees.TreeNode node){
            List<Integer>ans=new ArrayList<>();
            inord(node,ans);
            return ans;
        }

        public void inord(Trees.TreeNode node, List<Integer> ans){
        if (node==null) return;
        inord(node.left,ans);
        ans.add(node.val);
        inord(node.right,ans);
        }

 */


public class InorderTraversal {
    /**
     * Definition for a binary tree node.
     */
    public List<Integer>inorderTraversal(TreeNode root){
        List<Integer>res=new ArrayList<>();
        dfs(root,res);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res){
        if (root==null) return;
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }



}
