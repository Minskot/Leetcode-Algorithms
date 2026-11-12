package BackTracking;
import java.util.*;
// 17.电话号码的字母组合
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
答案可以按任意顺序返回。给出数字到字母的映射如下（与电话按键相同）。
1 不对应任何字母。
2 → abc
3 → def
4 → ghi
5 → jkl
6 → mno
7 → pqrs
8 → tuv
9 → wxyz

*/


import java.util.List;

public class LetterCombinations {

    // 数字到字母的映射
    private static final String[] MAPPING = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
            // 设置一个字符串数组，
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 创建一个新的数组列表，
        if (digits == null || digits.length() == 0) return result;
        // 传入的数字：判断它是否为空

        StringBuilder path = new StringBuilder();
        // 每次的一个结果，使用stringbuilder创立字符串
        backtrack(digits, 0, path, result);
        // 调用构建方法：其中index表示遍历到的数字的位数
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> result) {
        // 终止条件：已经处理完所有数字
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // 获取当前数字对应的字母
        String letters = MAPPING[digits.charAt(index) - '0'];
        // 当前数字对应的字母：这是一个字符串，将字符串必须现转化为toCharArray才能遍历其中每个字母
        for (char c : letters.toCharArray()) {
            path.append(c);                           // 做选择
            backtrack(digits, index + 1, path, result); // 递归
            path.deleteCharAt(path.length() - 1);     // 撤销选择
        }
    }
}