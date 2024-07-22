import java.util.Arrays;
import java.util.HashMap;

public class Ones_and_Zeroes {
    class Pair {
        int zero;
        int ones;

        Pair(int zero, int ones) {
            this.zero = zero;
            this.ones = ones;
        }
    }

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            HashMap<String, Pair> map = new HashMap<>();
            updateMap(strs, map);
            int size = strs.length;
            int[][][] dp = new int[size][m + 1][n + 1];
            for (int[][] matrix : dp)
                for (int[] rows : matrix)
                    Arrays.fill(rows, -1);
            return function(strs, 0, m, n, map, size, dp);
        }

        public void updateMap(String[] strs, HashMap<String, Pair> map) {

            for (String s : strs) {
                int zero = 0;
                int one = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '0')
                        zero++;
                    else
                        one++;
                }
                map.put(s, new Pair(zero, one));
            }

        }

        public int function(String[] strs, int ind, int zeroes, int ones, HashMap<String, Pair> map, int size,
                int[][][] dp) {

            if (zeroes == 0 && ones == 0 || ind == size)
                return 0;

            if (dp[ind][zeroes][ones] != -1)
                return dp[ind][zeroes][ones];

            int curr_zeroes = 0;
            int curr_ones = 0;

            int take = Integer.MIN_VALUE;
            String s = strs[ind];

            if (map.get(s).zero <= zeroes && map.get(s).ones <= ones) {
                take = 1 + function(strs, ind + 1, zeroes - map.get(s).zero, ones - map.get(s).ones, map, size, dp);
            }

            int not_take = function(strs, ind + 1, zeroes, ones, map, size, dp);

            return dp[ind][zeroes][ones] = Math.max(take, not_take);
        }

    }
}
