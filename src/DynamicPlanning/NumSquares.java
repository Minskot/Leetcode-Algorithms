package DynamicPlanning;
// 279. 完全平方数
// 给你一个整数n，返回和为n的完全平方数的最小数量

public class NumSquares {

    public int numSquares(int n) {

        if (n<0) return -1;
        int[] dp = new int[n + 1];
        // 初始化数组，必须是长度n+1；
        for (int i = 0; i <= n; i++) dp[i] = i;
        // 数组中各数初始化时，以各自的序号为数值：取上限
        // 每个数值的上限就是全部由n个1加起来

        for (int i = 0; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        //以当前掌握的数值加上可能的完全平方数，向上更新数组
        return dp[n];


    }


    public static void main() {
        NumSquares ns=new NumSquares();

        int n=12;
        int ans=ns.numSquares(n);
        System.out.println(ans);

    }
}

/*

    if (n<0) return -1;
    int[]dp=new int[n+1];
    for (int i=0;i<=n;i++) dp[i]=i;
    for (int i=0;i<=n;i++)
        for (int j=1;j*j<=i;j++)
            dp[i]=Math.min(dp[i],dp[i-j*j]+1);

    return dp[n];


 */





