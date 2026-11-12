package HashAndNormalArrays;
// 88. 合并两个有序数组：

public class MergeTwoArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;      // nums1 有效部分最后一个
        int p2 = n - 1;      // nums2 最后一个
        int p = m + n - 1;   // 合并后的最后一个位置

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--]=(nums2[p2]>=nums1[p1])?nums2[p2--]:nums1[p1--];
        }
        // 如果 nums2 还有剩余，直接复制
        while (p2 >= 0) nums1[p--] = nums2[p2--];

    }


    public static void main(){
        MergeTwoArrays mta=new MergeTwoArrays();
        int nums1[]={1,2,5,0,0,0};
        int nums2[]={3,4,6};
        mta.merge(nums1,3,nums2,3);
        for (int num:nums1) System.out.print(num);

    }

}
