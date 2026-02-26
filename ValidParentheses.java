//有效括号问题，用stack结构解决

public class ValidParentheses {
    public boolean isValid(String s) {
        // 字符串长度为奇数，直接返回false
        if (s.length() % 2 != 0) return false;
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1) return false;
                char open = stack[top--];
                if (c == ')' && open != '(') return false;
                if (c == ']' && open != '[') return false;
                if (c == '}' && open != '{') return false;
            }
        }
        return top == -1;
    }
}
