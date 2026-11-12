package BackTracking;
// 回溯：46.全排列 给定一个不含重复数字的数组 nums，返回其所有可能的全排列。你可以按任意顺序返回答案。
// 全排列就是把数组中的所有元素按不同顺序排列
// 交换数组中元素的位置，构成所有不同的顺序
// 回溯：backtracking: 暴力枚举+剪枝

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 创建两层嵌套的数组列表
        // path: 路径，已经选择的元素
        // 选择列表：当前还可以选择的元素
        // 终止条件：路径长度==数组长度 -> 找到一个排列
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, used, path, result);
        return result;
    }
    
    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        // 终止条件：找到一个全排列
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // 跳过已经使用过的元素
            // 从剩余元素中选择一个
            if (used[i]) continue;
            
            // 做选择
            used[i] = true;
            path.add(nums[i]);
            
            // 递归进入下一层
            backtrack(nums, used, path, result);
            
            // 撤销选择（回溯）
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }


    // 解法2：交换法，空间优化
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            // 将当前排列加入结果
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 交换
            swap(nums, i, start);
            backtrack(nums, start + 1, result);
            // 恢复（回溯）
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    46. 全排列：每次排列从头开始选，但不能重复选
    所以使用used[], 
    做选择，递归，撤销
    
    */


}
    
