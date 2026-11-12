package BackTracking;
// 78. 子集：subsets

/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // 回溯法：推荐，最通用
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        // 创建内外嵌套数组列表，储存当前排列和最终统合结果
        dfs(nums,0,path,result);
        // 调用深度优先搜索，从首位元素开始
        return result;
    }


    private void dfs(int []nums,int start,List<Integer> path, List<List<Integer>>result){
        result.add(new ArrayList<>(path));
        // 结果的数组列表加入当前的数组列表
        for (int i=start; i<nums.length;i++){
            // 从当前元素开始，遍历开始的元素位置
            path.add((nums[i]));
            // 当前排列的结果，加入当前遍历到的元素
            dfs(nums,i+1,path,result);
            // 递归调用方法，深度优先搜索
            // start控制下一步只能从当前位置之后开始选
            // 避免了重复选择同一个元素，保证了组合相同但排列不同的结果不会同时出现
            // 对比全排列：，每次从头开始选，需要used数组，子集使用组合数，使用start
            path.remove(path.size()-1);
            // 撤销当前选择：将当前的path结果清除
        }

    }

    // 解法二：迭代法（二进制枚举）
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // 总共有 2^n 个子集
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // 检查第 i 位是否为 1
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    /*
    78.子集
    子集和全排列的区别是不在乎顺序，相同元素的不同排列时同一子集
    所以使用start参数保证只能往后选，
    永远不会回头选到重复组合，
    子集是每个节点都在收集答案

    */

}
