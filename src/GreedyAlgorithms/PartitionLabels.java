package GreedyAlgorithms;
// 763. 划分字母区间
import java.util.*;
/*
给你一个字符串s 我们要把这个字符串划分为尽可能多的片段，
同一字母最多出现在一个片段中。划分结果，将所有划分结果按顺序连接，
得到的字符串仍然是s，返回一个表示每个字符串片段的长度的列表
例如：划分为三个字符串片段，各有一个长度，就是[9,7,8]

**维护当前片段的最大结束位置

*/

public class PartitionLabels {
    // 划分字母区间，将一个字母只能放在一个片段中
    // 每个片段的结束位置必须》=该片段中所有字母的最后出现位置
    // 贪心:每次取最小的，满足条件的片段
    // 解法：贪心+双指针
    public List<Integer> partitionLabels(String s){
        List<Integer> result=new ArrayList<>();
        // 记录每个字母最后出现的位置，
        // 从左到右遍历，end记录当前片段中所有字母的最后出现位置
        // 当i==end时，说明当前位置就是当前片段的最右边边界
        // 此时进行切割，可以保证尽可能多的分区
        int [] lastOccurrence=new int[26];
        for (int i=0;i<s.length();i++){
            // 遍历字符串的每一位字母
            lastOccurrence[s.charAt(i)-'a']=i;
            // 在26位的数组中，字母次序这一位上，记录字符串中的位置
        }

        // 遍历字符串，划分区间
        int start=0;
        int end=0;
        for (int i=0;i<s.length();i++){
            // 遍历字符串中的每一位字母
            char c=s.charAt(i);
            // c是字符串的每一位字母
            end=Math.max(end, lastOccurrence[c-'a']);
            // 更新字母出现的最后一个位置end
            // 当新字母的最后位置比当前end更远时，
            // 说明当前片段必须扩展到那个位置，否则这个字母会出现在两个片段中
            if(i==end){
                // 如果当前位置是当前区间的最右边界：
                // 算法的切割执行点：end表示当前片段“至少到哪个位置才能结束”
                // 当前片段必须覆盖所有字母的最后一次出现位置
                result.add(end-start+1);
                // end-start+1表示当前片段的长度，将当前字符串片段的长度加入result
                start=end+1;
                // 把下一个片段的起点设置为当前片段结束后的第一个位置
            }
        }
        return result;
    }
}
