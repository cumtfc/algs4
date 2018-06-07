package leetCode;

public class ExchangeNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.exchangeKGroup(head, 3);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode exchangeKGroup(ListNode head, int k) {
            ListNode dump = new ListNode(0);
            dump.next = head;
            ListNode fast = dump;
            ListNode slow = dump;
            for (int i = 1; i < k; i++) {
                if (fast.next == null) {
                    return head;
                }
                fast = fast.next;
            }

            while (fast != null && fast.next != null) {
                ListNode temp = fast.next;
                fast.next = slow.next;
                slow.next = temp;
                temp = temp.next;
                slow.next.next = fast.next.next;
                fast.next.next = temp;
                if (k == 2) {
                    fast = slow.next;
                }
                for (int i = 0; i < k && fast.next != null; i++) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
            return dump.next;
        }
    }

}
