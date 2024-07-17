import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Maximum_Width_of_Binary_Tree {
    class Pair {
        TreeNode node;
        int col;

        public Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            int maxWidth = 0;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0));

            while (!q.isEmpty()) {
                int size = q.size();

                int temp = q.peek().col;
                for (int i = 0; i < size; i++) {
                    Pair p = q.remove();

                    if (p.node.left != null)
                        q.add(new Pair(p.node.left, (p.col - temp) * 2 + 1));
                    if (p.node.right != null)
                        q.add(new Pair(p.node.right, (p.col - temp) * 2 + 2));

                    if (i == size - 1)
                        maxWidth = Math.max(p.col - temp + 1, maxWidth);
                }
            }

            return maxWidth;
        }
    }
}
