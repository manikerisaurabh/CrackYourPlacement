public class Add_Two_Numbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode(0);
            ListNode result = dummyHead;
            int sum = 0, carry = 0;

            while (list1 != null || list2 != null) {
                sum = 0;

                if (list1 != null) {
                    sum += list1.val;
                    list1 = list1.next;
                }

                if (list2 != null) {
                    sum += list2.val;
                    list2 = list2.next;
                }

                if (carry != 0) {
                    sum += carry;
                }

                if (sum / 10 != 0) {
                    ListNode newNode = new ListNode(sum % 10);
                    result.next = newNode;
                    carry = sum / 10;
                    result = newNode;
                } else {
                    ListNode newNode = new ListNode(sum);
                    result.next = newNode;
                    carry = 0;
                    result = newNode;
                }
            }

            if (carry != 0) {
                ListNode newNode = new ListNode(carry);
                result.next = newNode;
                result = newNode;
            }

            return dummyHead.next;
        }
    }
}
