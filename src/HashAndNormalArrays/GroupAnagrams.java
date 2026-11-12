package HashAndNormalArrays;
// 字母异位词（变位词）分组。字母异位词：由重新排列源单词的所有字母得到的新单词。

import java.util.*;

public class GroupAnagrams {
    // 排序+哈希表
    /*
    方法一：将字符串按字母排序，排序后的结果作为key，排序结果相同的单词属于同一组

    时间复杂度 O（n*klogk） 每个字符串需要排序
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将字符串排序作为 key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            // 将原字符串加入对应的组
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }


    // 计数+哈希表， 更高效
    /*
    方法二：计数作为key：不排序，统计每个字母出现的次数，将计数数组转成字符串作为key
    "eat" → a:1, e:1, t:1 → key = "a1e1t1"
    "tea" → a:1, e:1, t:1 → key = "a1e1t1"

    时间复杂度 O（n*k） 每个字符串只要遍历一次
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 统计每个字母的出现次数
            int[] count = new int[26];
            for (char c : str.toCharArray()) count[c - 'a']++;

            // 构造 key：例如 "a1e1t1" 表示有 1 个 a、1 个 e、1 个 t
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    sb.append((char) ('a' + i)).append(count[i]);
                }
            }
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

}
