import java.util.HashMap;
import java.util.Map;
//560 和为k的子数组
public class SubArraySum {

    //Method1: use two nested loops:
    public int subArraySum1(int[]nums,int k) {
        int l = nums.length;
        if (l == 0 || nums == null) return -1;
        int count=0;
        for (int i = 0; i < l; i++) {
            int sum=0;
            for (int j=i;j<l;j++) {
                sum += nums[j];
                if (sum == k) count += 1;
            }
        }
        return count;
    }


    //Deepseek: use HashMap: 还是不会写
    public int subArraySum(int []nums,int k){
        if (nums == null || nums.length == 0) return 0;

        // 前缀和 -> 出现次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 初始化：前缀和为0出现1次（表示空数组）
        prefixSumCount.put(0, 1);

        int count = 0; int prefixSum = 0;

        for (int num : nums) {
            // 计算当前前缀和
            prefixSum += num;

            // 核心：如果存在 prefixSum - k 的前缀和
            // 说明从那个位置到当前位置的子数组和为 k
            count += prefixSumCount.getOrDefault(prefixSum - k, 0);

            // 更新当前前缀和的出现次数
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }


    static void main() {
        int []nums={6,2,4,2,1};
        int k=6;
        SubArraySum sas=new SubArraySum();
        int ans=sas.subArraySum(nums,k);
        System.out.println(ans);
    }
}
