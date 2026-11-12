package DynamicPlanning;
// 动态规划，假设你要爬n阶楼梯，一次可以走1阶或者2阶，
// 那么请问你一共多少种不同方式（排列数）
// 算法核心：这个数字实际上是斐波那契数列，因为从i-1和i-2阶走向i阶，分别是走1级或者2级
// fab(i) = fab(i-1)+fab(i-2);

public class ClimbStairs {
    public int climbStairs(int n){
        if (n<=2) return n;
        int []dp=new int [n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++) dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
}
