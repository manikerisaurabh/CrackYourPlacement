import javax.swing.tree.TreeNode;

public class Minimum_Absolute_Differencein_BST {
    class Solution {
        private int minDiff;
        private TreeNode prev;

        public int getMinimumDifference(TreeNode root) {
            minDiff = Integer.MAX_VALUE;
            prev = null;
            inOrderTraversal(root);
            return minDiff;
        }

        private void inOrderTraversal(TreeNode node) {
            if (node == null) {
                return;
            }

            inOrderTraversal(node.left);

            if (prev != null) {
                minDiff = Math.min(minDiff, node.val - prev.val);
            }

            prev = node;

            inOrderTraversal(node.right);
        }
    }
}
