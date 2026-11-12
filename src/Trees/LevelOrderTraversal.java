package Trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 102. 二叉树的层序遍历
// 广度优先搜索 BFS 使用队列
/*
层序遍历，核心思想是“FIFO”
层序遍历需要借助一个队列Queue记录每一层的节点，
模拟出遍历过程中顺序逐层扩散的过程。

初始化：将根节点放入队列，
循环处理：当队列非空时，循环以下操作：
1. 从对列中取出一个节点，出队访问它
2. 如果这个节点有左孩子，将左孩子放入队列
3. 如果这个节点有右孩子，将右孩子放入队列
结束条件：当队列为空时，所有节点都已经按照层级顺序访问完毕
*/



public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        // 创建队列以便于记录每一层的节点
        queue.offer(root);
        // 将根节点放进队列中，完成初始化

        while (!queue.isEmpty()) {
            // 循环以下操作：
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                // 将下一层的节点加入队列
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            result.add(levelList);
        }
        return result;
    }


    // 先抄写一遍
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize= queue.size();
            List<Integer>levelList=new ArrayList<>();
            for (int i=0;i<levelSize;i++){
                TreeNode node=queue.poll();
                levelList.add(node.val);
                if (node.left!=null) queue.offer(node.left);
                if (node.right!=null) queue.offer(node.right);

            }
            result.add(levelList);
        }
        return result;
    }

















}

