/*
找出一个数组之间盛水最多的容器
容器的高度为两个数组元素的较小值，容器的宽度是两个元素之间序号的差值
建议使用的方法是双指针

 */

public class WaterContainer {
    static int maxArea(int[]height) {
        int l = height.length;
        if (l<=1) return -1;
        int left=0;
        int right=l-1;
        int max=(l-1)*(Math.min(height[left],height[right]));
        while(left<right){
            if (height[left] <= height[right]){
                left++;
                max=Math.max(max,((right-left)*(Math.min(height[left],height[right]))));

            }
            else{
                right--;
                max=Math.max(max,(right-left)*(Math.min(height[right],height[left])));
            }
        }
        return max;


        //先试试遍历数组的办法：超时
        /*
        for (; slowPin < l; slowPin++)
            for (fastPin = slowPin + 1; fastPin < l; fastPin++)
                max = Math.max(max, (fastPin-slowPin) * Math.min(height[fastPin], height[slowPin]));
        */

    }

    static void main() {
        int []height={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
