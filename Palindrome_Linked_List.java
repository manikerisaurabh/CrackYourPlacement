public class Palindrome_Linked_List {

    class Solution {
        public boolean isPalindrome(ListNode head) {

            if (head == null || head.next == null)
                return true;

            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }

            if (fast != null)
                slow = slow.next;
            while (prev != null && slow != null) {
                if (prev.val != slow.val)
                    return false;
                prev = prev.next;
                slow = slow.next;
            }
            return true;
        }
    }
}
