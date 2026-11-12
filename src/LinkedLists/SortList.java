package LinkedLists;
// 148.排序链表
public class SortList {

    // 标准冒泡排序
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;

        // 计算链表长度
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // 冒泡排序：外层控制轮数，内层比较交换
        for (int i = 0; i < length - 1; i++) {
            ListNode ptr1 = head;
            ListNode ptr2 = head.next;

            for (int j = 0; j < length - 1 - i; j++) {
                if (ptr1.val > ptr2.val) {
                    swapVal(ptr1, ptr2);
                }
                ptr1 = ptr2;
                ptr2 = ptr2.next;
            }
        }

        return head;
    }

    // 冒泡排序2：使用while
    public ListNode sortList3(ListNode head) {
        if (head == null || head.next == null) return head;

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // 外层循环：总共需要 length-1 轮
        for (int i = 0; i < length - 1; i++) {
            ListNode ptr1 = head;
            ListNode ptr2 = head.next;

            // 内层循环：每轮比较 length-1-i 次
            int steps = length - 1 - i;
            while (steps > 0) {
                if (ptr1.val > ptr2.val) {
                    swapVal(ptr1, ptr2);
                }
                ptr1 = ptr2;
                ptr2 = ptr2.next;
                steps--;
            }
        }

        return head;
    }


    private void swapVal(ListNode fast, ListNode slow){
        int temp=fast.val;
        fast.val=slow.val;
        slow.val= temp;
    }



    // 因为冒泡排序超时，归并排序（O(n*logn)）
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        // 快慢指针找到链表中点
        ListNode rightHead = mid.next;
        mid.next = null;  // 断开链表
        // 递归排序左右部分的链表
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return merge(left, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // fast每走两步，slow走一步，最后就会出现在中点处
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; // slow位于左包含中点位置
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;

        while(l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }

        cur.next=(l1!=null)?l1:l2;
        return dummy.next;




    }




}







