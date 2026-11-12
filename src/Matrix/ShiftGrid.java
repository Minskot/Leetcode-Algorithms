package Matrix;

import java.util.ArrayList;
import java.util.List;

// 1260. 二维网格迁移
public class ShiftGrid {

    // 一维展开法：最简洁

    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        int m=grid.length;  // rows
        int n=grid[0].length;  // columns
        int total=m*n;   // total elements

        k=k%total;   // regularization of k

        int [] flat=new int[total];  // 创建新的数组，一维化储存数组元素
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                flat[i*n+j]=grid[i][j];    // 将网格中的元素转移至数组中
            }
        }

        // 迁移后的数组：

        int [] shifted=new int [total];
        for (int i=0; i<total;i++){
            int newPos=(i+k)%total;
            shifted[newPos]=flat[i];
        }

        // 转换回二维列表：
        List<List<Integer>> result=new ArrayList<>();
        for (int i=0;i<m;i++){
            List<Integer> row=new ArrayList<>();
            for (int j=0;j<n;j++) row.add(shifted[i*n+j]);
            result.add(row);
        }

        return result;

    }

}
