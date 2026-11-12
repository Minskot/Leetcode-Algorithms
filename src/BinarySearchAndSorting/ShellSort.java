package BinarySearchAndSorting;
// 希尔排序
// 增量序列采用half折半

public class ShellSort {
    public static void shellSort(int []arr){
        int n= arr.length;

        for (int gap=n/2;gap>0;gap/=2){
            // 初始增量 gap=n/2,每次减半，直到gap=0,每个分组插入排序
            for (int i=gap;i<n;i++){
                int temp=arr[i];
                int j=i;

                while(j>=gap&&arr[j-gap]>temp){
                    arr[j]=arr[j-gap];
                    j-=gap;
                }
                arr[j]=temp;
            }

        }

    }

    //时间复杂度（平均）：O(n^1.3) ~ O(n^1.5)  时间复杂度（最好）	O(n log n)
    // 空间复杂度	O(1)（原地排序）
    // 稳定性：不稳定（相同元素可能因分组改变相对顺序）

    /*为什么 gap 要不断缩小？
    初始 gap 较大：元素可以“跨大步”移动，快速让较小的元素移到前面、较大的移到后面。

    gap 逐步缩小：分组越来越细，最后 gap = 1 时退化为普通插入排序，此时数组已经基本有序，插入排序的效率很高（接近 O(n)）。

    这种“先粗排、再细排”的策略，让希尔排序比普通插入排序快得多。

     */

    /* 增量序列的改进（可选）
    上面用的是最基本的 Shell 增量序列（n/2, n/4, ..., 1）。
    如果想进一步提高效率，可以用 Hibbard 增量序列（1, 3, 7, 15, ...，即 2^k - 1）：

     */

    // 使用 Hibbard 增量序列
    public static void shellSortHibbard(int[] arr) {
        int n = arr.length;

        // 先找到最大的 Hibbard 增量（小于 n）
        int gap = 1;
        while (gap < n / 3) {
            gap = gap * 2 + 1; // 1, 3, 7, 15, 31, ...
        }

        for (; gap > 0; gap = (gap - 1) / 2) { // 从大到小遍历增量
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    // Hibbard 增量序列的时间复杂度可以达到 O(n^1.5)，比简单折半序列更快。


}
