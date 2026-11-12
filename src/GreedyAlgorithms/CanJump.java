package GreedyAlgorithms;
// 55. 跳跃游戏
// 给你一个非负整数数组 nums，你最初位于数组的第一个下标。
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。

public class CanJump {
    public boolean canJump(int[] nums){

        // deepseek:维护一个最远可到达位置，遍历数组时不断更新，如果当前位置无法到达则返回 false。

        int maxReach=0;
        for (int i=0;i<nums.length;i++){
             if (i>maxReach) return false;  // 这个位置超出了能从起点到达的最远范围
             maxReach=Math.max(maxReach,i+nums[i]);  // max(之前记录的最大值,当前位置加上当前数值)
             if (maxReach>=nums.length-1) return true;
        }
        return true;
    }

    // 简化版：
    public boolean canJump2(int []nums){
        int maxReach=0;
        for (int i=0;i<maxReach;i++){
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;

        }
        return false;
    }

}



