package Heap;
// 215. 数组中的第K个最大元素


import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargestHeap {
    // 最小堆，可以直接使用Heap的内置数据结构，时间复杂度O（n）;
    public int findKthLargest(int[] nums, int k) {

        if (nums==null||nums.length<=0||k<=0||nums.length<k) return -1;
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        // 创建最小堆，堆顶是堆中最小的元素

        for (int num:nums) {

            minHeap.offer(num);
            if (minHeap.size()>k) minHeap.poll();
            // 保持堆的大小为k

        }
        return minHeap.peek();
        // 堆顶是第k大的元素
    }

    // 方法2： 最大堆
    public int maxHeap(int []nums, int k){

        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        for (int num:nums) maxHeap.offer(num);

        for(int i=0;i<k-1;i++) maxHeap.poll();

        return maxHeap.peek();

    }

    // 解法三：自定义最小堆，不使用Java内置

    public int minHeapSelf(int []nums, int k){

        // 目标是找到数组中的第K大元素，
        // 思路是用最小堆保存最大的k个元素，堆顶就是其中最小的，也就是第k大

        int [] minHeap= new int[k];
        for(int i=0;i<k;i++) minHeap[i]=nums[i];
        // 复制数组，使用数组作为堆的数据结构

        for (int i=k/2-1;i>=0;i--) heapify(minHeap,i,k);
        // 把这个数组变成最小堆，
        // k/2-1是最后一个非叶子节点的索引，从他开始，从下往上对每个节点执行heapify
        // 让每个子树都满足“父节点<=子节点”的堆性质

        for (int i=k;i<nums.length;i++){
            if (nums[i]>minHeap[0]){
                minHeap[0]=nums[i];
                heapify(minHeap,0,k);
            }
        }
        // 处理剩余元素，剩余元素之和堆顶比较
        // 堆顶是堆里最小的元素，如果新的数比最小值大，替换堆顶
        // 在堆中始终保有并维护最大的k个元素

        return minHeap[0];
    }

    private void heapify(int[]heap, int i, int size){
        int smallest=i;
        int left=2*i+1;
        int right=2*i+2;
        // 一个节点和他的两个孩子

        if (left<size&&heap[left]<heap[smallest]) smallest=left;
        // 如果左孩子小于当前节点，最小值指针指向左孩子索引
        if ( right<size&&heap[right]<heap[smallest]) smallest=right;
        // 如果右孩子小于当前节点，最小值指针指向右孩子索引
        if (smallest!=i){
            // 如果最小值是左孩子或者右孩子，交换当前节点与这个孩子的值
            int temp= heap[i];
            heap[i]=heap[smallest];
            heap[smallest]=temp;

            heapify(heap,smallest,size);
            // 以交换后的子节点为基准，继续递归执行heapify
            // 让以i为根的子树满足“父节点小于等于子节点”

        }
    }


}
