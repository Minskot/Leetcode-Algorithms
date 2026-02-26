import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

//滑动窗口问题，三数之和：
public class ThreeSum {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            // 边界条件
            if (nums == null || nums.length < 3) return result;

            // 1. 排序（关键步骤）
            Arrays.sort(nums);

            // 2. 固定第一个数，用双指针找另外两个数
            for (int i = 0; i < nums.length - 2; i++) {
                // 去重：跳过相同的第一个数
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                // 优化：如果当前数大于0，后面的数都大于0，三数和不可能为0
                if (nums[i] > 0) break;
                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i];  // 需要找的两个数和为 -nums[i]

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        // 找到一组解
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // 去重：跳过相同的left和right
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // 移动指针继续寻找
                        left++; right--;
                    }
                    else if (sum < target) left++;  // 和太小，左指针右移
                    else right--; // 和太大，右指针左移
                }
            }

            return result;
        }
    }

