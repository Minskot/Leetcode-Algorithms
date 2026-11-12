package LeetcodeTrials;

import java.util.ArrayList;
import java.util.List;
// 回溯，深度优先搜索+状态撤销
// 生成一个排列就是决策树上的深度遍历

public class Permute{
    public List<List<Integer>> permute(int []nums){
        List<List<Integer>> result=new ArrayList<>();
        List <Integer> path=new ArrayList<>();
        // path路径，当前已经选择的元素，path记录从根节点到当前节点走过的路径，
        // 当path.size()==nums.length时说明得到一个完整排列

        boolean []used= new boolean[nums.length];
        // 选择列表，通过used数组体现
        
        backtrack(nums,used,path,result);
        return result;    
    }
    
    private void backtrack(int []nums,boolean []used, List<Integer> path, List<List<Integer>> result){
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
            // 结束条件：记录一个完整排列拷贝一份加入结果列表，

        }

        for (int i=0;i<nums.length;i++){
            if (used[i]) continue;
            used[i]=true;
            // 回溯的做选择：标记已经用过这个元素
            path.add(nums[i]);
            // 将当前元素加入路径
            backtrack(nums, used, path, result);
            // 递归深入下一层
            used[i]=false;
            // 撤销选择， 恢复标记
            // 递归返回之后，将状态还原到递归前的样子，防止污染状态，干扰下一次for循环
            path.remove(path.size()-1);
            // 移除状态末尾，回复上一步状态
        }

    }
}