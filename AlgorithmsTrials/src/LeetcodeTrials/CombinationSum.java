import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int []candidates, int target){
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        // 初始化时，创建两个数组列表

        Arrays.sort(candidates);
        dfs(candidates,target,0,path,result);
        return result;
    }
    
    private void dfs(int[] candidates,int target, int start,List<Integer>path, List<List<Integer>> result){

        if (target==0){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i=start;i<candidates.length;i++){
            if (candidates[i]>target) break;
            path.add(candidates[i]);
            dfs(candidates, target, start, path, result);
            path.remove(path.size()-1);
        
        }

    }



}
