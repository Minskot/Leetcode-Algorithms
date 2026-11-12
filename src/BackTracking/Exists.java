package BackTracking;
// 79. 单词搜索：
/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。
*/


// 解法：回溯（DFS + 剪枝）
public class Exists {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        // 新建布尔数矩阵：是否遍历过这个元素
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从每个格子开始尝试匹配
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length() - 1) return board[i][j] == word.charAt(index);
        // 1. 终止条件：匹配完所有字符
        if (board[i][j]!= word.charAt(index)) return false;
        // 2. 如果当前字符不匹配，返回 false
        visited[i][j] = true;
        // 3. 标记当前格子为已访问
        // 同一个格子不能被重复使用，所以要标记访问
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 4. 四个方向探索
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            // 检查边界和是否已访问
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                if (dfs(board, word, x, y, index + 1, visited)) {
                    return true;
                }
            }
        }
        
        // 5. 回溯：撤销标记，标记后要恢复
        visited[i][j] = false;
        return false;
    }
    
}
