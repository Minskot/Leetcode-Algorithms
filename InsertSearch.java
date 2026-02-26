public class InsertSearch {
    public int searchInsert(int[] nums, int target) {
        int l= nums.length; int mid= nums.length/2;
        while(nums[mid]!=target&&l>=1){
            if(nums[mid]<target) mid=mid+l/2;
            if(nums[mid]>target) mid=mid-l/2;
            l/=2;
        }
        if (target==nums[mid]) return mid;
        else {
            if(nums[mid]>target) return mid-1;
            else return mid+1;
        }
    }


    /*
    static void main() {
        int []nums={1,5,7,9,11,14,16,24};
        int target=12;
        int rel= searchInsert(nums,target);
        print(rel);
    }
*/

}
