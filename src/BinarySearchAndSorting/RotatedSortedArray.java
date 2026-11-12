package BinarySearchAndSorting;
// 33. 搜索旋转排列数组 注意：这是一道面试高频出现题目
// 解法：二分查找


// 对于旋转排列数组而言，数组中的元素分为两段上升区间，
// 使用二分查找：[4,5,6,7,0,1,2]，第二个上升区间的最大值小于第一个上升区间的最小值


// 分为两种情况：mid在第一个上升区间/第二个上升区间
// 于是在这两种基本情况之下，再分为各自两种情况：
// target在第一个还是第二个上升区间
public class RotatedSortedArray {

    public int search(int[] nums, int target) {

        if(nums==null||nums.length==0) return -1;
        int left=0;
        int right=nums.length-1;
        /*

           ---  第一段上升区间
        ---
    ---
---

                                 ---
                             ---
                        ---
                   ---      第二段上升区间


         */

        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target) return mid;
            // 返回条件：找到目标

            if (nums[left]<=nums[mid]){
                // mid在第一个上升区间
                // 注意这里的细节：<=
                if (nums[left]<=target&&target<=nums[mid])
                    // target在第一个上升区间 注意细节 <=
                    right=mid-1;
                else left=mid+1;
                // target在第二个上升区间

            }

            else {
                //mid在第二个上升区间

                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                    // target在第二个上升区间，[mid,right]区间

                else right = mid - 1;
                // target在第一个上升区间，[left,mid]区间
            }
        }
        return -1;
    }

}
