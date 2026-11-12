package LinkedLists;
// 234.回文链表

public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. 快慢指针找中点， slow指针表示中点位置的链表
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 反转后半部分链表
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;

        // 3. 比较前后两部分
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }



    private ListNode reverse(ListNode head) {
        // 反转链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }

    // leetcode的示范代码：2ms
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head, fast = head, tmp, prev = null;
        // 初始化写法高效
        while(fast != null && fast.next != null){
            tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
            tmp.next = prev;
            prev = tmp;
        }

        if (fast!=null) slow=slow.next;

        while(slow != null) {
            if(slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}



