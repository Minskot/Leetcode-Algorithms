package LinkedLists;
// 合并两个有序链表

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 创建一个哑节点(dummy)作为新链表的头部
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 遍历两个链表，比较节点值
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 如果其中一个链表还有剩余节点，直接接上
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }



    public ListNode mergeTwoLists2(ListNode list1, ListNode list2){
        if (list1==null&&list2==null) return null;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;

        while(list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                cur.next=list1;
                list1=list1.next;
            }
            else{
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        while(list2==null&&list1!=null){
            cur.next=list1;
            list1=list1.next;
            cur=cur.next;
        }
        while(list1==null&&list2!=null){
            cur.next=list2;
            list2=list2.next;
            cur=cur.next;
        }
        return dummy.next;
    }



}
