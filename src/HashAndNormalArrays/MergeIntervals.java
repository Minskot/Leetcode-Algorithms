package HashAndNormalArrays;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // 边界条件：null或空数组返回空数组（符合常规逻辑）
        if (intervals == null || intervals.length == 0) return new int[0][2];
        // 边界条件：只有一个区间，直接返回
        if (intervals.length == 1) return intervals;

        // 核心步骤1：按区间左端点升序排序（必须！）
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // 核心步骤2：用List存储合并后的区间
        List<int[]> mergedList = new ArrayList<>();
        // 先加入第一个区间作为初始合并区间
        mergedList.add(intervals[0]);

        // 核心步骤3：遍历剩余区间，逐个合并
        for (int i = 1; i < intervals.length; i++) {
            // 获取已合并的最后一个区间
            int[] lastMerged = mergedList.get(mergedList.size() - 1);
            int[] current = intervals[i];

            // 判断是否重叠：当前区间左端点 ≤ 最后一个合并区间的右端点
            if (current[0] <= lastMerged[1]) {
                // 合并：更新最后一个区间的右端点为两者最大值
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                // 不重叠，加入当前区间
                mergedList.add(current);
            }
        }

        // 核心步骤4：List转为二维数组返回
        return mergedList.toArray(new int[mergedList.size()][2]);
    }

    // 修复：标准main方法，添加String[] args参数
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}};
        MergeIntervals mergeInt = new MergeIntervals();
        int[][] ansNums = mergeInt.merge(intervals);
        // 预期输出：[[1,6],[8,10]]
        System.out.println(Arrays.deepToString(ansNums));
    }


    // merge intervals: 合并区间;自己抄写一遍

    public int[][] merge2(int[][] intervals) {
        if (intervals==null||intervals.length==0) return new int[0][2];
        if (intervals.length==1) return intervals;
        Arrays.sort(intervals,(int[]a,int[]b)->a[0]-b[0]);
        // 这行代码的作用是：将二维数组 intervals 按照每个子数组的第一个元素（即区间起点）进行升序排序。
        List<int[]>mergedList=new ArrayList<>();
        mergedList.add(intervals[0]);
        for (int i=1;i<intervals.length;i++){
            int []lastMerged= mergedList.get(mergedList.size()-1);
            int [] current =intervals[i];
            if (current[0]<=lastMerged[1]) lastMerged[1]=Math.max(lastMerged[1],current[1]);
            else mergedList.add(current);
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
    }

    /**
     解析代码：Arrays.sort(intervals,(int[]a,int[]b)->a[0]-b[0]);

     逐步拆解
     1. Arrays.sort()
     Java 数组的排序方法，用于对数组进行排序。

     2. 第二个参数：自定义比较器
     Arrays.sort() 有多个重载版本，这里使用的是：
     Arrays.sort(T[] a, Comparator<? super T> c)
     第二个参数是一个 Comparator（比较器），用于定义排序规则。

     3. Lambda 表达式

     (int[] a, int[] b) -> a[0] - b[0]
     这是一个 Lambda 表达式，是 Comparator 的简写形式。

     完整写法对比
     Lambda 简写（你的代码）
     Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

     Lambda 完整写法（可省略类型）
     Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

     匿名内部类（传统写法）
     Arrays.sort(intervals, new Comparator<int[]>() {
     @Override
     public int compare(int[] a, int[] b) {
     return a[0] - b[0];  // 按第一个元素升序
     }
     });

     */


    // Leetcode 示范写法：
    public int[][] merge3(int[][] intervals) {
        /*
        差分数组：对 [intervals[i][0], intervals[i][1]] 区间元素增加 1，
        差分数组还原后，如果 d[i] > 0，则说明区间是连通的。
        [1,2] [3,4] 会出现误判情况，对 intervals[i][] * 2 区间 +1，这样区间就被拆分了
        [2,4] [6, 8]
         */
        int mx = 0;
        for (int[] p : intervals) mx = Math.max(mx, p[1]);
        int[] d = new int[2 * mx + 2];
        for (int[] p : intervals) {
            d[2 * p[0]]++;
            d[2 * p[1] + 1]--;
        }
        List<int[]> ans = new ArrayList<>();
        int sum = 0;
        int start = -1;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum > 0) {
                if (start < 0) {
                    start = i;
                }
            } else if (start >= 0) {
                ans.add(new int[]{start / 2, i / 2});
                start = -1;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
