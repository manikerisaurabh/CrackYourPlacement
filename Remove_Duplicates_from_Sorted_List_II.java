public class Remove_Duplicates_from_Sorted_List_II {

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;
            ListNode current = head;
            while (current != null) {
                boolean flag = false;
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                    flag = true;
                }

                if (flag) {
                    prev.next = current.next;
                } else {
                    prev = current;
                }

                current = current.next;
            }
            return dummy.next;
        }
    }
}
