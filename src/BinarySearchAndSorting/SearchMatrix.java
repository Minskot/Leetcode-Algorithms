package BinarySearchAndSorting;
// 240. 搜索二维矩阵
// 从右上角开始，目标值比当前大则下移，比当前小则左移
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix[0].length==0) return false;
        int m=matrix.length, n=matrix[0].length;
        int row=0, col=n-1;
        while(row<=m-1&&col>=0){
            if (matrix[row][col]==target) return true;
            if (matrix[row][col]<target) row++;
            else col--;
        }
        return false;
    }

}

