package HashAndNormalArrays;

import java.util.*;

// 1331 数组序号转换：
// 创建一个新的数组，原数组中的每一个元素换成排序后的顺序：


public class ArrayRankTransform {

    public int[] arrayRankTransform(int []arr){
        int []sorted= arr.clone();
        Arrays.sort(sorted);

        Map<Integer,Integer>rankMap=new HashMap<>();
        int rank=1;
        for (int num:sorted)
            if (!rankMap.containsKey(num))
                rankMap.put(num,rank++);

        int [] res=new int[arr.length];
        for (int i=0;i<arr.length;i++)
            res[i]=rankMap.get(arr[i]);

        return res;


    }

    //解法二：使用 TreeMap（自动排序）

    public int[] arrayRankTransform2(int[] arr) {
        // TreeMap 自动按键排序
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // 先存入所有元素（去重）
        for (int num : arr) {
            map.put(num, 0);
        }

        // 分配序号
        int rank = 1;
        for (int key : map.keySet()) {
            map.put(key, rank++);
        }

        // 替换原数组
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }



}
