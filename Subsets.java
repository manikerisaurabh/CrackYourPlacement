import java.util.ArrayList;
import java.util.List;

public class Subsets {
    class Solution {
        private void solveRecBacktracking(int[] nums, int idx, List<List<Integer>> res, List<Integer> l) {
            res.add(new ArrayList<>(l));

            for (int i = idx; i < nums.length; i++) {
                l.add(nums[i]);
                solveRecBacktracking(nums, i + 1, res, l);
                l.remove(l.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            solveRecBacktracking(nums, 0, res, new ArrayList<>());
            return res;
        }
    }
}
