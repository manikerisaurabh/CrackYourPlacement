import org.w3c.dom.Node;

public class Copy_List_with_Random_Pointer {
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node curr = head;
            while (curr != null) {
                Node copy = new Node(curr.val);
                copy.next = curr.next;
                curr.next = copy;
                curr = copy.next;
            }
            curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }
            curr = head;
            Node newHead = head.next;
            Node newCurr = newHead;

            while (curr != null) {
                curr.next = curr.next.next;
                if (newCurr.next != null) {
                    newCurr.next = newCurr.next.next;
                }
                curr = curr.next;
                newCurr = newCurr.next;
            }

            return newHead;
        }
    }
}
