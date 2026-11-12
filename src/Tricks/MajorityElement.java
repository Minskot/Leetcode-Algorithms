package Tricks;
import java.util.Arrays;
// 169. 多数元素

public class MajorityElement {

    public int majorityElement(int[]nums){
        Arrays.sort(nums);
        int l=nums.length;
        for (int i=0;i<=l/2;i++){
            if (nums[i]==nums[i+l/2]) return nums[i];
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        // 众数一定出现在中间位置
        return nums[nums.length / 2];
    }

    // 摩尔投票法：O(n) time; O(1) space
    public int majorityElement3(int[] nums) {
        int candidate=0,count= 0;  // 当前出现最多元素，计数器
        for (int num : nums) {
            if (count == 0) candidate = num;  // 新元素替换原元素
            count += (num == candidate) ? 1 : -1;   // 当前元素是否与计数元素一致?+1/-1
        }

        return candidate;  // 最后能留下来的元素
    }

    /*
    摩尔投票法（Boyer-Moore Majority Vote Algorithm）
    摩尔投票法是一种在线性时间 O(n) 和常数空间 O(1) 内，找到数组中出现次数超过一半的元素的算法。
    核心原理：不同元素相互抵消，最后剩下的就是多数元素。
    */

}
