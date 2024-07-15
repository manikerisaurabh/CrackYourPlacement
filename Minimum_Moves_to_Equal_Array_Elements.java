import java.util.Arrays;

public class Minimum_Moves_to_Equal_Array_Elements {
    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int operations = 0, mid = nums[nums.length / 2];
            for (int num : nums) {
                operations += Math.abs(mid - num);
            }
            return operations;
        }
    }
}
