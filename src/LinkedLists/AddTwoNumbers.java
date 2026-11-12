package LinkedLists;
// 两数相加：每个对应位置的节点是对应两数相加的个位数

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1==null||l2==null) return null;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        int carry=0; //  进位

        while(l1!=null||l2!=null||carry!=0){  // 任何一个产生数值的部分非零即可
            int sum=carry;
            if (l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if ( l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            cur.next=new ListNode(sum%10);
            cur=cur.next;

        }
        return dummy.next;
    }
}
