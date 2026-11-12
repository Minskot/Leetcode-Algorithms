package Graph;

public class NumIslands {

/*
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;

            int rows = grid.length;
            int cols = grid[0].length;
            int islandCount = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        islandCount++;
                        dfs(grid, i, j);
                    }
                }
            }

            return islandCount;
        }

        private void dfs(char[][] grid, int i, int j) {
            // 边界检查 或 不是陆地
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
                return;
            }

            // 标记为已访问（沉岛）
            grid[i][j] = '0';

            // 向四个方向探索
            dfs(grid, i + 1, j); // 下
            dfs(grid, i - 1, j); // 上
            dfs(grid, i, j + 1); // 右
            dfs(grid, i, j - 1); // 左
        }
             */


    public int numIslands(char[][] grid) {
        if(grid.length==0||grid==null) return 0;
        int row=grid.length;
        int col=grid[0].length;
        int islandCount=0;

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]=='1'){
                    islandCount++;
                    dfs(grid,i,j);
                }
            }
        }
        return islandCount;
    }

    public void dfs(char[][]grid,int i,int j){
        if ((i<0)||(i>=grid.length)||(j<0)||(j>=grid[0].length)||(grid[i][j])!='1') return;
        grid[i][j]='0';

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }


    }

