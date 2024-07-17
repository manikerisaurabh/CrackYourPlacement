import org.w3c.dom.Node;

public class Populating_Next_Right_Pointers_in_Each_Node {
    class Solution {
        public Node connect(Node root) {
            if (root == null)
                return null;
            if (root.left != null)
                root.left.next = root.right;
            if (root.right != null && root.next != null)
                root.right.next = root.next.left;
            connect(root.left);
            connect(root.right);
            return root;
        }
    }
}