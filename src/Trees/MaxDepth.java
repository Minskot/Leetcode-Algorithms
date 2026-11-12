package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    private int maxDepth(TreeNode root){
        //The answer is offered by DouBao:
        if(root==null) return 0;
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    //BFS层序遍历写法：面试常问非递归方法：
    public int maxDepth2(TreeNode root){
        if(root==null) return 0;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if (node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }


        /*
            public List<Integer>inorderTraversal(Trees.TreeNode root){
        List<Integer>res=new ArrayList<>();
        dfs(root,res);
        return res;
    }
    private void dfs(Trees.TreeNode root,List<Integer> res){
        if (root==null) return;
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }
         */

    }

