package HashAndNormalArrays;
// 189.轮转数组

public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k % n;               // 处理 k > n
        if (k == 0) return;      // 无需旋转
        int[] ans = new int[n];

        for (int i = n - k; i < n; i++) ans[i - (n - k)] = nums[i]; // 后 k 个元素放到新数组前 k 个位置
        for (int i = 0; i < n - k; i++) ans[i + k] = nums[i]; // 前 n-k 个元素放到新数组后 n-k 个位置
        System.arraycopy(ans, 0, nums, 0, n); // 复制回原数组
    }

    public void rotate2(int[] nums, int k) {
        // deepseek: 三次反转法：更简单
        int n = nums.length;
        k = k % n;
        if (k == 0) return;

        reverse(nums, 0, n - 1);  // 反转整个数组
        reverse(nums, 0, k - 1);  // 反转前 k 个
        reverse(nums, k, n - 1);      // 反转后 n-k 个
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}



