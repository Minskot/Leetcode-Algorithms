import java.util.Random;
public class KthLargest {
        private Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            // 第k大等价于第n-k+1小
            int n = nums.length;
            int targetIndex = n - k;  // 在排序后数组中第k大的位置索引

            return quickSelect(nums, 0, n - 1, targetIndex);
        }

        private int quickSelect(int[] nums, int left, int right, int targetIndex) {
            // 如果左右指针相等，直接返回该元素
            if (left == right) {
                return nums[left];
            }

            // 随机选择基准元素并分区
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                // 在右侧继续查找
                return quickSelect(nums, pivotIndex + 1, right, targetIndex);
            } else {
                // 在左侧继续查找
                return quickSelect(nums, left, pivotIndex - 1, targetIndex);
            }
        }

        private int partition(int[] nums, int left, int right) {
            // 随机选择基准元素，避免最坏情况
            int randomIndex = left + random.nextInt(right - left + 1);
            swap(nums, randomIndex, right);

            int pivot = nums[right];
            int i = left - 1;

            // 将小于pivot的元素放到左边
            for (int j = left; j < right; j++) {
                if (nums[j] <= pivot) {
                    i++;
                    swap(nums, i, j);
                }
            }

            // 将基准元素放到正确位置
            swap(nums, i + 1, right);
            return i + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

