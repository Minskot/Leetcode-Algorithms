package HashAndNormalArrays;

public class ProductExceptSelf {

    //暴力方法：超时
    /*
        public int[] productExceptSelf(int[] nums) {
            if (nums==null||nums.length==0) return new int[]{-1};
            int []res=new int[6];
            int l=nums.length;
            for (int i=0;i<l;i++){
                int product=1;
                for (int j=0;j<l;j++){
                    if (j==i) continue;
                    product*=nums[j];
                }
                res[i]=product;
            }
            return res;
        }
     */

    //题目描述不要使用除法
    /*
    public int[] productExceptSelf(int[] nums) {
        if (nums==null||nums.length==0) return new int[]{-1};
        int l=nums.length;
        int []res=new int[l];
        int allPro=1;
        for (int num : nums) allPro *= num;
        for (int i=0;i<l;i++) res[i]=allPro/nums[i];
        return res;
    }
     */


        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] answer = new int[n];

            // 1. 计算每个位置左边的乘积
            answer[0] = 1;  // 第一个元素左边没有数，乘积为1
            for (int i = 1; i < n; i++) answer[i] = answer[i - 1] * nums[i - 1];

            // 2. 计算每个位置右边的乘积，并直接乘到答案上
            int rightProduct = 1;  // 右边乘积
            for (int i = n - 1; i >= 0; i--) {
                answer[i] = answer[i] * rightProduct;  // 左边乘积 × 右边乘积
                rightProduct *= nums[i];  // 更新右边乘积，为下一个位置准备
            }

            return answer;
}
//双数组版本：
    public int[] productExcSelf(int []nums){
        if (nums==null||nums.length==0) return new int[]{-1};
        int n=nums.length;
        if(n==1) return new int[]{0};


        int []left=new int[n];
        int []right= new int [n];
        int []ans=new int[n];

        left[0]=1;
        right[n-1]=1;
        for (int i=1;i<n;i++) left[i]=left[i-1]*nums[i-1];
        for (int i=n-2;i>=0;i--) right[i]=right[i+1]*nums[i+1];
        for(int j=0;j<n;j++) ans[j]=left[j]*right[j];

        return ans;
        }



        /*
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        // 计算左边乘积
        left[0] = 1;
        for (int i = 1; i < n; i++) left[i] = left[i - 1] * nums[i - 1];

        // 计算右边乘积
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) right[i] = right[i + 1] * nums[i + 1];


        // 合并结果
        for (int i = 0; i < n; i++) answer[i] = left[i] * right[i];

        return answer;
*/





        public static void main(String[] args){
            int []nums={1,2,3,4};
            ProductExceptSelf prs=new ProductExceptSelf();
            int []res=prs.productExcSelf(nums);
            for( int i=0;i<nums.length;i++) System.out.print(res[i]+" ");
        }
    }

