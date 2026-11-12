package LinkedLists;
// 两两交换链表中的节点：交换每两个链表节点并返回头节点

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode fast=head.next;
        ListNode slow=head;

        while (fast != null) {  // 当前如果能交换，先交换
            swapVal(fast, slow);
            if (fast.next==null||fast.next.next == null) {
                break;  //交换之后在判断是否能继续下一组
            }
            fast= fast.next.next;
            slow=slow.next.next;
        }
        return head;
    }


    private void swapVal(ListNode fast, ListNode slow){
        int temp=fast.val;
        fast.val=slow.val;
        slow.val= temp;
    }


}

