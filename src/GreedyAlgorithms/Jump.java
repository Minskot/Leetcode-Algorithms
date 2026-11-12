package GreedyAlgorithms;
// 45. 跳跃游戏2：
/*
    给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
    每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。
    换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
    0 <= j <= nums[i] 且 i + j < n;
    返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。

 */


public class Jump {
    // 解法一：贪心算法：最少步数到达终点
    // 在当前的跳跃范围内，选择能挑到的最远的位置
    // 贪心策略：每次跳跃都跳到“能覆盖最远距离”的位置

    public int jump(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        // Carl认为，需要加上一个边界条件的判断：
        if(nums.length==1) return 0;

        int jumps=0;
        // 已经跳的次数
        int currentEnd=0;
        // 当前跳跃能到达的最远位置，本次跳跃的边界
        int farthest=0;
        // 所有可到达位置中能到达的最远位置

        for (int i = 0; i < nums.length-1; i++) {
            // 我们只需要考虑到达最后一个位置之前的跳跃
            // 如果i==nums.length-1, 已经到达终点，无需再跳
            farthest=Math.max(farthest,i+nums[i]);
            // 更新在目前进度中所能到达的最远位置
            // 如果当前能跳得更远，更新。
            if(i==currentEnd){
                // i==currentEnd: 增加跳跃次数，
                // currentEnd是当前跳跃能到达的最远位置
                // i到达currentEnd时，说明当前跳跃的范围已结束
                // 必须增加一次跳跃，把下次跳跃的边界设置为farthest
                jumps++;
                currentEnd=farthest;
            }
        }

        return jumps;

    }

    // 以下是进阶版的算法，更直观的算法：
    public int jump2(int []nums){
        int jumps=0;  // 需要的步数
        int maxReach=0;  // 在所有可达位置中，当前能够到的最远位置
        int steps=0;   //  当前这一步能走到的边界（还需要走几步才必须跳）

        for (int i = 0; i < nums.length-1; i++) {
            // 遍历数组中的每一个元素
            maxReach=Math.max(maxReach,i+nums[i]);
            // 更新当前能够到的最远位置
            if (i== steps){
                // 到达当前这一步的边界时，必须跳一次
                jumps++;
                steps=maxReach;
            }
        }

        return jumps;
    }


    // 下面是Carl的完整算法思路：
    public int carlJump(int []nums){
        if (nums.length==1) return 0;
        // 边界条件的处理：数组只有一个元素
        // 如果数组中只有一个元素，起始位置就已经终点，所以就不再需要跳越
        int cover=0;
        // 标记当前的覆盖范围
        int next=0;
        // 下一步的覆盖范围：如果当前覆盖范围没有到终点，就启动下一步的覆盖范围
        int result=0;
        // 最终结果需要跳跃几步

        // 循环：开始遍历数组，在覆盖范围内判断
        for (int i = 0; i < nums.length; i++) {
            next=Math.max(next,nums[i]+i);
            // next记录的是覆盖范围内最大下一跳
            if(i==cover){
                // 如果已经到达覆盖范围
                if (cover!= nums.length-1){
                    // 如果当前覆盖到的范围不能到达终点：
                    result++;
                    // 记录的跳数增加
                    cover=next;
                    // 跳到最大下一跳
                    if (cover>= nums.length-1) break;
                    // 一旦覆盖到终点立即break结束
                }
                else break;
                // 如果当前覆盖到的范围可以包含终点：立即break
            }
        }
        return result;
    }

    // 下面是一个录友写的精简版算法思路：
    public int luyouJump(int []nums){
        int cover=nums[0];
        int minJump=0;
        int end =0;
        for (int i=1;i< nums.length;i++){
            if (i>end){
                end=cover;
                minJump++;
            }
            //
            cover=Math.max(cover, i+nums[i]);
            // 更新最大能覆盖到的范围
        }
        return minJump;
    }


    // 动态规划思路解法 跳跃游戏2
    // 将动态规划过程视为上台阶，使用cur和next两个变量实现O(1)的空间复杂度
    public int dpJump(int [] nums){
        int n= nums.length;
        int cur=0,next=0;
        int level=0;

        for (int i = 0; i < n-1; i++) {
            next=Math.max(next,i+nums[i]);
            if (i==cur){
                // 如果走到了能到达的最远距离：上台阶走下一步
                level++;
                cur=next;
            }
        }
        return level;
    }

}
