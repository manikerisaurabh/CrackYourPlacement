import java.util.ArrayList;

public class DFS_of_Graph {
    class Solution {
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean[] visted = new boolean[V];
            ArrayList<Integer> ans = new ArrayList<>();

            dfs(0, adj, visted, ans);
            return ans;

        }

        public void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visted, ArrayList<Integer> ans) {
            visted[v] = true;

            ans.add(v);

            for (Integer neighber : adj.get(v)) {
                if (!visted[neighber]) {
                    dfs(neighber, adj, visted, ans);
                }
            }
        }
    }
}
