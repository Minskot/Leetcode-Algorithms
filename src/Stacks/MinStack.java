package Stacks;
// 155. 最小栈
/*

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:

MinStack() 初始化堆栈对象。 初始化两个栈
void push(int value) 将元素 value 推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。


*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    // 辅助栈方法：最推荐，使用两个栈，存储所有值对应的最小值
    private Stack<Integer> stack;
    // 主栈，存储所有元素
    private Stack<Integer> minStack;

    // 辅助栈，存储当前最小值，并且使得时间复杂度是O（1）
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int value) {
        stack.push(value); // 把新的元素放进主栈
        if (minStack.isEmpty() || value < minStack.peek()) minStack.push(value);
            // 把当前最小值放进辅助栈，两个栈的长度一样
            // 辅助栈的每一个位置，存储主栈对应位置以下所有元素中的最小值
            // 如果主栈是空的，或者新元素比辅助栈顶数值更小，压入栈
        else minStack.push(minStack.peek());
        // 如果辅助栈非空并且新元素大于等于辅助栈顶值：复制栈顶元素

    }

    public void pop() {
        stack.pop();
        minStack.pop();
        // 将两个栈的栈顶元素出栈

    }

    public int top() {
        return stack.peek();
        // 返回主栈栈顶

    }

    public int getMin() {
        return minStack.peek();
        // 返回辅助栈栈顶元素
    }





/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */



class MinStack2{
    // leetcode示范代码：
    // 使用Deque而不是stack， Deque是接口，通常用ArrayDeque或者LinkedList
    // 更快，无锁， Java官方推荐使用Deque作为栈，运行速度更快
    // 辅助栈的优化：只在必要时存储最小值：
    Deque<Integer> stack;
    Deque<Integer> minStack;



    public MinStack2() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push2(int val) {
        stack.push(val);
        if (minStack.size() == 0 || minStack.peek() >= val) minStack.push(val);
        // 当最小栈为空，或者入栈的值比当前更小的时候才存入
    }

    public void pop2() {
        int temp = stack.pop();
        // 使用temp记录要弹主栈的值
        if (minStack.peek() == temp) minStack.pop();
        // 弹出的值和当前最小值相等的时候弹出
    }

    public int top2() {
        return stack.peek();
    }

    public int getMin2() {
        return minStack.peek();
    }

}


}
















