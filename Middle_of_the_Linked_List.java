public class Middle_of_the_Linked_List {
    class Solution {
        public ListNode middleNode(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode q1 = head;
            int count = 0;
            while (q1 != null) {
                count++;
                q1 = q1.next;
            }
            int x = count / 2;
            ListNode temp = head;
            int a = 0;
            while (a != x - 1) {
                temp = temp.next;
                a++;
            }
            return temp.next;
        }
    }
}
