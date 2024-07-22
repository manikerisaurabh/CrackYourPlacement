public class Maximize_The_Cut_Segments {
    class Solution {
        // Function to find the maximum number of cuts.
        public int maximizeCuts(int n, int x, int y, int z) {
            // Your code here
            int[] dp = new int[n + 1];
            if (x > y) {
                x = x + y;
                y = x - y;
                x = x - y;
            }
            if (x > z) {
                x = x + z;
                z = x - z;
                x = x - z;
            }
            if (y > z) {
                y = y + z;
                z = y - z;
                y = y - z;
            }
            if (x > y) {
                x = x + y;
                y = x - y;
                x = x - y;
            }
            if (x > z) {
                x = x + z;
                z = x - z;
                x = x - z;
            }
            if (y > z) {
                y = y + z;
                z = y - z;
                y = y - z;
            }
            if (x > y) {
                x = x + y;
                y = x - y;
                x = x - y;
            }
            if (x > z) {
                x = x + z;
                z = x - z;
                x = x - z;
            }
            if (y > z) {
                y = y + z;
                z = y - z;
                y = y - z;
            }
            for (int i = x; i <= n; i++) {
                if (i - x >= 0 && dp[i - x] != 0) {
                    dp[i] = Math.max(dp[i], dp[i - x] + 1);
                }
                if (i - y >= 0 && dp[i - y] != 0) {
                    dp[i] = Math.max(dp[i], dp[i - y] + 1);
                }
                if (i - z >= 0 && dp[i - z] != 0) {
                    dp[i] = Math.max(dp[i], dp[i - z] + 1);
                }
                if (i % x == 0) {
                    dp[i] = i / x;
                }
                if (dp[i] == 0 && i % y == 0) {
                    dp[i] = i / y;
                }
                if (dp[i] == 0 && i % z == 0) {
                    dp[i] = i / z;
                }
            }

            return dp[n];
        }
    }
}
