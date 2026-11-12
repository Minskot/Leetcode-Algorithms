package Strings;
// 1358. 包含所有三种字符的子字符串数目
//给你一个字符串 s，它只包含三种字符 a、b 和 c。请你返回 a、b 和 c 都至少出现过一次的子字符串数目。

public class NumberOfSubstrings {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // 统计 a, b, c 的出现次数 创建一份长度为3的数组统计各个字母的出现次数
        int left = 0;
        int result = 0;

        for (int right = 0; right < n; right++) { // right从第一个迭代到最后一个
            // 将当前字符加入窗口
            count[s.charAt(right) - 'a']++;
            // 向数组中统计各个字母的出现次数：'a':count[0]++;'b':count[1]++;'c':count[2]++;

            // 当窗口包含 a, b, c 时，收缩左边界
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // 以 left 为起点的所有子串都满足条件
                // 从 left 到 right 是满足条件的，那么以 left 开头、right 结尾的所有子串都满足
                // 实际上，当窗口 [left, right] 满足条件时，
                // [left, right], [left, right+1], ..., [left, n-1] 都满足条件
                // 但这里我们选择另一种计数方式：
                // 当窗口满足条件时，以 left 为起点、以任意 >= right 的位置为终点的子串都满足
                // 即：n - right 个子串
                result += n - right;

                // 移动左指针，继续寻找
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return result;
    }


    // 示范代码：极致优化版本
    public int numberOfSubstrings2(String s) {
        char[] sc = s.toCharArray();
        // 将字符串转为数组
        int n = sc.length;
        int ans = 0;
        int[] cnt = new int[3];
        for (int i = 0; i < sc.length; i++) {
            // 迭代边界条件：数组的第一位到最后一位 时间复杂度:O(n)
            cnt[sc[i] - 'a'] = i + 1;
            // 最后出现位置法：记录当前字符最后一次出现的位置：索引号+1
            // 计数数组：从后往前计数：
            ans += Math.min(cnt[0], Math.min(cnt[1], cnt[2]));
            // 计算以当前字符s[i]为右端点时，新增了多少个有效字串
            // 对于三个字符最后出现的位置p1,p2,p3:
            // 想要字串同时包含a,b,c,左端点left<=min(p1,p2,p3)
            // 左端点一共有（p1,p2,p3的最小值）个可能，故总和增加这么多个有效子串

        }
        return ans;
    }

}
