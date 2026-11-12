package HashAndNormalArrays;
// 找出两个数组中，最小的相同元素
public class MinimalSame {

    public int getCommon (int []nums1,int[]nums2){
        int m=nums1.length,n=nums2.length;
        if (m==0||n==0) return -1;
        int ptr1=0;
        int ptr2=0;
        while(ptr1<m&&ptr2<n){
            if (nums1[ptr1]<nums2[ptr2]) ptr1++;
            else if (nums1[ptr1]>nums2[ptr2]) ptr2++;
            else if (nums1[ptr1]==nums2[ptr2]) return nums1[ptr1];
        }
        return -1;
    }
}
