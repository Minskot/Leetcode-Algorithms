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
}