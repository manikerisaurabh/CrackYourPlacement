import java.util.ArrayList;

public class Detect_cycle_in_an_undirected_graph {
    class Solution {
        // Function to detect cycle in an undirected graph.

        public boolean dfs(int index, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int parent) {
            visited[index] = true;

            for (int i = 0; i < adj.get(index).size(); i++) {
                int curr = adj.get(index).get(i);
                if (!visited[curr]) {
                    if (dfs(curr, visited, adj, index))
                        return true;
                } else if (visited[curr] && curr != parent) {
                    return true;
                }
            }

            return false;
        }

        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

            int size = adj.size();
            boolean[] visited = new boolean[size];
            for (int i = 0; i < V; i++) {
                if (!visited[i])
                    if (dfs(i, visited, adj, -1))
                        return true;
            }

            return false;

        }
    }
}
