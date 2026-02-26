class SearchInsertPlace {

        public static int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

    static void main() {

        int []nums = {1,3,5,6};
        int target = 7; //应该返回1，但实际上返回的是-1


        System.out.print(binarySearch(nums,target));
    }
}