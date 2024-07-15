import java.util.LinkedList;
import java.util.Queue;

public class Replace_Os_with_Xs {
    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    class Solution {
        static char[][] fill(int n, int m, char ar[][]) {
            // code here
            Queue<Pair> q = new LinkedList<>();

            for (int j = 0; j < m; j++) {
                if (ar[0][j] == 'O') {
                    ar[0][j] = 't';
                    q.add(new Pair(0, j));
                }
                if (ar[n - 1][j] == 'O') {
                    ar[n - 1][j] = 't';
                    q.add(new Pair(n - 1, j));
                }
            }

            for (int i = 1; i < n - 1; i++) {
                if (ar[i][0] == 'O') {
                    ar[i][0] = 't';
                    q.add(new Pair(i, 0));
                }
                if (ar[i][m - 1] == 'O') {
                    ar[i][m - 1] = 't';
                    q.add(new Pair(i, m - 1));
                }
            }

            while (!q.isEmpty()) {
                Pair p = q.remove();
                int a = p.i;
                int b = p.j;
                if (a - 1 >= 0) {
                    if (ar[a - 1][b] == 'O') {
                        ar[a - 1][b] = 't';
                        q.add(new Pair(a - 1, b));
                    }
                }
                if (a + 1 < n) {
                    if (ar[a + 1][b] == 'O') {
                        ar[a + 1][b] = 't';
                        q.add(new Pair(a + 1, b));
                    }
                }
                if (b + 1 < m) {
                    if (ar[a][b + 1] == 'O') {
                        ar[a][b + 1] = 't';
                        q.add(new Pair(a, b + 1));
                    }
                }
                if (b - 1 >= 0) {
                    if (ar[a][b - 1] == 'O') {
                        ar[a][b - 1] = 't';
                        q.add(new Pair(a, b - 1));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ar[i][j] == 'O') {
                        ar[i][j] = 'X';
                    }
                    if (ar[i][j] == 't') {
                        ar[i][j] = 'O';
                    }
                }
            }
            return ar;
        }
    }
}
