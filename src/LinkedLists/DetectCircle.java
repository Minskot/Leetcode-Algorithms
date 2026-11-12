package LinkedLists;

import java.util.*;

// 142. 环形链表2
public class DetectCircle {
    public ListNode detectCycle(ListNode head){
        if (head==null||head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                ListNode ptr=head;
                while(ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    /*
    1. 算法基本原理我们定义两个指针：慢指针 (slow)：每次移动 1 步。快指针 (fast)：每次移动 2 步。
    为什么一定能相遇？如果链表中存在环，快指针进入环后，相对于慢指针，它相当于在环内以每步 1 位的速度“追赶”慢指针。
    由于两人都在环内循环，快指针最终一定会在某一点追上（重合）慢指针。
    如果快指针到达了链表末尾（null），则说明链表无环。

    2. 数学推导（寻找入口点）为了找到环的入口，我们需要量化指针走过的路程。
    假设：$a$：从链表头结点到环入口的距离。$b$：从环入口到相遇点的距离。$c$：从相遇点回到环入口的距离。
    环的长度为：$L = b + c$。
    第一阶段：相遇当快慢指针相遇时：慢指针走过的距离：$S = a + b$快指针走过的距离：$F = a + n(b + c) + b$
    （$n$ 为快指针在环内绕的圈数）
    因为快指针速度是慢指针的 2 倍，所以 $F = 2S$代入公式：
    $$a + n(b + c) + b = 2(a + b)$$$$a + n(b + c) + b = 2a + 2b$$
    整理得：$$a = n(b + c) - b$$$$a = (n - 1)(b + c) + c$$
    第二阶段：寻找入口观察上式 $a = (n - 1)(b + c) + c$：$(n-1)(b+c)$ 是整圈的距离。

    结论：从链表头部到入口的距离 ($a$)，等于从相遇点出发，走 $c$ 的距离后，
    再绕环走 $n-1$ 圈的距离。这意味着：如果我们让一个指针从链表头部出发，另一个指针从相遇点出发，
    两者每次都走 1 步，它们最终会在环的入口处相遇。

    * */

    // 时间复杂度O(N), 空间复杂度O（1）


    // 第二版本，假设链表中每一个节点的值都不相同，可以使用哈希集合储存环中的值：

    // 先使用成环计数，将环内所有的节点值加入哈希表
    // 然后从头开始重新遍历，直到遇到哈希表中的元素
    // 返回重新遍历的计数
    public ListNode detectCycleDiffVal(ListNode head) {
        if(head==null||head.next==null) return null;
        if (head.next==head) return head;

        ListNode slow=head;
        ListNode fast=head;
        ListNode meet=null;

        while(fast!=null&&fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                meet=fast;
                break;
            }
        }
        if (meet==null) return null;

        Set<Integer> set =new HashSet<>();

        ListNode cur=meet;
        do{
            set.add(cur.val);
            cur=cur.next;
        }while(cur!=meet);

        ListNode p=head;
        while(p!=null){
            if (set.contains(p.val)) return p;
            p=p.next;
        }

        for (int i:set) System.out.print(i+", ");

        return null;
    }
}