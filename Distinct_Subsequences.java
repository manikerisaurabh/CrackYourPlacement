public class Distinct_Subsequences {
    class Solution {
        Integer[][] memo;

        public int numDistinct(String s, String t) {
            memo = new Integer[s.length()][t.length()];
            return rec(0, 0, s, t);
        }

        public int rec(int i, int j, String s, String t) {
            if (j == t.length()) {
                return 1;
            }
            if (i == s.length()) {
                return 0;
            }
            if (s.length() - i < t.length() - j) {
                return 0;
            }
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            int ans = 0;
            if (s.charAt(i) == t.charAt(j)) {
                ans = rec(i + 1, j + 1, s, t);
            }
            ans += rec(i + 1, j, s, t);
            return memo[i][j] = ans;
        }
    }
}
