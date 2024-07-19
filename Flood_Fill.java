import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {

            int n = image.length;
            int m = image[0].length;
            boolean[][] vis = new boolean[n][m];
            int initialValue = image[sr][sc];
            image[sr][sc] = color;
            bfs(image, vis, sr, sc, color, initialValue);
            return image;

        }

        public void bfs(int[][] image, boolean[][] vis, int sr, int sc, int color, int initialValue) {

            vis[sr][sc] = true;
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(sr, sc, image[sr][sc]));
            int n = image.length;
            int m = image[0].length;

            int[] rowPosibility = { -1, 0, 0, 1 };// Folowing the order when i ==0 moves up
                                                  // i==1 moves left
                                                  // i==2 moves right
                                                  // i==3 moves down
            int[] colPosibility = { 0, -1, 1, 0 };

            while (!q.isEmpty()) {

                Pair temp = q.poll();
                int r = temp.row;
                int c = temp.col;
                int v = temp.value;

                for (int i = 0; i < 4; i++) {
                    int newRow = r + rowPosibility[i];
                    int newCol = c + colPosibility[i];

                    // checking the new index are in the bounds are not
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                            vis[newRow][newCol] == false && image[newRow][newCol] == initialValue) {

                        vis[newRow][newCol] = true;
                        image[newRow][newCol] = color;
                        q.offer(new Pair(newRow, newCol, image[newRow][newCol]));// actually value member is not
                                                                                 // necessary for this problem
                    }
                }
            }
        }

        class Pair {
            int row, col, value;

            Pair(int row, int col, int value) {
                this.row = row;
                this.col = col;
                this.value = value;
            }
        }
    }
}
