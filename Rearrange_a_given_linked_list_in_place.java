import org.w3c.dom.Node;

public class Rearrange_a_given_linked_list_in_place {
    class Node {
        int data;
        Node next;

        // Function to create newNode in a linkedlist
        Node(int key) {
            data = key;
            next = null;
        }
    }

    Node left = null;

    // Function to print the list
    void printlist(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    // Function to rearrange
    void rearrange(Node head) {

        if (head != null) {
            left = head;
            reorderListUtil(left);
        }
    }

    void reorderListUtil(Node right) {

        if (right == null) {
            return;
        }

        reorderListUtil(right.next);

        // we set left = null, when we reach stop condition,
        // so no processing required after that
        if (left == null) {
            return;
        }

        // Stop condition: odd case : left = right, even
        // case : left.next = right
        if (left != right && left.next != right) {
            Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        } else { // stop condition , set null to left nodes
            if (left.next == right) {
                left.next.next = null; // even case
                left = null;
            } else {
                left.next = null; // odd case
                left = null;
            }
        }
    }
}
