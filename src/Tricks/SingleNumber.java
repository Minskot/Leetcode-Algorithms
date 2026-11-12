package Tricks;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 136. 只出现一次的数字：
// 三种解法：异或（最简单） 哈希表法  排序法

public class SingleNumber {
    public int singleNumber(int []nums){
        int result=1;
        for (int num:nums) result^=num;  // 异或
        return result;

    }

    // 哈希表法：
    public int singleNumber2(int []nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        // 记录每个元素以及他们的出现次数
        for (int key : map.keySet()) if (map.get(key) == 1) return key;
        // 返回出现次数为1的元素
        return -1;

    }


    // 排序法（我自己写的）：
    public int singleNumber3(int []nums){
        Arrays.sort(nums);
        int l=nums.length;
        if (l==1) return nums[0];
        if (nums[0]!=nums[1]) return nums[0];
        if (nums[l-1]!=nums[l-2]) return nums[l-1];
        for (int i=1;i<nums.length-1;i++){
            if (nums[i]==nums[i-1]||nums[i]==nums[i+1]) continue;
            return nums[i];
        }
        return -1;
    }

    // deepseek 排序法
    public int singleNumber4(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];  // 返回第一个2n与2n+1不同的元素
            }
        }
        return nums[nums.length - 1];  // 如果前面都不是，返回最后一个元素
    }

}
