package MultiLevelDynamicPlanning;
// 5.最长回文子串

public class LongestPalindrome {
    // 中心扩展法（推荐）求最长回文子串最高效直观的算法
    // 回文串时中心对称的，遍历每个位置，把它当作回文的中心，向两侧扩展
    // 分别对奇数和偶数长度情况，选择中心并记录扩展过程中最长的回文串

    public String longestPalindrome(String s) {

        if (s==null||s.length()==0) return "";
        int start=0,end=0;
        for (int i=0;i<s.length();i++){
            int len1=expandAroundCentre(s,i,i);
            // 奇数长度回文，以i为中心
            int len2=expandAroundCentre(s,i,i+1);
            // 偶数长度回文，以i和i+1为中心
            int len=Math.max(len1,len2);
            if (len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;


            }
        }
        return s.substring(start,end+1);
    }

    private int expandAroundCentre(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }


    // 解法二：动态规划：

    public String longestPalindrome2(String s){
        if (s==null||s.length()==0) return "";
        int n=s.length();
        boolean[][]dp=new boolean[n][n];
        // dp[i][j]表示从i到j的子串：

        int start=0,maxLen=1;

        for (int i=0;i<n;i++) dp[i][i]=true;
        // 单个字符都是回文

        for (int i=0;i<n-1;i++){
            // 检查长度为2的子串
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                maxLen=2;
            }
        }

        for (int len=3;len<=n;len++){
            // 检查长度>=3的子串
            for(int i=0;i<n-len;i++){
                int j=i+len-1;
                if (s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                    dp[i][j]=true;
                    start=i;
                    maxLen=len;
                }
            }
        }

        return s.substring(start,start+maxLen);
    }


    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 2) return s;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;

        // 初始化：所有单字符都是回文
        for (int i = 0; i < n; i++) dp[i][i] = true;

        // 按子串长度从小到大遍历
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                // i，j表示子串两端的数字索引

                if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                else {
                    // 长度为2或3时，两端相同即可
                    if (len <= 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];

                }

                // 更新最长回文
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }




}
