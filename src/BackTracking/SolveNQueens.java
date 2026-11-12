package BackTracking;
// 51. N皇后 回溯算法，代码随想录
// 整体思路，DFS回溯逐行装填皇后，每行放一个Q，
// 递归从row=0 到row=n 深度==行号，每层分支==该行的n个列的选择
// isValid方法检测当前位置装填皇后的合法性，剪枝不合理的情况
//

import java.util.*;


public class SolveNQueens {
    List<List<String>> res=new ArrayList<>();
    // res作为一个二层嵌套列表，储存最终答案，列表中装有列表，每个子列表表示一个答案
    // 每个答案的格式是[".Q..","...Q","Q...","..Q."]

    List<List<String>> solveNQueens(int n ){
        char [][] chessboard =new char[n][n];
        // 二维char数组，初始化棋盘
        for (char []c:chessboard) Arrays.fill(c,'.');
        // 全部填满 '.'

        backTrack (n,0,chessboard);
        return res;
    }


    public void backTrack(int n, int row, char [][] chessboard){
        // 核心回溯方法：
        if (row==n) {
            // 已经回溯到游戏树的叶子节点
            res.add(Array2List(chessboard));
            // 将成功结果转成字符串列表，加入res:
            return;
        }

        // 没有成功的情况，需要在每一轮迭代中检查当前中间结果的合法性，
        // 错误的结果需要提前返回
        for(int col=0;col<n;++col){
            // 由于游戏树是一层一层构建的，所以中间结果的rows不同
            // 需要以col的形式遍历数组，才能满足一直是n的遍历范围
            if (isValid(row,col,n,chessboard)){
                chessboard[row][col]='Q';
                // 做选择
                backTrack(n,row+1,chessboard);
                // 调用递归办法，递归到下一层
                chessboard[row][col] ='.';
                // 撤销选择，回溯恢复本层原版状态
            }
        }
    }

    public List Array2List(char[][] chessboard){
        // 结果格式转换：将char的每一行转化为string
        List<String> list=new ArrayList<>();

        for (char []c:chessboard)
            list.add(String.copyValueOf(c));

        return list;
    }

    public boolean isValid(int row, int col , int n , char[][]chessboard){
        // 这个方法检查当前的棋子位置是否合法
        // 将当前的棋子位置和棋盘上的不同位置是否有Q来比较

        for (int i=0;i<row;i++)
            if (chessboard[i][col]=='Q') return false;

        for (int i=row-1, j=col-1; i>=0&&j>=0;i--,j--)
            if (chessboard[i][j]=='Q') return false;

        for (int i=row-1,j=col+1;i>=0&&j<n-1;i--,j++)
            if (chessboard[i][j]=='Q') return false;

        return true;
    }

}


