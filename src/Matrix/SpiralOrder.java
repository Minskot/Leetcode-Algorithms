package Matrix;
import java.util.ArrayList;
import java.util.List;

// 螺旋矩阵
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        // deepseek： 边界收缩法

        List <Integer> result=new ArrayList<>();
        if(matrix==null||matrix.length==0) return result;
        int m=matrix.length; int n=matrix[0].length;
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while(top<=bottom&&left<=right){
            for (int i=left;i<=right;i++) result.add(matrix[top][i]);
            top++;
            for(int i=top;i<=bottom;i++) result.add(matrix[i][right]);
            right--;

            /* 这里如果沿用以上的判断逻辑，会产生bug：
             输入 matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]

             输出  [1,2,3,4,8,12,11,10,9,5,6,7,6]
             预期结果 [1,2,3,4,8,12,11,10,9,5,6,7]
             */
            // 单行注释快捷键：选中之后 Ctrl + /
            // 注释块快捷键：选中之后 Ctrl + Shift + /

            if(top<=bottom){
                for (int i=right;i>=left;i--) result.add(matrix[bottom][i]);
                bottom--;
            }
            // 在第 3 步结束之前判断是否还有未处理的行，如果没有就提前退出，避免第 4 步重复

            if (left<=right){
                for (int i=bottom;i>=top;i--) result.add(matrix[i][left]);
                left++;
            }

        }
        return result;
    }

}
