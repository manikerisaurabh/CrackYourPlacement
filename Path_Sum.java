import javax.swing.tree.TreeNode;

public class Path_Sum {

    class Solution {
        public boolean hasPathSum(TreeNode root, int target) {
            if (root == null)
                return false;

            target -= root.val;

            if (target == 0 && root.left == null && root.right == null)
                return true;

            boolean left = hasPathSum(root.left, target);
            boolean right = hasPathSum(root.right, target);

            return (left || right);
        }
    }
}
