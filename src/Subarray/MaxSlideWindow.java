package Subarray;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlideWindow {



//滑动窗口最大值：给出数组nums以及滑动窗口，给出在窗口中出现的数值之和的最大值：

        public int[] maxSlidingWindow(int[] nums, int k) {

            //The O(n^2) method: exceed the time limit:
            /*
            if (nums==null||nums.length==0||k==0) return new int[]{-1};
            int l=nums.length; int max;
            int []res=new int[l+1-k];
            for (int i=0;i<=l-k;i++){
                max=nums[i];
                for(int j=i;j<i+k;j++)
                    max=Math.max(nums[j],max);

                res[i]=max;
            }
            return res;
             */
            if (nums == null || nums.length == 0 || k <= 0) {
                return new int[0];
            }

            int n = nums.length;
            int[] result = new int[n - k + 1];

            // 双端队列，存储索引，保证队列中的元素对应的值是递减的
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                // 1. 移除队尾所有比当前元素小的元素（因为它们不可能是最大值了）
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                // 2. 将当前元素索引加入队尾
                deque.offerLast(i);

                // 3. 移除队首不在窗口内的元素
                if (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }

                // 4. 当窗口形成后，记录最大值
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return result;
        }



    public void main(String[] args){
        int []nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        MaxSlideWindow msw=new MaxSlideWindow();
        int[]res=new int[nums.length-k+1];
        res=msw.maxSlidingWindow(nums,k);
        for (int i = 0; i < res.length; i++) System.out.print(res[i]);

    }
}



