package BinarySearchAndSorting;
// 34. 在排序数组中查找元素的第一个和最后一个位置
// 在一个数组中，一个元素可能出现过很多次，这个算法需要返回这个元素出现的第一个和最后一个位置：


public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        int l=nums.length;
        int poi=midSearch(nums,0,l-1,target);
        if (poi==-1) return new int[]{-1,-1};

        int m=poi, n=poi;
        while(m>0&&nums[m-1]==target) m--;
        while(n<l-1&&nums[n+1]==target) n++;
        return new int[]{m,n};
    }

    private int midSearch(int []nums,int left,int right,int target){
        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target) return mid;
            else if(nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return -1;
    }

    // 方案二：使用两次二分查找，更高效

    public int[]searchRange2(int []nums,int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = findFirst(nums, target);
        if (left == -1) return new int[]{-1, -1};
        int right = findLast(nums, target);
        return new int[]{left, right};
    }

    private int findFirst(int []nums,int target){
        int left=0,right= nums.length-1;
        int result=-1;
        while(left<right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return result;
    }

    private int findLast(int[]nums,int target) {
        int left=0, right=nums.length-1;
        int result=-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                result=mid;
                left=mid+1;
            }
            else if (nums[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return result;

    }


    public static void main (String[] args){
        SearchRange sr=new SearchRange();
        int nums[]={2,3,4,5,4,7};
        int ans[]=new int[2];
        ans=sr.searchRange(nums, 4);
        for (int i:ans) System.out.print(i+" ");

    }
    
}
