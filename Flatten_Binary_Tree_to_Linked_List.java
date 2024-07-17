import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Flatten_Binary_Tree_to_Linked_List {

    class Solution {
        public void flatten(TreeNode root) {
            if (root == null)
                return;
            List<Integer> values = new ArrayList<>();
            preorder(root, values);
            TreeNode current = root;
            for (int i = 1; i < values.size(); i++) {
                current.left = null;
                current.right = new TreeNode(values.get(i));
                current = current.right;
            }
        }

        public void preorder(TreeNode root, List<Integer> values) {
            if (root == null)
                return;
            values.add(root.val);
            preorder(root.left, values);
            preorder(root.right, values);
        }
    }
}
