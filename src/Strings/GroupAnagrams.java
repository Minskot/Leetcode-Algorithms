package Strings;

import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 1. 将字符串排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // 2. 将原字符串加入对应的组
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}



