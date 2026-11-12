package Stacks;
// 739. 每日温度
// 给定一个整数数组 temperatures，表示每天的温度，返回一个数组 answer，
// 其中 answer[i] 是指对于第 i 天，下一个“更高温度”出现在几天后。
// 如果气温在这之后都不会升高，请在该位置用 0 来代替。


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {

    //单调栈：单调栈的核心用途是找数组中每个元素左边/右边第一个比它大/小的元素。
    // 这道题可以看作是单调栈的最核心原题，是代码随想录使用的原题
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];
        // 创建这个数组储存result，表示每个位置的天数，下一个气温比他高的日期出现在几天之后

        Stack<Integer> stack = new Stack<>();

        // 创建一个单调栈，储存当前温度最高的日期的下标，注意不是温度
        // 当新的遍历到的日期，温度小于等于栈顶日期的温度时，将新的日期的下表压入栈中，
        // 当遍历到的日期的温大于栈顶日期的温度时，将栈顶元素出栈，将栈顶日期的中间间隔写入result数组，
        // 使用while循环，重复检查当前栈顶的元素，将其中的日期与新日期比较，写入结果数组后出栈

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] >
                    temperatures[stack.peek()]) {
                // temp[i]>temp[stack.peek()]表示栈顶那一天的下一个更高温度来了
                int prevIndex = stack.pop();
                // 弹出栈顶元素，
                answer[prevIndex] = i - prevIndex;
                // 计算天数差，写入result数组中
            }
            stack.push(i);
            // 表示新日期的温度不如栈顶元素的温度，将当前下标压入栈，保持单调栈的温度单调递增
        }
        return answer;
    }

    // leetcode示范代码：双向队列

    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < len; i++){

            while(!st.isEmpty()&&temperatures[i] > temperatures[st.peek()]){
                int prev = st.pop();
                ans[prev] = i - prev;
            }
            st.push(i);
        }

        return ans;
    }









}

