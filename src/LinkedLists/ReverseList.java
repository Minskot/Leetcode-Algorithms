package LinkedLists;
// 206. 反转链表
// 创建一个临时的节点，然后交换当前节点的之前和之后节点

import java.util.List;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode nextTemp=cur.next;  // 暂存下一节点
            cur.next=pre;    // 反转指针
            pre=cur;         //移动pre
            cur=nextTemp;    // 移动cur
        }
        return pre;



    }




}
