import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_II {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int[] f = new int[51];
            int n = candidates.length;
            int i = 0;
            int size = 0;
            for (int g : candidates) {
                f[g]++;
                if (f[g] == 1)
                    size++;
            }
            int[] h = new int[size];
            size = 0;
            for (int g = 1; g <= 50; g++) {
                if (f[g] > 0)
                    h[size++] = g;
            }
            get(ans, new ArrayList<>(), 0, size, 0, target, h, f, 0);
            return ans;
        }

        static void get(List<List<Integer>> ans, List<Integer> a, int k, int n, int sum, int t, int[] arr, int[] f,
                int s) {
            if (k == n || arr[k] == 0 || sum + arr[k] > t) {
                return;
            }
            if (sum + arr[k] < t) {
                if (f[arr[k]] > 0) {
                    a.add(arr[k]);
                    f[arr[k]]--;
                    get(ans, a, k, n, sum + arr[k], t, arr, f, s + 1);
                    a.remove(s);
                    f[arr[k]]++;
                }
                get(ans, a, k + 1, n, sum, t, arr, f, s);
            } else if (f[arr[k]] > 0) {
                a.add(arr[k]);
                ans.add(new ArrayList<>(a));
                a.remove(s);
                return;
            }
        }

    }
}
