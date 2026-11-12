package Matrix;

// 旋转图像
/* 两种办法：
 1.先转置，再旋转
 交换 matrix[i][j] 与 matrix[j][i]
 2.原地旋转，四数交换
 */

public class RotateImage {
    public void rotate1(int[][] matrix) {
        // 先转置，再旋转
        if(matrix==null||matrix.length==0||matrix.length!=matrix[0].length) return;
        int m=matrix.length;
        for (int i=0;i<m;i++){
            for (int j=i;j<m;j++){
                // 注意不要写成从0开始迭代了：那样会翻两次变成原矩阵
                // i从0开始循环，j从i开始循环，避免反转两次
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<m/2;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][m-j-1];
                matrix[i][m-j-1]=temp;
            }
        }
    }

    public void rotate2(int [][]matrix){
        // 一次性原地旋转，四数交换
        if(matrix==null||matrix.length==0||matrix.length!=matrix[0].length) return;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j]; // 保存左上角的值
                matrix[i][j] = matrix[n - 1 - j][i]; // 左 → 上
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // 下 → 左
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // 右 → 下
                matrix[j][n - 1 - i] = temp; // 上 → 右
            }

        }
    }
}
