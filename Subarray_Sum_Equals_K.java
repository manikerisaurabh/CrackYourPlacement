import java.util.HashMap;

public class Subarray_Sum_Equals_K {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> sumF = new HashMap<>();
            sumF.put(0, 1);

            int cSum = 0;
            int count = 0;

            for (int num : nums) {
                cSum += num;

                if (sumF.containsKey(cSum - k)) {
                    count += sumF.get(cSum - k);
                }
                sumF.put(cSum, sumF.getOrDefault(cSum, 0) + 1);
            }

            return count;
        }
    }
}
