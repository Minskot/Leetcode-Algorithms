public class MaxSubArray {

    //First: try the O(n^2) method:
    public int maxSubArray1(int[]nums){
        if(nums.length==0||nums==null) return -1;
        int l=nums.length;
        int result=nums[0];
        for (int i=0;i<l;i++){
            int sum=0;
            for(int j=i;j<l;j++){
                sum+=nums[j];
                result=Math.max(result,sum);
            }
        }
        return result;
    }

    //Dynamic Planning 动态规划 /Kadane Algorithm O(n)time，O(1)space
    int maxSubArray(int[]nums){
        if(nums.length==0||nums==null) return -1;
        int l=nums.length;
        int currentMax=nums[0];
        int globalMax=nums[0];
        for (int i=1;i<l;i++){
            currentMax=Math.max(nums[i],currentMax+nums[i]);
            globalMax=Math.max(currentMax,globalMax);
        }
        return globalMax;
    }



    static void main() {
        int []nums={2,4,-1,5,-2,5,-7,2};
        MaxSubArray msa=new MaxSubArray();
        int ans=msa.maxSubArray(nums);
        System.out.println(ans);


    }



}
