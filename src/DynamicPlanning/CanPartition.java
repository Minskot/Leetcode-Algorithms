package DynamicPlanning;
// 416. 分割等和子集
// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断
// 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

// 本题本质上是0-1背包问题


public class CanPartition {

    // 方法一：动态规划，二维数组
    public boolean canPartition(int[] nums) {

        int n= nums.length;
        if (n==1){
            if (nums[0]==0) return true;
            if (nums[0]!=0) return false;
        }

        int sum=0;
        for (int num:nums) sum+=num;
        // 计数数组中元素总和

        if (sum%2!=0) return false;
        // 如果总和是奇数：返回错误

        int target=sum/2;
        // 目标是总和的一半

        boolean[][]dp=new boolean[n+1][target+1];
        // 设立二维数组；dp[i][j]表示从前i个元素中能否选出和为j的子集
        for (int i=0;i<=n;i++) dp[i][0]=true;
        // 初始化：和为0总是可以，不选任何元素

        for (int i=1;i<=n;i++){
            // 起点：从第二个数字开始
            for (int j=1;j<=target;j++){
                //
                if (j<nums[i-1]) dp[i][j]=dp[i-1][j];
                // 当前数字太大，不能选
                else dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                // 不选或选
            }
        }
        return dp[n][target];
        // 目标情况是否能满足要求
    }

    // 解法二：动态规划，一维数组，推荐

    public boolean can2(int []nums){
        int sum=0;
        for (int num:nums) sum+=num;
        // 统计数组元素总和
        if (sum%2!=0) return false;
        // 总和为偶数返回false
        int target =sum/2;

        /*
        把问题转化为01背包： 背包容量target，物品是数组中的每个数
        物品重量是数的值，目标是能否恰好装满背包。
        每个数只能用一次，物品的价值等于重量，我们只关心能不能装满
         */

        boolean []dp=new boolean[target+1];
        // 布尔数组
        // dp[j]的含义：能否从已经处理过的元素中，选出一部分，使它们的和恰好为 j
        dp[0]=true;  // 和为0总是可以

        // 下面是状态转移方程，对于当前数字num，对于每个目标容量j：
        // dp[j]:不选当前num，沿用之前的结果
        // dp[j-num] 选当前num，之前要凑出来j-num
        // 两个条件有一个成立了，就证明当前dp[j]=true,可以凑出来这个数字
        for(int num:nums){
            // 从大到小遍历，
            // 对于0-1背包，物品一定要放外循环，背包放内循环，背包倒序遍历
            // 这样做的目的是物品只能遍历一次
            for (int j=target;j>=num;j--)
                dp[j]=dp[j]||dp[j-num];

            /*
            对于当前数字 num，对每个目标容量 j：
            dp[j]：不选当前 num，沿用之前的结果
            dp[j - num]：选当前 num，那么之前要凑出 j - num
            两者只要有一个成立 → dp[j] 为 true
             */

            /*
            为什么是从后往前遍历：如果是从前往后，会导致同一个数字被重复使用；
            就变成了每个数字不限量的题目，本题中每个元素只能用一次
            dp[j-num]可能在本轮已经被更新过，刚使用num填过，会重复使用num
            从后往前 → 每次用到的 dp[j-num] 一定是上一轮的状态，保证每个 num 只用一次。
             */


            // 如果满足两数之和条件的，判别认为true
            }
        return dp[target];
        // 返回结果
    }

    // 解法三：动态规划，位运算，最快

    public boolean can3(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        // 使用 BitSet 表示所有可能的子集和
        java.util.BitSet bits = new java.util.BitSet(target + 1);
        bits.set(0);

        for (int num : nums) {
            // bits 左移 num 位，然后与原 bits 合并
            // 表示在原来的所有可能和的基础上加上 num
            java.util.BitSet shifted = bits.get(0, target + 1 - num);
//位运算这一步            shifted <<= num;
            bits.or(shifted);
        }

        return bits.get(target);
    }
}
