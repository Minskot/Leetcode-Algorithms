package BackTracking;
/*

22. 括号生成：
数字 n 代表生成括号的对数，请你设计一个函数，
用于能够生成所有可能的并且有效的括号组合。

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]

 */

import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path, int open, int close, int max) {
        // 终止条件：左括号和右括号都用完了
        if (open == max && close == max) {
            result.add(path.toString());
            return;
        }

        // 1. 可以加左括号：只要左括号数量 < n
        // 遵守规则：右括号的数量不能超过左括号的数量:open < max; close < open
        if (open < max) {
            path.append('(');
            backtrack(result, path, open + 1, close, max);
            path.deleteCharAt(path.length() - 1);
        }

        // 2. 可以加右括号：只有右括号数量 < 左括号数量时才能加
        if (close < open) {
            path.append(')');
            backtrack(result, path, open, close + 1, max);
            path.deleteCharAt(path.length() - 1);
        }
    }
}


