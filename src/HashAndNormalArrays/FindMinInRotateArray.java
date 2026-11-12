package HashAndNormalArrays;
// leetcode 153 寻找旋转数组中的最小值

public class FindMinInRotateArray {

    public int findMin(int[] nums) {
        int l=nums.length;
        int left=0, right=l-1;

        if(nums[left]<nums[right]) return nums[left];

        while (left<right){
            int mid=(left+right)/2;
            if (nums[mid]>nums[right]) left=mid+1;
            else right=mid;

        }
        return nums[left];

    }
}