package LinkedLists;
// 160.相交链表
// 双指针（最优解）

public class IntersectionNode {
    public ListNode getIntersectionNode (ListNode headA, ListNode headB){

        if (headA==null||headB==null) return null;

        ListNode pA=headA;
        ListNode pB=headB;
        while (pA!=pB){
            pA=(pA==null)?headB:pA.next;
            pB=(pB==null)?headA:pB.next;
        }
        return pA;
    }
}
