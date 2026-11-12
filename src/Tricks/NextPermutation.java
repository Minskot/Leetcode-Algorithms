package Tricks;
// 31. 下一个排列：
/*
算法原理：找到比当前排列大的，最小的那个排列
如果当前已经是最大的排列，返回最小排列：
对于字典序，要找到恰好比这个数字大的最小的数字，等价于尽量保持高位不变，只改动尽可能靠右的位置

为了找到下一个排列，从右往左找到第一个升序对，满足nums[i]<nums[i+1]
从右往左找到第一个大于nums[i]的树nums[j]
反转i+1到数组末尾的部分，让他变成升序，最小排列

 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. 从右往左找到第一个升序对 (i, i+1) 满足nums[i]<nums[i+1];

        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        // 2. 如果存在这样的 i，找到右边第一个大于 nums[i] 的数
        // i是最后一个变大的位置，之后就是降序的了，
        // 从右往左找到第一个大于nums[i]的数nums[j];
        // j是最小的能替换nums[i]的数，从右往左第一个大于nums[i]的数
        // 从右边开始找是因为右侧是降序的，从右往左第一个大于nums[i]的数就是最小的

        if (i >= 0) {
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) j--;

            // 3. 交换nums[i],nums[j];
            swap(nums, i, j);
        }

        // 4. 反转 i+1 到末尾的部分
        // 反转的目的是，将i+1从原本的降序顺序变成升序的，尽可能大
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }


}
