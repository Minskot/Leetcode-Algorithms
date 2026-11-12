package Lists;

//206 反转链表
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 暂存下一个节点
            curr.next = prev;               // 反转指针
            prev = curr;                     // 移动prev
            curr = nextTemp;                  // 移动curr
        }

        return prev;


    }

}
