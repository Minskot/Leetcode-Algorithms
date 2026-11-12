package BinarySearchAndSorting;/*
快速排序（Quicksort）是面试和实际开发中最常用的排序算法之一。
它的核心思想是分治法（Divide and Conquer）：通过一趟排序将要排序的数据分割成独立的两部分，
其中一部分的所有数据都比另外一部分的所有数据都要小，然后再递归地对这两部分数据进行快速排序。
 */

public class QuickSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            // partition 过程会找到 pivot 的最终正确位置
            int pivotIndex = partition(nums, low, high);
            // 递归排序左半部分
            quickSort(nums, low, pivotIndex - 1);
            // 递归排序右半部分
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high]; // 选择最右侧的元素作为基准值 (pivot)
        int i = low - 1; // i 指向小于 pivot 区域的边界

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于 pivot
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        // 最后把 pivot 换到它应该在的位置（即 i+1）
        swap(nums, i + 1, high);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 测试一下
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = {3, 5, 8, 1, 2, 9, 4, 7, 6};
        qs.sort(arr);
        for (int n : arr) System.out.print(n + " ");
        // 输出: 1 2 3 4 5 6 7 8 9
    }
}

