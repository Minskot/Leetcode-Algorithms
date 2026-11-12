package DynamicPlanning;
// 152. 乘积最大子数组：

// 给你一个整数数组 nums ，请你找出数组中乘积最大的
// 非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

public class MaxProduct {

    // 不能用滑动窗口：求和可以用滑动窗口，因为求和具有单调性，但乘积不具备单调性
    public int maxProduct (int[]nums){
        if (nums.length==0||nums==null) return -1;

        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 注意这里的循环从1开始而不是0；

            int cur = nums[i];
            int tempMax = Math.max(cur,Math.max(max * cur, min * cur));
            int tempMin = Math.min(cur,Math.min(max * cur, min * cur));

            max = tempMax;
            min = tempMin;
            ans = Math.max(ans, max);
        }

        return ans;
    }

    // 更优雅的写法（利用负数交换） 这是很多面试官最喜欢看到的写法。
    // 乘负数以后,最大转换成最小,因此可以先交换。

    class Solution {
        public int maxProduct(int[] nums) {

            int max = nums[0];
            int min = nums[0];
            int ans = nums[0];

            for (int i = 1; i < nums.length; i++) {

                if (nums[i] < 0) {
                    int t = max;
                    max = min;
                    min = t;
                }

                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);

                ans = Math.max(ans, max);
            }

            return ans;
        }
    }

    // B站视频解答，华南溜达虎
    public int maxProduct3(int[] nums) {
        if(nums.length==0||nums==null) return -1;

        int maxres=nums[0];
        int curmax=nums[0], curmin=nums[0];

        for (int i=1;i<nums.length;i++){
            int tempmax=curmax, tempmin=curmin;

            curmax=Math.max(tempmin*nums[i],Math.max(tempmax*nums[i],nums[i]));
            curmin=Math.min(tempmax*nums[i],Math.min(tempmin*nums[i],nums[i]));
            maxres=Math.max(curmax,maxres);
        }
        return maxres;
    }




}



