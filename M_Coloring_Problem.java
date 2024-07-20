public class M_Coloring_Problem {

    class solve {
        // Function to determine if graph can be coloured with at most M colours
        // such
        // that no two adjacent vertices of graph are coloured with same colour.
        private boolean issafe(boolean graph[][], int v, int[] colors, int c, int n) {
            for (int i = 0; i < n; i++) {
                if (graph[v][i] && c == colors[i]) {
                    return false;
                }
            }

            return true;
        }

        public boolean graphColoring(boolean graph[][], int m, int n) {
            // Your code here
            int colors[] = new int[n];
            for (int i = 0; i < n; i++) {
                colors[i] = 0;

            }
            if (solve(graph, m, colors, 0, n)) {

                return true;
            } else {
                return false;
            }
        }

        public boolean solve(boolean graph[][], int m, int colors[], int v, int n) {
            if (v == n) {
                return true;
            }
            for (int c = 1; c <= m; c++) {
                if (issafe(graph, v, colors, c, n)) {

                    colors[v] = c;
                    if (solve(graph, m, colors, v + 1, n)) {
                        return true;
                    }
                    colors[v] = 0;

                }

            }

            return false;

        }
    }
}
