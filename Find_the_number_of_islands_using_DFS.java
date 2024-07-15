public class Find_the_number_of_islands_using_DFS {
    class Solution {
        private void dfs(int row, int col, char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0')
                return;
            grid[row][col] = '0';

            dfs(row - 1, col - 1, grid);
            dfs(row - 1, col + 1, grid);
            dfs(row - 1, col, grid);
            dfs(row, col + 1, grid);
            dfs(row + 1, col + 1, grid);
            dfs(row + 1, col, grid);
            dfs(row + 1, col - 1, grid);
            dfs(row, col - 1, grid);
        }

        // Function to find the number of islands.
        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(i, j, grid);
                    }
                }
            }

            return count;

        }
    }
}
