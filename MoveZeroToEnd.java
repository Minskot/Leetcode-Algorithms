/*I found this problem on Wechat"代码随想录"

This algorithm moves zeros in a array to the end of the array,
 * The key skill is the dual-pointer in array.
 * There is a fast pointer increasing itself,（快指针自增）
 * if the fast pointer meets non-zero elements,
 * the slow pointer then go ahead sequentially and change the element the fast pointer;
 * when the pointer meets any number that is zero,
 * the slow pointer stays in place.
 *
 * when the fast pointer moves to the end of the array,
 * the over-succeed difference is equals to the time the fast pointer meets zero,
 * then the slow pointer will change all remaining elements to zero

*/

public class MoveZeroToEnd {
    void moveAllZeroEnd(int []arr){
        int fastPin=0;int slowPin=0;
        int len=arr.length;
        for (;fastPin<len;fastPin++){
            if (arr[fastPin]!=0)
                arr[slowPin++]=arr[fastPin];
        }
        for(;slowPin<len;slowPin++)
            arr[slowPin]=0;
        for (int j : arr) {
            System.out.print(j);
        }
    }
    public void main(String[] args){
        int []arr={1,0,3,0,5,4,0,5,7,0,3,7};
        moveAllZeroEnd(arr);
    }

}
