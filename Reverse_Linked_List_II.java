public class Reverse_Linked_List_II {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null)
                return head;
            ListNode first = new ListNode(-1);
            first.next = head;
            ListNode curr = first.next;
            ListNode prev = first;
            for (int i = 1; i < left; i++) {
                curr = curr.next;
                prev = prev.next;
            }
            ListNode sav = prev;
            ListNode ncurr = curr.next;
            for (int i = left; i < right; i++) {
                prev = ncurr.next;
                ncurr.next = curr;
                curr = ncurr;
                ncurr = prev;
                ncurr = prev;
            }
            sav.next.next = ncurr;
            sav.next = curr;
            return first.next;
        }
    }
}
