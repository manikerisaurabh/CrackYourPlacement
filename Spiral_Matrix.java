import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    class Solution {
        enum Direction {
            RIGHT, DOWN, LEFT, UP
        }

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            if (matrix == null || matrix.length == 0) {
                return ans;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;
            int x = 0, y = 0;
            boolean[][] visited = new boolean[rows][cols];

            Direction direction = Direction.RIGHT;
            int totalElements = rows * cols;

            while (ans.size() < totalElements) {
                ans.add(matrix[x][y]);
                visited[x][y] = true;

                switch (direction) {
                    case RIGHT:
                        if (y + 1 < cols && !visited[x][y + 1]) {
                            y++;
                        } else {
                            direction = Direction.DOWN;
                            x++;
                        }
                        break;

                    case DOWN:
                        if (x + 1 < rows && !visited[x + 1][y]) {
                            x++;
                        } else {
                            direction = Direction.LEFT;
                            y--;
                        }
                        break;

                    case LEFT:
                        if (y - 1 >= 0 && !visited[x][y - 1]) {
                            y--;
                        } else {
                            direction = Direction.UP;
                            x--;
                        }
                        break;

                    case UP:
                        if (x - 1 >= 0 && !visited[x - 1][y]) {
                            x--;
                        } else {
                            direction = Direction.RIGHT;
                            y++;
                        }
                        break;

                }
            }
            return ans;
        }
    }
}
