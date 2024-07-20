import java.util.ArrayList;
import java.util.List;

public class Permutations_II {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> matrix = new ArrayList<>();
            List<Integer> row = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            permutelist(list, row, matrix);
            return matrix;
        }

        public static void permutelist(List<Integer> list, List<Integer> row, List<List<Integer>> matrix) {
            if (list.size() == 0) {

                if (matrix.contains(row)) {
                    return;
                }
                matrix.add(new ArrayList<>(row));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                List<Integer> copy = new ArrayList<>(list);
                copy.remove(i);
                row.add(list.get(i));
                permutelist(copy, row, matrix);
                row.remove(row.size() - 1);
            }
        }
    }

}
