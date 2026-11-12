package Stacks;//有效括号问题，用stack结构解决
import java.util.Stack;
public class ValidParentheses {
    public boolean isValidZero(String s) {
        // 字符串长度为奇数，直接返回false
        if (s.length() % 2 != 0) return false;
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack[++top] = c;
            else {
                if (top == -1) return false;
                char open = stack[top--];
                if (c == ')' && open != '(') return false;
                if (c == ']' && open != '[') return false;
                if (c == '}' && open != '{') return false;
            }
        }
        return top == -1;
    }


    public boolean isValid2(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 遇到左括号，压入栈
            if (c == '(' || c == '[' || c == '{') stack.push(c);

            // 遇到右括号，检查栈顶是否匹配
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        // 最后栈应为空（所有括号都匹配完毕）
        return stack.isEmpty();
    }
}


