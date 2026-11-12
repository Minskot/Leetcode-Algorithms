package DynamicPlanning;
// 300. 最长递增子序列
// 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

public class LengthOfLIS {
    // 动态规划：O（n^2）
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) dp[i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j]+1, dp[i]);

            maxLen=Math.max(dp[i],maxLen);
        }
        return maxLen;

    }

    // 解法二：贪心+二分查找 O(n log n)

    public int lengthOfLIS2(int []nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] tails = new int[nums.length];
        int len=0;

        for (int num:nums){
            int left=0,right=len;


            while(left<right){
                int mid=left+(right-left)/2;

                if (tails[mid]<num) left=mid+1;
                else right=mid;
            }
            tails[left]=num;
            if (left==len) len++;
        }
        return len;
    }
}
