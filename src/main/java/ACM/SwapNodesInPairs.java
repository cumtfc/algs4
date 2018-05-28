package ACM;

import java.time.LocalDate;
import java.time.LocalTime;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        solution.swapPairs(l1);
    }

    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            while (head != null && head.next != null) {
                ListNode sec = head.next;
                head.next = sec.next;
                sec.next = head;
                pre.next = sec;
                pre = head;
                head = head.next;
            }
            return dummy.next;
        }

        public ListNode swapPairs2(ListNode head) {
            if ((head == null) || (head.next == null))
                return head;
            ListNode n = head.next;
            head.next = swapPairs(head.next.next);
            n.next = head;
            return n;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
