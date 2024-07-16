import org.w3c.dom.Node;

public class Delete_nodes_having_greater_value_on_right {
    class Solution {
        Node compute(Node temp) {
            if (temp.next == null) {
                return temp;
            }
            Node connect = compute(temp.next);

            if (temp.data >= connect.data) {
                temp.next = connect;
                return temp;
            }

            return connect;

        }

    }
}
