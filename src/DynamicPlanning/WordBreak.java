package DynamicPlanning;
// 139. 单词拆分
// 给予一个字符串，一个字符串列表作为词典，检查是否能组成这个单词

import java.util.*;

public class WordBreak {

    // 动态规划：最推荐：
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet =new HashSet<>(wordDict);
        int n=s.length();

        boolean []dp= new boolean[n+1];
        // dp[i]表示字符串s的前i个字符 s[0:i]

        dp[0]= true;
        // 空字符可以被拆分
        for (int i = 1; i <= n; i++) {
            // 子字符串从1开始，到n结束,对于位置i，尝试所有可能的分割点
            for (int j=0;j<i;j++){ 
                // 子字符串从j开始
                if (dp[j]&&wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }


    // 动态规划优化版：提前结束：

    public boolean wordBreak2(String s, List<String> wordList){
        Set<String> wordSet=new HashSet<>(wordList);
        int n = s.length();
        boolean[]dp =new boolean[n+1];
        dp[0]=true;

        for (int i = 0; i < n; i++) {
            for( int j=0;j<i;j++){
                if (dp[j] && wordSet.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];

     }


}
