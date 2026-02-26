public class RainWaterTrappings {
    public int trap(int[]nums){
        if (nums.length==0||nums==null) return 0;
        int l =nums.length;
        int leftMax=0;
        int rightMax=0;
        int left=0;
        int right=l-1;
        int result=0;
        while(left<right){
            leftMax=Math.max(leftMax,nums[left]);
            rightMax=Math.max(rightMax,nums[right]);
            if (leftMax<rightMax){
                result+=(leftMax-nums[left]);
                left++;
            }
            if (rightMax>=leftMax){
                result+=(rightMax-nums[right]);
                right--;
            }
        }
        return result;
    }

    static void main() {
        int []nums={1,3,5,2,5,2,6,8,3,6,3,6,8,3};
        RainWaterTrappings calc = new RainWaterTrappings();  // 创建本类对象
        int result = calc.trap(nums);         // ✅ 通过对象调用实例方法
        System.out.println(result);
        //一定要创建对象调用方法，要不然就是将方法设置成为static静态方法

    }




}
