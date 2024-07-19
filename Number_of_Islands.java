public class Number_of_Islands {
    public class Solution {
        public int numIslands(char[][] grid) {

            int count = 0;
            // traverse the grid elements one by one
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // increment the count and do DFS for the adjacent cells
                    if (grid[i][j] == '1') {
                        count++;
                        DFS(grid, i, j);
                    }
                }
            }

            return count;
        }

        private void DFS(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0'; // Mark as visited

            DFS(grid, i - 1, j);
            DFS(grid, i + 1, j);
            DFS(grid, i, j - 1);
            DFS(grid, i, j + 1);
        }
    }
}
