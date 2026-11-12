package Tricks;

// 颜色分类：将0，1，2的数组按顺序排序

public class SortColors {
    public void sortColors(int[] nums) {
        // 尝试使用三路快排算法进行排序：
        dfs(nums, 0, nums.length - 1);
    }

    public void dfs(int[] arr, int left, int right) {
        if (left >= right) return;
        int l = left, r = right, i = left;
        int pivot = arr[left];
        while (i <= r) {
            if (arr[i] < pivot) {
                swap(arr, i, l);
                i++;
                l++;
            } else if (arr[i] > pivot) {
                swap(arr, i, r);
                r--;
            } else {
                i++;
            }
        }
        dfs(arr, left, l - 1);
        dfs(arr, r + 1, right);
    }

    public void sortColors2(int[] nums) {
        // 来自于leetcode代码示例：
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) swap(nums, i, p1);
                p0++;
                p1++;
            }
            else if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

