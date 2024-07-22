import java.util.Arrays;

public class Knight_Dialer {
    class Solution {
        static final int[][] MOVES = {
                { 4, 6 },
                { 6, 8 },
                { 7, 9 },
                { 4, 8 },
                { 0, 3, 9 },
                {},
                { 0, 1, 7 },
                { 2, 6 },
                { 1, 3 },
                { 2, 4 }
        };

        public int knightDialer(int n) {
            long[] prev = new long[10];
            Arrays.fill(prev, 1);
            long mod = (long) 1e9 + 7;

            while (n-- > 1) {
                long next[] = new long[10];
                for (int i = 0; i < 10; i++) {
                    for (int val : MOVES[i]) {
                        next[i] += prev[val];
                        next[i] %= mod;
                    }
                }
                prev = next;
            }

            long res = 0l;
            for (long val : prev)
                res = (res + val) % mod;

            return (int) res;
        }
    }
}
