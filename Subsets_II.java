import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            findAns(0, nums, new ArrayList<>());
            return ans;
        }

        public void findAns(int n, int[] nums, List<Integer> al) {
            ans.add(new ArrayList<>(al));
            for (int i = n; i < nums.length; i++) {
                if (i > n && nums[i] == nums[i - 1]) {
                    continue;
                }
                al.add(nums[i]);
                findAns(i + 1, nums, al);
                al.remove(al.size() - 1);

            }

        }
    }
}
