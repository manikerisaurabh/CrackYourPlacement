public class Partition_List {

    class Solution {
        public ListNode partition(ListNode head, int x) {
            if (head == null || head.next == null)
                return head;
            ListNode sml = new ListNode(0);
            ListNode le = sml;
            ListNode crnt = head;
            while (crnt != null && crnt.val < x) {
                le.next = crnt;
                le = le.next;
                crnt = crnt.next;
                System.out.println(0);
            }
            head = crnt;
            if (crnt == null)
                return sml.next;
            while (crnt.next != null) {
                if (crnt.next.val < x) {
                    le.next = crnt.next;
                    crnt.next = crnt.next.next;
                    le = le.next;
                } else
                    crnt = crnt.next;
                System.out.println(2);
            }
            le.next = head;
            return sml.next;

        }
    }
}
