package HashAndNormalArrays;

//88. 合并两个有序数组
class MergeTwoSortedArrays{
    public void mergeTwoSortedArrays(int[]nums1,int m,int []nums2,int n) {
        if (m==0||n<=0) return;
        int p0=m+n-1;
        int p1=m-1;
        int p2=n-1;
        
        while(p0>=0&&p1>=0&&p2>=0){
            nums1[p0--]=(nums2[p2]>=nums1[p1])?nums2[p2--]:nums1[p1--];
        }
        while(p2>=0) nums1[p0--]=nums2[p2--];
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays mtsa=new MergeTwoSortedArrays();
        int nums1[]={1,4,7,9,0,0,0};
        int nums2[]={3,5,10};
        mtsa.mergeTwoSortedArrays(nums1, 4, nums2, 3);
        for (int num:nums1) System.out.print(num+" ");
    
    }

}