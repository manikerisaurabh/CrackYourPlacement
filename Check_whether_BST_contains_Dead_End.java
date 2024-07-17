import java.util.HashSet;

import org.w3c.dom.Node;

public class Check_whether_BST_contains_Dead_End {
    class Solution {
        private static void populatesets(Node node, HashSet<Integer> allnodes, HashSet<Integer> leafnodes) {
            if (node == null) {
                return;
            }
            // doing in order traversal and storing in hashsets as we have made for all and
            // leaf nodes
            populatesets(node.left, allnodes, leafnodes);
            allnodes.add(node.data);
            if (node.left == null && node.right == null) {
                leafnodes.add(node.data);
            }
            populatesets(node.right, allnodes, leafnodes);

        }

        public static boolean isDeadEnd(Node root) {
            // Add your code here.

            HashSet<Integer> allnodes = new HashSet<>();
            HashSet<Integer> leafnodes = new HashSet<>();
            // populate the setis with in order taversal
            populatesets(root, allnodes, leafnodes);
            for (int leaf : leafnodes) {
                if (leaf == 1) {
                    if (allnodes.contains(2)) {
                        return true;
                    }
                } else if (allnodes.contains(leaf - 1) && allnodes.contains(leaf + 1)) {
                    return true;
                }
            }

            return false;
        }
    }
}
