import org.w3c.dom.Node;

public class Flatten_a_Multilevel_Doubly_Linked_List {
    class Solution {
        public Node flatten(Node head) {
            Node temp = head;
            while (temp != null) {
                Node list1Tail = temp;
                Node list3Head = temp.next;

                if (temp.child != null) {
                    Node list2Head = flatten(temp.child);

                    Node list2Tail = list2Head;
                    while (list2Tail.next != null) {
                        list2Tail = list2Tail.next;
                    }

                    list1Tail.next = list2Head;
                    list2Head.prev = list1Tail;
                    list2Tail.next = list3Head;
                    if (list3Head != null)
                        list3Head.prev = list2Tail;
                    temp.child = null;
                }
                temp = temp.next;
            }
            return head;
        }
    }
}
