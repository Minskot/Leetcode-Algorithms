package DynamicPlanning;
// 零钱兑换：coins[]可能包含零钱1，2，5的子集，要凑成amount的总数，最少需要多少枚零钱？
// 写的不熟练，需要后续再练习
import java.util.Arrays;

public class CoinExchange {

    public int coinChange(int[] coins, int amount) {

        if (amount < 0) return -1;
        // 动态规划：自底向上：
        int[] dp = new int[amount + 1];
        // dp[i]表示凑成金额i所需的最少硬币数
        for (int i = 1; i <= amount; i++) dp[i] = amount + 1;
        // 初始化为一个很大的数，amount+1表示不可能
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int coin : coins)
                if (i >= coin)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] == amount + 1 ? -1 : dp[amount];
        // amount==-1时，返回-1，否则返回这个值

    }

    // 解法二:动态规划，优化版

    public int coinChange2(int [] coins, int amount){
        int[]dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int coin:coins)
            for (int i=coin; i<=amount;i++)
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
