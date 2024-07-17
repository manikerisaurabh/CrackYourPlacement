import javax.swing.tree.TreeNode;

public class Maximum_Depth_of_Binary_Tree {

    class Solution {

        public int maxDepth(TreeNode root) {

            return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        }
    }
}
