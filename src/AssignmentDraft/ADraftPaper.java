package AssignmentDraft;
import java.util.*;


public class ADraftPaper {
    //Dictation for solution;
    //Dictations for quicksort:

    // 写一个方法，用于计算一个int的各数位的数字之和与数字之积的和：
    // 实际上就是算出每一位数字之后，加入result，最后result加上数字之积：

    public int calculate(int n){
        if (n<=0) return -1;
        int val=n;
        int sum=0;
        int pro=1;
        while(val!=0){
            int digit=val%10;
            sum+=digit;
            pro*=digit;
            val=(val-digit)/10;

        }
        return sum+pro;
    }


        public static void main(){

            ADraftPaper dp=new ADraftPaper();
            int ans=dp.calculate(123);
            System.out.println(ans);




        }

}



