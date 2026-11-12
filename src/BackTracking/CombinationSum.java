package BackTracking;
// 39. 组合总和：

    /*
    给你一个无重复元素的整数数组 candidates 和一个目标整数 target，
    找出 candidates 中可以使数字和为目标数 target 的所有不同组合，并以列表形式返回。
    candidates 中的同一个数字可以无限制重复被选取 。
    如果至少一个数字的被选数量不同，则两种组合是不同的。 
    对于给定的输入，保证和为 target 的不同组合数少于 150 个。
    你可以按任意顺序返回这些组合。

    */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    
    // 回溯：经典模板
    // 以下是启动方法：先创建内外两个数组列表
    // 然后调用回溯的深度优先搜索办法:
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> path =new ArrayList<>();
        // 创建两个数组列表做好内外循环嵌套
        Arrays.sort(candidates);
        dfs(candidates, target, 0,path,result);
        return result;
    }

    // 深度优先搜索：
    private void dfs(int []candidates, int target,int start, List<Integer> path, List<List<Integer>> result){
        if (target==0){
            result.add(new ArrayList<>(path));
            return;
        }
        // 终止条件：找到一组有效组合
        
        for (int i=start; i<candidates.length;i++){
            // 剪枝：如果当前数字已经大于剩余目标，后面的更大，直接跳出
            if (candidates[i]>target) break;
            path.add(candidates[i]);
            // 关键：i保持不变，表示可以重复使用同一个元素。
            dfs(candidates, target-candidates[i], i, path, result);
            path.remove(path.size()-1);
            // 撤销选择
        }
    }

    // 示范代码：没有数组排序所以快了些
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTracing2(candidates, 0, new ArrayList<>(), res, target, 0);
        return res;
    }

    private void backTracing2(int[] nums, int start, List<Integer> buffer, List<List<Integer>> res, int target, int sum) {
        if (start > nums.length || sum > target) return;
        // 超出界限或者当前结果总额超出需求总和
        if (sum == target) res.add(new ArrayList<>(buffer));
        // 找到一组结果
        for (int i = start; i < nums.length; i++) {
            buffer.add(nums[i]);
            backTracing2(nums, i, buffer, res, target, sum + nums[i]);
            buffer.remove(buffer.size() - 1);
        }
    }


}
