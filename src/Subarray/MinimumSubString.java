package Subarray;//来自代码随想录，最小包含字串，
//滑动窗口，得到最小字串，包含string原来含有的所有字符

import java.util.HashMap;

public class MinimumSubString {
    public String minWindow(String s, String t){
        HashMap<Character ,Integer> need=new HashMap<>();
        HashMap <Character, Integer> window= new HashMap<>();


        for ( char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left=0;
        int right=0;
        int count=0;
        int start=0, minLen=Integer.MAX_VALUE;

        while(right<s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);

                if (window.get(c).equals(need.get(c))){
                    count++;
                }
            }


            while(count==need.size()){
                if (right-left<minLen){
                    start=left;
                    minLen=right-left;
                }
                char d=s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d)))
                        count--;
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }

}
