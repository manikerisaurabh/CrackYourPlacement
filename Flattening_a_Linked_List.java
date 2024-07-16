import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.Node;

public class Flattening_a_Linked_List {

    class GfG {
        Node flatten(Node root) {
            Node dummy = new Node(0);
            Node temp = dummy;
            List<Integer> arr = new ArrayList<>();
            while (root != null) {
                Node t = root;
                while (t != null) {
                    arr.add(t.data);
                    t = t.bottom;
                }
                root = root.next;
            }
            Collections.sort(arr);
            for (int a : arr) {
                Node n = new Node(a);
                temp.bottom = n;
                temp = temp.bottom;
            }
            temp.bottom = null;
            return dummy.bottom;
        }
    }
}
