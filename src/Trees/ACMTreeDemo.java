package Trees;

// ACM 格式的树的算法题写法示范
// 与 LeetCode 不同：ACM 模式需要自己从标准输入 System.in 读取数据，并把答案打印到标准输出 System.out
// 提交时通常要求 class 名与文件名一致（很多 OJ 要求 main 类叫 Main）

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMTreeDemo {

    public static void main(String[] args) throws IOException {
        // 1) 推荐用 BufferedReader + StringTokenizer，比 Scanner 快，适合大数据量
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // ---------- 输入格式一：层序遍历数组（最常见的树输入） ----------
        // 题目通常描述为：给定一棵二叉树的层序遍历（LeetCode 风格，null 用某个标记表示），求 XXX
        //
        // 输入示例：
        //   7
        //   1 2 3 null 5 null 4
        //   第一行 n 表示节点数的“占位数”（含 null），第二行是层序数组
        //
        // 这里演示：不需要 n 也可直接读一行；用 null 表示空节点（有的题用 -1 或 #）
        int n = Integer.parseInt(st.nextToken()); // 占位列数，本题用不到也要读掉
        st = new StringTokenizer(br.readLine());
        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = st.nextToken();
        }
        TreeNode root = buildByLevelOrder(tokens, "null");

        // ---------- 核心算法 ----------
        int maxDepth = maxDepth(root);              // 例1：二叉树最大深度
        List<List<Integer>> levels = levelOrder(root); // 例2：层序遍历
        boolean symmetric = isSymmetric(root);      // 例3：是否对称

        // ---------- 输出 ----------
        // 严格按题目要求的格式输出，不要加多余的中文提示
        System.out.println(maxDepth);
        System.out.println(levels);      // 例如 [[1], [2, 3], [5, 4]]
        System.out.println(symmetric ? "YES" : "NO");

        // ---------- 输入格式二：多组测试用例（T 组） ----------
        // 常见形式：第一行 T，表示有 T 组数据
        // 若题目是多组，用下面的循环：
        //
        // int T = Integer.parseInt(br.readLine().trim());
        // while (T-- > 0) {
        //     int m = Integer.parseInt(br.readLine().trim());
        //     StringTokenizer t = new StringTokenizer(br.readLine());
        //     String[] arr = new String[m];
        //     for (int i = 0; i < m; i++) arr[i] = t.nextToken();
        //     TreeNode r = buildByLevelOrder(arr, "null");
        //     System.out.println(maxDepth(r));
        // }

        // ---------- 输入格式三：边(u, v)形式，按 n-1 条边建树 ----------
        // 常见形式：第一行 n，接下来 n-1 行每行 u v 表示一条无向边
        // TreeNode r = buildByEdges(br, n);
    }

    /**
     * 层序遍历数组 -> 二叉树。
     * tokens 中的空节点用 nullToken 标记（如 "null"、"-1"、"#"）。
     */
    private static TreeNode buildByLevelOrder(String[] tokens, String nullToken) {
        if (tokens == null || tokens.length == 0 || tokens[0].equals(nullToken)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < tokens.length) {
            TreeNode cur = queue.poll();
            // 左孩子
            if (i < tokens.length && !tokens[i].equals(nullToken)) {
                cur.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(cur.left);
            }
            i++;
            // 右孩子
            if (i < tokens.length && !tokens[i].equals(nullToken)) {
                cur.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    /**
     * 按 n-1 条无向边建树（默认 1 为根）。适用于"输入 u v 表示父子/相邻"的题目。
     */
    private static TreeNode buildByEdges(BufferedReader br, int n) throws IOException {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g.get(u).add(v);
            g.get(v).add(u);
        }
        boolean[] visited = new boolean[n + 1];
        return dfsBuild(g, 1, visited);
    }

    private static TreeNode dfsBuild(List<List<Integer>> g, int u, boolean[] visited) {
        visited[u] = true;
        TreeNode node = new TreeNode(u);
        for (int v : g.get(u)) {
            if (!visited[v]) {
                if (node.left == null) {
                    node.left = dfsBuild(g, v, visited);
                } else {
                    node.right = dfsBuild(g, v, visited);
                }
            }
        }
        return node;
    }

    // ---------------- 核心算法实现 ----------------

    // 二叉树最大深度
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // 层序遍历
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    // 是否对称
    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
