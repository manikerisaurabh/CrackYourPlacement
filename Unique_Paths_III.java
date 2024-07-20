public class Unique_Paths_III {
    class Solution {
        public int res = 0;

        public int uniquePathsIII(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int strI = 0;
            int strJ = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == -1)
                        visited[i][j] = true;
                    else if (grid[i][j] == 1) {
                        strI = i;
                        strJ = j;
                    }
                }
            }
            dfs(grid, visited, strI, strJ);
            return res;
        }

        public void dfs(int[][] grid, boolean[][] visited, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
                return;
            if (visited[i][j])
                return;
            visited[i][j] = true;
            if (grid[i][j] == 2) {
                boolean allVis = true;
                for (int k = 0; k < visited.length; k++) {
                    for (int l = 0; l < visited[0].length; l++) {
                        allVis &= visited[k][l];
                    }
                }
                if (allVis)
                    res++;

            } else if (grid[i][j] == 0 || grid[i][j] == 1) {
                dfs(grid, visited, i, j + 1);
                dfs(grid, visited, i, j - 1);
                dfs(grid, visited, i + 1, j);
                dfs(grid, visited, i - 1, j);

            }
            visited[i][j] = false;
        }
    }
}
