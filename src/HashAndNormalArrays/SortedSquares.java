package HashAndNormalArrays;

//977有序数组的平方
public class SortedSquares {
    public int[]sortedSquares(int[]nums){

        if (nums==null||nums.length==0) return new int[]{-1};
        int l=nums.length;
        int left=0; int right=l-1;
        int []res=new int[l];

        for (int i=l-1;i>=0;i--){
            int leftSquare=nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];

                if (leftSquare>rightSquare){
                    res[i]=leftSquare;
                    left++;
                }
                else{
                    res[i]=rightSquare;
                    right--;
                }
        }
        return res;

    }

    public static void main(String[] args){
        int []nums={-3,-1,0,2,4,5};
        SortedSquares ss=new SortedSquares();
        int[]res=ss.sortedSquares(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ,");
        }
    }

}
