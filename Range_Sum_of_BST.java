import javax.swing.tree.TreeNode;

public class Range_Sum_of_BST {

    class Solution {
        boolean isWithinBounds(int val, int left, int right) {
            return val >= left && val <= right;
        }

        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }

            int sum = 0;
            if (isWithinBounds(root.val, low, high)) {
                sum += root.val;
            }

            if (root.val > high) {
                // only parse left subtrees
                return sum + rangeSumBST(root.left, low, high);
            }
            if (root.val < low) {
                // only parse right subtrees
                return sum + rangeSumBST(root.right, low, high);
            }

            // parse both subtrees
            return sum
                    + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }
    }
}
