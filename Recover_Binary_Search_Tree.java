import javax.swing.tree.TreeNode;

public class Recover_Binary_Search_Tree {

    class Solution {
        private boolean check(TreeNode root, int min, int max) {
            if (root == null)
                return true;
            if (root.val < min || root.val > max)
                return false;

            return check(root.left, min, root.val - 1) &&
                    check(root.right, root.val + 1, max);
        }

        private void find(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null)
                return;

            if (root.val < min.val) {
                int temp = root.val;
                root.val = min.val;
                min.val = temp;
            }
            if (root.val > max.val) {
                int temp = root.val;
                root.val = max.val;
                max.val = temp;
            }

            find(root.left, min, root);
            find(root.right, root, max);
        }

        public void recoverTree(TreeNode root) {
            find(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
            while (!check(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
                find(root, new TreeNode(Integer.MIN_VALUE), new TreeNode(Integer.MAX_VALUE));
        }
    }
}
