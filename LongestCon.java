import java.util.HashSet;
import java.util.Set;

class LongestCon{

    public static int longestRow(int[]nums){
        if(nums==null||nums.length==0) return 0;
        Set<Integer>set=new HashSet<>();
        for (int num:nums) set.add(num);
        int result=1;
        for(int num:set){  //我在这里出错：写成了num:nums:会重复计算相同元素：导致超时
            if (!set.contains(num-1)){
                int length=1;
                int cur=num;
                while(set.contains(cur+1)){
                    length++;
                    cur++;
                }
                result=Math.max(result,length);
            }
        }
        return result;
    }
static void main(){
    int []arr={1,4,65,7,2,5,5,7,3};
    int ans=longestRow(arr);
    System.out.println(ans);
}

}