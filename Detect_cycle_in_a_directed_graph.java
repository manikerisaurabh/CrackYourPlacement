import java.util.ArrayList;

public class Detect_cycle_in_a_directed_graph {

    class Solution {
        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            // code here
            boolean visited[] = new boolean[V];
            boolean visit[] = new boolean[V];
            boolean v = true;
            for (int i = 0; i < V; i++) {
                if (DfsDetect(adj, visited, i, visit)) {
                    return true; // Cycle detected.
                }
            }
            return false;
        }

        public boolean DfsDetect(ArrayList<ArrayList<Integer>> adj, boolean visited[], int curr, boolean visit[]) {
            visited[curr] = true;
            visit[curr] = true;
            for (int i = 0; i < adj.get(curr).size(); i++) {
                int v = adj.get(curr).get(i);
                if (visited[v] == true) {
                    return true;
                }
                if (visit[v] == true) {
                    continue;
                } else {
                    if (DfsDetect(adj, visited, v, visit)) {
                        return true;
                    }
                }

            }
            visited[curr] = false;
            return false;
        }
    }
}
