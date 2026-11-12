package BackTracking;
// 131. 分割回文串：
/*
    提供一个字符串s， 将这个字符串s分割成一些子串，子串是回文串
    返回s所有的分割方案：
 */
import java.util.*;
public class Partition {
    // 方法一：回溯+动态规划：预判回文
     public List<List<String>> partition(String s){
         List<List<String>> result =new ArrayList<>();
         List<String> path= new ArrayList<>();

         // 预处理：dp[i][j]用于表示子字符串s[i..j]是否是回文字符串
         int n= s.length();
         boolean[][]dp=new boolean[n][n];
         // 创建矩阵记录子字符串的回文情况
         // 使用布尔矩阵检测子字符串是否回文
         for (int i =  n - 1;i>=0; i--) {
             // 暴力穷举可能的所有子字符串
             // i从后向前遍历：左边界
             for (int j=i;j<n;j++){
                 // j从前向后遍历：右边界
                 if (s.charAt(i)==s.charAt(j)&&(j-i<=2)||dp[i+1][j-1]){
                     dp[i][j]=true;
                 }
             }
         }
         backtrack(s,0,path,result,dp);
         return result;

     }


     private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp){
         if(start==s.length()){
             result.add(new ArrayList<>(path));
             return;
         }

         for (int end=start; end<s.length();end++){
             // 如果当前遍历到的这个子字符串是回文的，才会继续递归
             if (dp[start][end]){
                 path.add(s.substring(start,end));
                 backtrack(s,start, path, result,dp);
                 path.remove(path.size()-1);
             }
         }
     }


     // 简化版本：不使用预判：
    public List<List<String>> partition2(String s){
         List<List<String>> result =new ArrayList<>();
         // 这里不使用path数组列表
        trial(s,0,new ArrayList<>(),result);
        return result;
    }

    private void trial(String s, int start, List<String> path, List<List<String>> result){
         if (start==s.length()){
             result.add(new ArrayList<>(path));
             return;
         }

         for (int end=start;end<s.length();end++){
             if (isPalindrome(s,start, end)) {
                 path.add(s.substring(start,end+1));
                 trial(s,end+1, path,result);
                 path.remove(path.size()-1);
             }
         }
    }

    // 使用一个单独的检查子字符串是否回文方法
    private boolean isPalindrome(String s, int left, int right){
         while(left<right){
             if (s.charAt(left++)!=s.charAt(right--)) return false;
         }
         return true;
    }

}
