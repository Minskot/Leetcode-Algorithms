package HashAndNormalArrays;
// 3300. 替换为数位和以后最小元素：

import java.util.Arrays;

public class MinElement {


    // deepseek解法：
    public int minElement1 (int[]nums){
        int min=Integer.MAX_VALUE;
        for (int num:nums){
            int digitSum=getDigitSum(num);
            min=Math.min(min,digitSum);
        }
        return min;
    }

    private int getDigitSum(int num){
        // 将数组中的数字全部换成数位和的形式：
        int sum=0; // 数位和
        while(num>0){
            sum+=num%10; // 取最后一位数字
            num/=10; // 数字删去最后一位并向右移动一位
        }
        return num;
    }



    // 我写的：
    public int minElement2(int[] nums) {
        if (nums==null||nums.length<=0) return -1;
        // for (int num:nums){
        // 不能用增强for循环修改数组：增强for循环中的num是原数组元素的副本，不是真实的原数组元素
        int min=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            int num=nums[i];
            int temp=0;

            while(num>0){
                temp+=num%10;
                num/=10;
            }
            nums[i]=temp;
            min=Math.min(min,temp);
        }
        return min;

    }


    public static void main(String[] args) {
        MinElement me=new MinElement();
        int[]nums={11,12,13,14};
        System.out.println(me.minElement2(nums));



    }





    public int minElement3(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int digitSum = 0;
            for (char c : String.valueOf(num).toCharArray()) {
                digitSum += c - '0';
            }
            min = Math.min(min, digitSum);
        }

        return min;
    }


    public int minElement4(int[] nums) {
        return Arrays.stream(nums)
                .map(num -> String.valueOf(num).chars().map(c -> c - '0').sum())
                .min()
                .getAsInt();
    }


}
