package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LengthOfLongestSubstring {
    // 3. 无重复字符的最长字串：

    // 第一种方法： 滑动窗口+hashset
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果窗口内已有该字符，移动左指针直到移除重复
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            // 将当前字符加入窗口
            set.add(c);
            // 更新最大长度
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


    // 第二种方法：滑动窗口+hashmap, 记录最后出现的位置
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;

        // 使用 HashMap 记录每个字符最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;  // 滑动窗口左边界

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 如果字符已经出现过，并且上次出现的位置在窗口内
            if (map.containsKey(c) && map.get(c) >= left)
                // 移动左边界到重复字符的下一个位置
                left = map.get(c) + 1;

            // 更新字符的最新位置
            map.put(c, right);

            // 计算当前窗口长度并更新最大值
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }


    // 第三种方法：数组：最快，适用于ASCII：

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) return 0;

        // 使用数组记录 ASCII 字符最后出现的位置（更高效）
        int[] lastIndex = new int[128];  // ASCII 字符集
        for (int i = 0; i < 128; i++) lastIndex[i] = -1;  // 初始化为 -1

        int maxLength = 0; int left = 0;

        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            // 如果字符出现过，并且上次出现位置在窗口内
            if (lastIndex[c] >= left) left = lastIndex[c] + 1;

            // 更新字符的最后出现位置
            lastIndex[c] = right;

            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

