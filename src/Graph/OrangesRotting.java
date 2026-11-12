package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    // 994. 腐烂的橘子：层序遍历：BFS
    // empty:0  fresh:1  rotten:2

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        // 初始化过程

        Queue<int[]> queue = new LinkedList<>();
        // 队列用于容纳腐烂的橘子，每当遇到新的腐烂的橘子，就将这个坐标加入队列
        int freshCount = 0;
        // 用于统计新鲜橘子数量

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 遍历表格，遇到腐烂橘子入队，遇到新鲜橘子计算数量

                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                // 遍历表格，如果橘子腐烂，入队：
                else if (grid[i][j] == 1) freshCount++;
                // 如果橘子新鲜，统计新鲜橘子总数
            }
        }


        if (freshCount == 0) return 0;
        // 边界情况：如果没有新鲜橘子，直接返回 0
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2. BFS 层序遍历：一层层从向外扩散
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            // 当前腐烂橘子数量
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                // 将队列中的腐烂橘子出队

                for (int[] dir : directions) {
                    // 向上下左右四个方向移动
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];


                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        // 如果相邻位置是新鲜橘子，让它腐烂
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        freshCount--;
                        // 将橘子改成腐烂：修改表格，腐烂入队，新鲜橘子数量减少
                    }
                }
            }

            minutes++;  // 每遍历完一层，时间增加 1 分钟
        }

        return freshCount == 0 ? minutes : -1;
    }


}



