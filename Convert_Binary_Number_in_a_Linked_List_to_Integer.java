import java.util.*;

public class Convert_Binary_Number_in_a_Linked_List_to_Integer {
    class Solution {
        public int getDecimalValue(ListNode head) {
            ListNode temp = head;
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            while (temp != null) {
                sb.append(temp.val);
                temp = temp.next;
            }
            sb.deleteCharAt(0);
            int p = Integer.parseInt(sb.toString(), 2);
            return p;
        }
    }
}
