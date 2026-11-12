package LinkedLists;
// 删除链表的倒数第N个节点,并且返回链表的头节点


public class RemoveNthFromEnd {

    // 解法一：双指针
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;

        for (int i=0;i<=n;i++) fast=fast.next;
        // 快指针先走n+1歩，slow要指向他的前一个
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        // 快慢指针一起走，直到fast末尾
        slow.next=slow.next.next;
        return dummy.next;

    }

    // 双指针 更直观的写法：
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode fast=dummy;
        ListNode slow=dummy;

        for (int i=0;i<n;i++) fast=fast.next;


        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        // 快慢指针一起走，直到fast到达最后一个节点

        slow.next=slow.next.next;
        //删除slow.next，即倒数第n个节点
        return dummy.next;


    }


}
