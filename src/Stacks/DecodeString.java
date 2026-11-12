package Stacks;
// 394. 字符串解码：将一个字符串的表达式转换成完整形式的字符串
import java.util.Stack;

/*
    将字符串表达式转换成字符串String：
    "3[a]2[bc]" → "aaabcbc"
    "3[a2[c]]" → "accaccacc"
    "2[abc]3[cd]ef" → "abcabccdcdcdef"

*/
// 难点解析：括号可以嵌套，但是内层没算完之前，
// 外层的“已构建内容”和“重复次数”必须先被暂存起来

// 使用双栈存储并构建字符串：
public class DecodeString {
    public String decodeString(String s){
        // 两个函数调用栈帧，
        Stack<Integer> countStack= new Stack<>();
        // 存储括号前的重复次数
        Stack<StringBuilder> stringStack=new Stack<>();
        // 存储括号前已经构建好的字符串
        StringBuilder current=new StringBuilder();
        // 字符串构建器，存储当前正在构建的字符串
        int num=0;
        // 正在解析中的数字，还没有遇到‘【’

        for (char c:s.toCharArray()){
            if (Character.isDigit(c)) num=num*10+(c-'0');
            // 如果是数字，解析数字：处理多位数字的系数，将数字从bit转化为int
            // 由于是从左到右的遍历，将当前存储的数值乘10再加上新遍历遇到的个位数字
            else if (c=='['){
                // 左方括号：保存当前状态并开始新的一层
                countStack.push(num);
                // 储存这一层的倍数
                stringStack.push(current);
                current=new StringBuilder();
                // 开一个全新的builder，装这一层的内容
                num=0;
                //必须重置num
            }
            else if (c==']'){
                // 弹栈合并：结束当前层，重复并合并
                int repeat=countStack.pop();
                // 取出这一层的倍数
                StringBuilder decoded= stringStack.pop();
                // 取出这一层的外层前缀
                for (int i = 0; i < repeat; i++) decoded.append(current);
                // 把本层内容重复拼到前缀后面
                current=decoded;
                // 合并结果成为新的“当前层内容”，本层算完了，就升级成外层正在攒的内容
            }
            else current.append(c);
            // 将左右括号之间的字符，加入到字符串构建器中构建string
            }
        return current.toString();
        }




    // 方法二：递归，形式上更优雅

    private int index = 0;

    public String decodeString2(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                // 解析数字
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    // 一次性吃掉整个多位数
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                // 跳过 '['
                index++;
                // 递归解码括号内的内容（会在‘】’处返回）
                String inner = decodeString2(s);
                // 重复 num 次
                for (int i = 0; i < num; i++) result.append(inner);
                // 跳过 ']'
                index++;
            }

            else if (c == ']') break;
            // 交还给上层，不消费这个‘】’
            // break时，index停在】上，每个字符恰好被消费一次

            else {
                result.append(c);
                index++;
            }
        }

        return result.toString();
    }

}
