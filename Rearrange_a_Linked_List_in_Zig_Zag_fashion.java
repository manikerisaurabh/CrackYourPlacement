public class Rearrange_a_Linked_List_in_Zig_Zag_fashion {
    static class Node {
        int data;
        Node next;
    }

    static Node head = null;
    static int temp = 0;

    static void zigZagList(Node head) {
        boolean flag = true;
        Node current = head;
        while (current != null && current.next != null) {
            if (flag == true) {
                if (current.data > current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            } else {
                if (current.data < current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }

            current = current.next;
            flag = !(flag);
        }
    }

    static void push(int new_data) {
        Node new_Node = new Node();
        new_Node.data = new_data;
        new_Node.next = (head);
        (head) = new_Node;
    }

    static void printList(Node Node) {
        while (Node != null) {
            System.out.print(Node.data + "->");
            Node = Node.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(6);
        push(8);
        push(7);
        push(3);
        push(4);

        System.out.println("Given linked list ");
        printList(head);

        zigZagList(head);

        System.out.println("Zig Zag Linked list ");
        printList(head);
    }
}
