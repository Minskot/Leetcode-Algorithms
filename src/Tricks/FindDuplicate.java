package Tricks;
// 287. 寻找重复数
import java.util.HashSet;

// 我的办法: 哈希集合
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if (nums==null||nums.length<=1) return -1;
        HashSet<Integer> set=new HashSet<>();

        for (int num:nums){
            if (!set.contains(num)) set.add(num);
            else return num;
        }
        return -1;
    }

    // 示例代码 Floyd判圈法：
    public int findDuplicate2(int[] nums) {
        int fast=nums[0],slow=nums[0];
        do{
            fast=nums[nums[fast]];
            slow=nums[slow];
        }while(fast!=slow);
        fast=nums[0];
        while(slow!=fast){
            fast=nums[fast];
            slow=nums[slow];
        }
        return fast;
    }
}
