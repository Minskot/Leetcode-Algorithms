package Strings;
// 1967. 作为子字符串出现在单词中的数目

import java.util.Arrays;
public class NumOfStrings {
    // 直接遍历： 最直观
    public int numOfStrings1(String[] patterns, String word) {
        // 虽然不会报错，但最好处理边界
        if (patterns == null || patterns.length == 0) return 0;
        int count=0;
        for (String pattern:patterns)
            if (word.contains(pattern)) count++;

        return count;
    }
    // indexOf(): 性能更好
    public int numOfStrings(String[]patterns, String word){
        int count=0;
        for (String pattern:patterns)
            if (word.indexOf(pattern)!=-1)
                count++;
        return count;
    }

    // Stream 函数式编程
    public int numOfStrings3(String[]patterns,String word){
        return (int) Arrays.stream(patterns).filter(word::contains).count();
    }
}
