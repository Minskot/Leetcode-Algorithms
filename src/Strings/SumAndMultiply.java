package Strings;
/*
给你一个整数 n。
将 n 中所有的 非零数字 按照它们的原始顺序连接起来，形成一个新的整数 x。如果不存在 非零数字 ，则 x = 0。
sum 为 x 中所有数字的 数字和 。
返回一个整数，表示 x * sum 的值。

*/
public class SumAndMultiply {

    public long sumAndMultiply(int n) {

        if (n==0) return 0;
        if (n<0) n=-n;
        int sum=0;
        StringBuilder sb=new StringBuilder();
        //方法一：数字取末位再反转：
        while(n>0){
            int bit=n%10;
            if (bit!=0){
                sb.append(bit);
                sum+=bit;
            }
            n/=10;
        }
        String aft=sb.reverse().toString();
        int num=Integer.valueOf(aft);
        return num*sum;



    }

    // 方法二：从前往后取数字位数：

    public long sumAndMultiply2(long n) {
        if (n==0) return 0;
        if (n<0) n=-n;
        long sum=0;
        StringBuilder sb=new StringBuilder();
        String num=String.valueOf(n);
        for(int i=0;i<num.length();i++){
            char bit =num.charAt(i);
            if (bit!='0'){
                sb.append(bit);
                sum+=(bit-'0');
            }
        }

        // 这里必须用long，要不然容易大数越界
        long aft=Integer.valueOf(sb.toString());
        // System.out.println("sum:"+sum);
        // System.out.println("aft:"+aft);
        return aft*sum;
    }



    // leetcode的示例代码：运行速度最快的版本：
    public long sumAndMultiply3(long n) {
        long x=0;
        long sum=0;
        long k=1;
        while(n>0){
            if(n%10!=0){
                x=k*(n%10)+x;
                k=k*10;
            }
            sum+=n%10;
            n=n/10;
        }
        return x*sum;
    }

    public static void main(String[] args) {
        SumAndMultiply sam=new SumAndMultiply();
        int n=10203004;
        long ans= sam.sumAndMultiply2(n);
        System.out.println(ans);

    }
}

