package AssignmentDraft;
// 两数之和 ACM格式写法

import java.util.*;
public class ACMTwoSum {
    // 实际的示范中，class名是Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 读取数组长度
        int n = sc.nextInt();

        // 2. 读取数组元素
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // 3. 读取目标值
        int target = sc.nextInt();

        // 4. 核心算法：两数之和
        int[] result = twoSum(nums, target);

        // 5. 输出结果
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}




