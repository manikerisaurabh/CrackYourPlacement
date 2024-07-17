import java.util.Stack;

import javax.swing.tree.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Tree {

    class BSTIterator {
        Stack<TreeNode> s = new Stack<>();

        public BSTIterator(TreeNode root) {
            help(root);
        }

        public int next() {
            TreeNode h = s.pop();
            help(h.right);
            return h.val;
        }

        public boolean hasNext() {
            if (s.isEmpty())
                return false;
            return true;
        }

        void help(TreeNode r) {
            if (r == null)
                return;
            s.push(r);
            help(r.left);
        }
    }
}
