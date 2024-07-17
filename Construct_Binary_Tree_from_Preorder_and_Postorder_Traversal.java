import javax.swing.tree.TreeNode;

public class Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {
    class Solution {
        TreeNode tree_builder(int[] preorder, int preStart, int preEnd, int[] postorder, int poStart, int posEnd) {
            if (preStart > preEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            if (preStart == preEnd)
                return root;
            int idx = poStart;
            while (postorder[idx] != preorder[preStart + 1]) {
                idx++;
            }
            int total_elements = (idx - poStart) + 1;
            root.left = tree_builder(preorder, preStart + 1, preStart + total_elements, postorder, poStart, idx);
            root.right = tree_builder(preorder, preStart + total_elements + 1, preEnd, postorder, idx + 1, posEnd - 1);

            return root;
        }

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return tree_builder(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }
    }
}
