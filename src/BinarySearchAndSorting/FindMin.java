package BinarySearchAndSorting;
// 寻找旋转排序数组中的最小值：



public class FindMin {


    public int findMin(int []nums){
        // 分为上升期和下降期（边界情况：未旋转（nums[0]））
        if (nums==null||nums.length==0) return -1;

        int left=0, right= nums.length-1;
        if (nums[left]<nums[right]) return nums[left]; // 相当于未旋转

        while(left<right){

            int mid=left+(right-left)/2;

            if (nums[mid]>nums[right]) left=mid+1;
                // 中点在第一段，最小值在右边
            else right=mid;
            // 中点在第二段，最小值在左边
        }


        return nums[left];
    }
}
