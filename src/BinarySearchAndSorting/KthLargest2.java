package BinarySearchAndSorting;/*
算法题：寻找第 K 大
给定一个整数数组 nums 和一个整数 k，请你返回数组中第 k 大的元素。
这里的“第 k 大”指的是按从大到小排序后的第 k 个元素,不是第 k 个不同的元素
需要在不一定完全排序整个数组的前提下，找到答案
输入：nums = [3,2,1,5,6,4], k = 2
输出：5
解释：从大到小排序后为 [6,5,4,3,2,1]，第 2 大的元素是 5。
回答：
这道题是找数组中第 k 大的元素，注意不是第 k 个不同的元素，数组中可能有重复值。
最直接的做法是先排序，从大到小排序后取第 k 个，时间复杂度是 O(n log n)。
但其实这题不需要完全排序，可以用快速选择（Quick Select）优化到 O(n)。
它的核心思想是基于快排的 partition，每次选一个 pivot，把数组分成三部分：大于、等于、小于。
然后判断第 k 大落在哪一部分，只递归那一边。
举个例子，比如 pivot 是 4，可以分成 [5,6]，[4]，[3,2,1]，如果 k 在左边，就只递归左边。
这样平均时间复杂度是 O(n)，最坏情况是 O(n²)，一般通过随机选择 pivot 来避免。
面试官追问了一下：为什么是 O(n)？
因为每一轮 partition 都会淘汰掉一部分数据，不需要像快排一样递归两边，所以整体是线性的。
又问了 可以用堆吗？
可以，用一个大小为 k 的最小堆，时间复杂度是 O(n log k)，适合数据流场景。

*/
//以上题目来源于代码随想录微信推文：

import java.util.Random;
import java.util.PriorityQueue;
public class KthLargest2 {
    /*
    这是一道非常经典的算法面试题。根据你提供的思路，我为你准备了两种最主流的 Java 实现方式：
    快速选择（Quick Select） 和 最小堆（Min-Heap）。
    方案一：快速选择 (Quick Select)这是面试官最想看到的解法，因为它在平均情况下的时间复杂度是 O(n)。
    它的逻辑类似于快排，但不同点在于：快排会递归处理左右两边，而快速选择只进入包含第 k 大元素的那一部分。
     */

    private final Random random = new Random();
    public int quickFindK(int[] nums, int k) {
        // 第 k 大，对应升序排序后的索引是 nums.length - k
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int targetIndex) {
        if (left == right) return nums[left];
        // 随机选择 pivot 避免最坏情况 O(n^2)
        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (pivotIndex == targetIndex) return nums[pivotIndex];
        else if (pivotIndex < targetIndex) // 在右半部分找
            return quickSelect(nums, pivotIndex + 1, right, targetIndex);
        else // 在左半部分找
            return quickSelect(nums, left, pivotIndex - 1, targetIndex);
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        // 把 pivot 交换到末尾
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        // 把 pivot 换回它最终的位置
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
/*
方案二：最小堆 (Min-Heap)这种方法逻辑最清晰，且非常适合数据流（Data Stream）场景
（即你不知道数组总长度，数据是一个个跳出来的）
我们维护一个大小为 $k$ 的小顶堆，堆顶永远是这 $k$ 个数里最小的。遍历完整个数组后，堆顶就是第 $k$ 大。
 */

    public int minHeap(int[] nums, int k) {
        // Java 默认是小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (minHeap.size() < k) minHeap.offer(num);
            else if (num > minHeap.peek()) {
                // 如果当前数比堆顶（当前前 k 大里的最小者）还大
                // 说明堆顶不再是前 k 大了，踢出堆顶，加入当前数
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        // 遍历结束，堆中剩下的就是最大的 k 个数，堆顶就是第 k 大
        return minHeap.peek();
    }
}










