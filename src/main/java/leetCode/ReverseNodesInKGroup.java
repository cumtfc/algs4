package leetCode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        solution.reverseKGroup(head, 3);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @SuppressWarnings("Duplicates")
    @Deprecated
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head==null||head.next == null||k==1) return head;
            ListNode dump = new ListNode(0);
            dump.next = head;
            ListNode fast = dump;
            ListNode slow = dump;
            for (int i = 0; i < k; i++) {
                if (fast.next == null) {
                    return head;
                }
                fast = fast.next;
            }

            while (true) {
                ListNode temp1 = slow.next;
                ListNode temp2 = temp1.next;
                ListNode temp3 = temp2.next;
                slow.next.next = fast.next;
                fast = fast.next;
                for (int i = 1; i < k; i++) {
                    temp2.next = temp1;
                    temp1 = temp2;
                    temp2 = temp3;
                    if (temp3 != null) {
                        temp3 = temp3.next;
                    }else {
                        break;
                    }
                }
                slow.next = temp1;
                slow = slow.next;
                if (fast == null) break;
                int i = 1;
                for (; i < k && fast.next != null; i++) {
                    slow = slow.next;
                    fast = fast.next;
                }
                if (i < k) {
                    break;
                }
            }
            return dump.next;
        }
        public ListNode reverseKGroupNew(ListNode head, int k) {
            ListNode endNode = head;
            ListNode currNode = head;
            int i = 0;
            while (endNode != null && i < k-1) {
                endNode = endNode.next;
                i++;
            }
            if (i < k-1 || endNode == null)  // Not enough nodes
                return currNode;

            i = 0;
            ListNode prevNode = null;
            ListNode nextNode;
            while (i < k) {
                nextNode = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = nextNode;
                i++;
            }

            head.next = reverseKGroup(currNode, k);
            return endNode;
        }
    }



}
