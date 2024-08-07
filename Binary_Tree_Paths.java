import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Binary_Tree_Paths {

    class Solution {
        private void getAllPaths(TreeNode node, List<Integer> path, List<List<Integer>> allPaths) {
            if (node.left == null && node.right == null) {
                path.add(node.val);
                allPaths.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
            path.add(node.val);
            if (node.left != null)
                getAllPaths(node.left, path, allPaths);
            if (node.right != null)
                getAllPaths(node.right, path, allPaths);
            path.remove(path.size() - 1);

        }

        public List<String> binaryTreePaths(TreeNode root) {
            List<Integer> path = new ArrayList<>();
            List<List<Integer>> allPaths = new ArrayList<>();
            List<String> ans = new ArrayList<>();
            getAllPaths(root, path, allPaths);
            for (List<Integer> arr : allPaths) {
                StringBuffer str = new StringBuffer();
                for (int i = 0; i < arr.size() - 1; i++) {
                    str.append(String.valueOf(arr.get(i)) + "->");
                }
                str.append(String.valueOf(arr.get(arr.size() - 1)));
                ans.add(str.toString());

            }
            return ans;
        }
    }
}