import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class All_Nodes_Distance_K_in_Binary_Tree {
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            HashMap<TreeNode, List<TreeNode>> adj = adjList(root);
            HashSet<TreeNode> visited = new HashSet<>();
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(target);
            visited.add(target);
            int steps = 0;
            while (!queue.isEmpty()) {
                if (steps > k) {
                    break;
                }
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (steps == k) {
                        res.add(node.val);
                    }
                    for (TreeNode neighbor : adj.get(node)) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                steps++;
            }
            return res;
        }

        private HashMap<TreeNode, List<TreeNode>> adjList(TreeNode root) {
            HashMap<TreeNode, List<TreeNode>> adj = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    adj.putIfAbsent(node, new ArrayList<>());
                    if (node.left != null) {
                        queue.offer(node.left);
                        adj.putIfAbsent(node.left, new ArrayList<>());
                        adj.get(node).add(node.left);
                        adj.get(node.left).add(node);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        adj.putIfAbsent(node.right, new ArrayList<>());
                        adj.get(node).add(node.right);
                        adj.get(node.right).add(node);
                    }
                }
            }
            return adj;
        }
    }
}
