import javax.swing.tree.TreeNode;

public class Validate_Binary_Search_Tree {

    class Solution {
        boolean isValid(TreeNode root, long min, long max) {
            if (root == null)
                return true;
            if (root.val >= max || root.val <= min)
                return false;
            return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        }

        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    }
}
