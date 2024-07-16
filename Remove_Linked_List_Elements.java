public class Remove_Linked_List_Elements {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode();
            ListNode ptr = dummy;
            while (head != null) {
                if (head.val != val) {
                    ptr.next = head;
                    ptr = ptr.next;
                }
                if (head.next == null && head.val == val) {
                    ptr.next = null;
                }
                head = head.next;
            }
            return dummy.next;
        }
    }
}
