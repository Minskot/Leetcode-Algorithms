package DynamicPlanning;

import java.util.Map;

// 198. 打家劫舍： 你只能偷不相邻两间房屋，求所能偷盗的最大值：
public class Rob {

    public int rob(int []nums){

        if (nums==null||nums.length==0) return 0;
        int l=nums.length;
        if (l==1) return nums[0];
        int dp[]=new int[l];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i=2;i<l;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[l-1];
    }

    // 空间优化版：使用三个变量储存值
    // 使用三个变量： prev2储存上两个位置的值dp[i-2];
    // prev1储存上一个位置的值dp[i-1]; cur储存当前位置的值;

    public int rob2(int []nums){
        if (nums==null||nums.length==0) return -1;
        int l=nums.length;
        if (l==1) return nums[0];
        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);

        for (int i = 0; i < nums.length; i++) {
            int cur= Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=cur;

        }
        return prev1;
        // 最后一轮循环中，prev1已经移动到当前位置，所以返回prev1代表cur

    }


}
