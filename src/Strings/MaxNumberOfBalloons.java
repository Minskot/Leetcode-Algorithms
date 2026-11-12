package Strings;
// 1189. "气球"的最大数量

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

// HashMap counting: for character numbers:

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons1(String text){
        if (text==null||text.length()==0) return 0;
        Map<Character,Integer> count= new HashMap<>();
        for (char c:text.toCharArray())
            count.put(c,count.getOrDefault(c,0)+1);
        int b=count.getOrDefault('b',0);
        int a=count.getOrDefault('a',0);
        int l=count.getOrDefault('l',0)/2;
        int o=count.getOrDefault('o',0)/2;
        int n=count.getOrDefault('n',0);

        // 取最小值：
        return Math.min(Math.min(Math.min(b,a),Math.min(l,o)),n);
    }

    // 数组计数：我写的代码：
    public int maxNumberOfBalloons2(String text){
        if (text==null||text.length()==0) return 0;
        int[]count=new int[5];
        for (char c:text.toCharArray()){
            if (c=='b') count[0]+=2;
            if (c=='a') count[1]+=2;
            if (c=='l') count[2]+=1;
            if (c=='o') count[3]+=1;
            if (c=='n') count[4]+=2;
        }
        int min=text.length();
        for (int c:count) min=Math.min(min,c);
        return min/2;
    }


    public int maxNumberOfBalloons3(String text) {
        // 只需要统计 5 个字符：b, a, l, o, n
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a'] / 2;
        int o = count['o' - 'a'] / 2;
        int n = count['n' - 'a'];

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }


    public static void main(String args[]) {
        MaxNumberOfBalloons mnob= new MaxNumberOfBalloons();
        String str="ballonsbaasgsslllroonnsabbg";
        int ans= mnob.maxNumberOfBalloons1(str);
        System.out.println(ans);

    }
}
