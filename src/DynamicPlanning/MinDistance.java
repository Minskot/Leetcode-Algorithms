package DynamicPlanning;
// 72. 编辑距离：代码随想录版本
/*
给你两个单词 word1 和 word2，请返回将 word1 转换成 word2 所使用的最少操作数。
每一步可以插入，删除，替换
 */
// dp[i][j] 表示以i-1为尾的word1和以j-1为尾的word2：
// 每次状态转移方程可以有增减（实际上效果一致）和更换完成，
// 对应动态规划数组的上方，左方|左上方的状态转移

public class MinDistance {
    public int minDistance(String word1, String word2) {

        int m=word1.length();
        int n=word2.length();
        int [][]dp=new int[m+1][n+1];
        for (int i=0;i<=m;i++) dp[i][0]=i;
        for (int j=0;j<=n;j++) dp[0][j]=j;

        for(int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else {
                    dp[i][j]=Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));
                }
            }
        }
        return dp[m][n];

    }


}
