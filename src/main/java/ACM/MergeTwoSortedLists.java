package ACM;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2= new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        solution.mergeTwoLists(l1, l2);
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1==null) return l2;
            if (l2==null) return l1;
            ListNode pointer = new ListNode(0);
            ListNode head = new ListNode(0);
            head.next = l1.val > l2.val ? l2 : l1;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    pointer.next = l2;
                    l2 = l2.next;
                } else if (l2 == null) {
                    pointer.next = l1;
                    l1 = l1.next;
                }else if(l1.val>l2.val){
                    pointer.next = l2;
                    l2 = l2.next;
                }else {
                    pointer.next = l1;
                    l1 = l1.next;
                }
                pointer = pointer.next;
            }

            return head.next;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length==0) return null;
            if (lists.length==1) return lists[0];
            for (int i = 0; i < lists.length-1; i++) {
                lists[i+1]=mergeTwoLists(lists[i], lists[i + 1]);
            }
            return lists[lists.length - 1];
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
