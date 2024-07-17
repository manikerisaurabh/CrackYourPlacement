import javax.swing.tree.TreeNode;

public class Balanced_Binary_Tree {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return height(root, 1) > 0;
        }

        private int height(TreeNode root, int height) {
            if (root == null)
                return height;

            int left = height(root.left, height + 1);
            int right = height(root.right, height + 1);

            if (left < 0 || right < 0 || Math.abs(left - right) > 1)
                return -1; // Fail fast

            return Math.max(left, right);
        }
    }
}
