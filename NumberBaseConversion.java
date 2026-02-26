import java.util.Scanner;

public class NumberBaseConversion {
    //This system helps users to input a number in decimal
    //input the base you want, convert it to binary, quaternary or octal number...etc
    //此算法将一个输入的十进制数转化为十以内任意进制的数字
    Scanner sc=new Scanner(System.in);

    public int convert(){
        System.out.println("Enter a number in decimal:");
        int num=sc.nextInt();
        System.out.println("Enter a positive integer between 2 and 10 as the base :");
        int base=sc.nextInt();

        //convert the decimal number into new base system, with the division and reminder
        //use an iterative method to accomplish:

        if (base<=1){
            System.out.println("Invalid base number.");
            return -1;
        }
        boolean negativeFlag=false;
        if(num<0) negativeFlag=true;
        StringBuilder s= new StringBuilder("");
        int num1=num;
        do{
            int reminder=num1%base;
            s.append(reminder);
            num1=num1/base;
        }while(num1>0);
        s.reverse();
        String str=s.toString();
        int ans=Integer.parseInt(str);
        if (negativeFlag==true) ans=-ans;
        return ans;
    }
    public static void main(String[] args){
        NumberBaseConversion nbc=new NumberBaseConversion();
        int ans=nbc.convert();
        System.out.println(ans);
    }


}
