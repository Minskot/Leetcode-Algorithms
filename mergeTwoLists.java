public class mergeTwoLists {

    // ListNode 类（必须要有这个定义）
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    static class Solution {
        // 迭代版本
        public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

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

            if (list1 != null) current.next = list1;
            if (list2 != null) current.next = list2;

            return dummy.next;
        }

        // 递归版本
        public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists2(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists2(list1, list2.next);
                return list2;
            }
        }

        // 快速创建链表的静态方法
        public static ListNode createList(int... values) {
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;
            for (int val : values) {
                current.next = new ListNode(val);
                current = current.next;
            }
            return dummy.next;
        }

        // 快速测试
        public static void main(String[] args) {
            Solution sol = new Solution();

            // 创建测试链表
            ListNode l1 = createList(1, 2, 4);
            ListNode l2 = createList(1, 3, 4);

            // 测试迭代版本
            ListNode result1 = sol.mergeTwoLists1(l1, l2);
            System.out.print("迭代结果: ");
            printList(result1);

            // 重新创建链表测试递归版本
            l1 = createList(1, 2, 4);
            l2 = createList(1, 3, 4);
            ListNode result2 = sol.mergeTwoLists2(l1, l2);
            System.out.print("递归结果: ");
            printList(result2);
        }

        // 打印链表
        public static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val);
                if (head.next != null) System.out.print(" -> ");
                head = head.next;
            }
            System.out.println();
        }
    }
}

