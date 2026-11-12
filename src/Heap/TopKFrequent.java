package Heap;
import java.util.*;
// 347. 前K个高频元素：

// 给你一个整数数组 nums 和一个整数 k，返回其中出现频率前 k 高的元素。

public class TopKFrequent {

    // 解法一：最小堆(最优解)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap=new HashMap<>();
        for (int num:nums) freqMap.put(num,freqMap.getOrDefault(nums,0)+1);
        // 使用Map统计每个元素的出现频率

        // 使用最小堆，堆中存储的是[元素，频率]；
        PriorityQueue< int[]> minHeap=new PriorityQueue<>(
                (a,b)-> a[1]-b[1]
        );
        // 按照频率升序排列

        for (Map.Entry<Integer,Integer> entry:freqMap.entrySet()){
            // 遍历频率表，维护大小为k的堆
            int num=entry.getKey();
            int freq=entry.getValue();

            minHeap.offer(new int[] {num,freq});

            if (minHeap.size()>k) minHeap.poll();
            // 移除频率最小的元素
        }

        // 取出堆中的元素
        int []result=new int [k];
        for (int i=0;i<k;i++) result[i]=minHeap.poll()[0];

        return result;
    }

    //解法二：桶排序（更高效）

    public int[] topKFrequent2(int[] nums, int k) {
        
        // 1. 统计频率
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 2. 创建桶，桶的索引是频率
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // 3. 从高频到低频遍历桶
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        // 转换为数组返回
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

}
