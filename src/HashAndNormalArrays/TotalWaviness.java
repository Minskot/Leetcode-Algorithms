package HashAndNormalArrays;

// 3751. 范围内总波动值 I

public class TotalWaviness {
    public int totalWaviness(int num1, int num2) {
        if (num1>num2) return -1;
        int sum=0;
        for (int i=num1;i<=num2;i++){
            sum+=waves(i);
        }
        return sum;

    }

    private int waves(int n){
        String str=String.valueOf(n);
        int l=str.length();
        if (l<=2) return 0;
        int count=0;
        for(int i=1;i<l-1;i++){
            if (str.charAt(i)<str.charAt(i-1)&&str.charAt(i)<str.charAt(i+1)) count++;
            if (str.charAt(i)>str.charAt(i-1)&&str.charAt(i)>str.charAt(i+1)) count++;
        }
        return count;
    }

    // Deepseek优化：
    private int waves2(int n) {
        if (n < 100) return 0; // 小于100的没有波
        int prev2 = n % 10;     // 个位
        n /= 10;
        int prev1 = n % 10;     // 十位
        n /= 10;
        int count = 0;

        while (n > 0) {
            int curr = n % 10;
            if ((prev1 < prev2 && prev1 < curr) || (prev1 > prev2 && prev1 > curr)) {
                count++;
            }
            prev2 = prev1;
            prev1 = curr;
            n /= 10;
        }
        return count;
    }
}
