import java.util.HashMap;

import javax.swing.tree.TreeNode;

public class Path_Sum_III {

    class Solution {
        int result = 0;

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null)
                return 0;
            HashMap<Long, Integer> map = new HashMap<>();

            map.put(0l, 1);
            long sum = 0;
            find_Sum(root, sum, targetSum, map);
            return result;
        }

        public void find_Sum(TreeNode curr, long sum, int target, HashMap<Long, Integer> map) {
            if (curr == null)
                return;
            sum += curr.val;

            if (map.containsKey(sum - target))
                result += map.get(sum - target);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
            find_Sum(curr.left, sum, target, map);
            find_Sum(curr.right, sum, target, map);
            map.put(sum, map.get(sum) - 1);
            return;

        }
    }
}
