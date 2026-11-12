package Trees;
import java.util.Stack;
// 230. 二叉搜索树中第K小的元素
// BST中序遍历+提前终止
// BST最重要的特性：二叉搜索树BST的中序遍历结果是升序的（左孩子，节点，右孩子）
// 那么根据这一性质，二叉树中第K小的元素就是中序遍历序列中的第K个元素


class KthSmallest{
    // 解法1：递归



    private int count = 0;
    // 记录已经访问了多少个节点
    private int result = 0;
    // 存储第K小的值

    public int kthSmallest1(TreeNode root, int k) {
        if(k<=0) return -1;
        inorder(root, k);
        return result;
    }
    
    private void inorder(TreeNode node, int k) {
        // DFS深度优先搜索，中序遍历：每次找到下来的最小值
        if (node == null) return;
        inorder(node.left, k);
        // 先遍历左子树

        count++;
        // 访问当前节点
        if (count == k) {
            result = node.val;
            return;
            // count==k， 直接return
            // 中序遍历，第k个遍历到的节点就是第K小
        }
        inorder(node.right, k);
        // 再遍历右子树
    }


    // 解法二 中序遍历，迭代，提前停止
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        
        while (curr != null || !stack.isEmpty()) {
            // 一直向左走
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }   

            // 弹出栈顶（当前最小节点）
            curr = stack.pop();
            count++;
            
            if (count == k) return curr.val;      

            // 转向右子树
            curr = curr.right;
        }
        return -1; // 理论上不会走到这里
    }


    // 分治法：利用BST性质
    public int kthSmallest3(TreeNode root, int k) {
        int leftCount = countNodes(root.left);
        if (k <= leftCount) return kthSmallest3(root.left, k);
        else if (k == leftCount + 1) return root.val;
        else return kthSmallest3(root.right, k - leftCount - 1);
        
    }
    
    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }


    // 迭代写法：面试可能会喜欢问这个：
    public int kthSmallestIterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            count++;
            if (count == k) return curr.val;
            curr = curr.right;
        }
        return -1;
    }





}    
        
    



