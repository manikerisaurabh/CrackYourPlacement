import java.util.HashSet;

public class Find_the_Duplicate_Number {

    class Solution {
        public int findDuplicate(int[] nums) {
            HashSet<Integer> seen = new HashSet<>();
            for (int num : nums) {
                if (seen.contains(num)) {
                    return num;
                }
                seen.add(num);
            }
            return -1;
        }
    }
}