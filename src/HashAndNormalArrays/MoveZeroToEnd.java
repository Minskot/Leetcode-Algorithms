package HashAndNormalArrays;
// move all zeros to end of the array and report:

public class MoveZeroToEnd {

    public void moveZeroToEnd(int []nums){
        if (nums==null) return;
        int l=nums.length;
        int left=0;
        for (int right=0;right<l;right++){
            // 左指针从0开始，每交换一次增加1
            // 遍历数组：右指针从0到末尾，如果非0则交换左指针和右指针的元素
            if (nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
        }

        System.out.println("All zeros has been moved to the end of array, there are "+(l-left)+"zeros in total.");

    }

    public void swap(int []nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;

    }

    public static void main(){
        MoveZeroToEnd mzte=new MoveZeroToEnd();
        int nums[]={1,0,2,0,3,4,5,0,6,0,7,0,8,0};
        mzte.moveZeroToEnd(nums);
        for (int num:nums) System.out.print(num);
    }

}


