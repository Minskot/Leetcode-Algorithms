//Hash map for two number sum:
import java.util.HashMap;
import java.util.Map;

class sum {
    public int[] twoSum(int[] nums, int target) {
        // 创建哈希表，存储数值和对应的索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 计算需要的补数
            int complement = target - nums[i];
            // 如果补数已经在哈希表中，说明找到了答案
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};
            // 将当前数值和索引存入哈希表
            map.put(nums[i], i);
        }
        // 根据题意，总会有一个答案，所以这里不会执行
        return new int[0];
    }
}
