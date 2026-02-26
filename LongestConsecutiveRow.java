import java.util.HashSet;
import java.util.Set;
//給定一個未排序的整數數組nums， 找出數字連續的最長序列的長度，不要求序列元素在原數組中連續
/**
 * 示例一：
 * 輸入：nums=[100,4,100,1,3,2]
 * 輸出：4
 * 解釋：數字最長序列1，2，3，4， 序列最長長度為4
 *
 * 示例二：
 * nums=[0,3,7,2,5,8,4,6,0,1]
 * 輸出：9
 *
 * */
class LongestConsecutiveRow {
    public static int longestConsecutiveRow(int[] nums){
        Set<Integer>set=new HashSet<>();
        for(int num:nums) set.add(num);
        int result=0;
        for (int num:set){
            if(!set.contains(num-1)){
                int cur=num;
                int length=1;
                while(set.contains(cur+1)){
                    cur++;
                    length++;
                }
                result=Math.max(result, length);
            }
        }
        return result;
    }

    static void main(){
        int []arr={1,3,4,5,6,8,9};
        int res=longestConsecutiveRow(arr);
        System.out.println(res);
    }

}

