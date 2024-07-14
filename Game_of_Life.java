public class Game_of_Life {
    class Solution {
        public void gameOfLife(int[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            int[] directions = { -1, 0, 1 };
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int liveNeighbors = 0;
                    for (int dx : directions) {
                        for (int dy : directions) {
                            if (dx == 0 && dy == 0)
                                continue;
                            int neighborX = i + dx;
                            int neighborY = j + dy;
                            if (neighborX >= 0 && neighborX < rows && neighborY >= 0 && neighborY < cols &&
                                    (board[neighborX][neighborY] == 1 || board[neighborX][neighborY] == 2)) {
                                liveNeighbors++;
                            }
                        }
                    }
                    if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                        board[i][j] = 2; // 1 -> 0, mark as dead
                    } else if (board[i][j] == 0 && liveNeighbors == 3) {
                        board[i][j] = -1; // 0 -> 1, mark as live
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 0;
                    } else if (board[i][j] == -1) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}
