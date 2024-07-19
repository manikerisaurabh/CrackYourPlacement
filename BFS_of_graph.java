import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_of_graph {

    class Solution {
        // Function to return Breadth First Traversal of given graph.
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            ArrayList<Integer> bfsResult = new ArrayList<>();
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();

            // Start BFS from the first node (assuming node 0)
            queue.add(0);
            visited[0] = true;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                bfsResult.add(node);

                // Get all adjacent vertices of the dequeued node
                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }

            return bfsResult;
        }
    }
}