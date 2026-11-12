package Matrix;//矩阵置零：
import java.util.Arrays;
public class MatrixSetZeros {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int []arr1=new int[row];
        Arrays.fill(arr1,1);
        int []arr2=new int[col];
        Arrays.fill(arr2,1);

        for (int i=0; i<row; i++)
            for (int j=0;j<col;j++)
                if (matrix[i][j]==0){
                    arr1[i]=0;
                    arr2[j]=0;
                    }

        for (int i = 0; i<row; i++)
            if (arr1[i]==0)
                for (int j=0;j<col;j++)
                    matrix[i][j]=0;

        for (int j=0;j<col;j++)
            if (arr2[j]==0)
                for (int i=0;i<row;i++)
                    matrix[i][j]=0;
    }
//更优秀的写法：原地方法：O(1)
public void setZeroes2(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    // 用第一行和第一列作为标记数组
    boolean firstRowZero = false;
    boolean firstColZero = false;

    // 1. 检查第一行是否有0
    for (int j = 0; j < n; j++) {
        if (matrix[0][j] == 0) {
            firstRowZero = true;
            break;
        }
    }

    // 2. 检查第一列是否有0
    for (int i = 0; i < m; i++) {
        if (matrix[i][0] == 0) {
            firstColZero = true;
            break;
        }
    }

    // 3. 用第一行和第一列标记其他位置
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;  // 标记该行
                matrix[0][j] = 0;  // 标记该列
            }
        }
    }

    // 4. 根据标记置零（除第一行第一列外）
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // 5. 处理第一行
    if (firstRowZero) {
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 0;
        }
    }

    // 6. 处理第一列
    if (firstColZero) {
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }
}


}




