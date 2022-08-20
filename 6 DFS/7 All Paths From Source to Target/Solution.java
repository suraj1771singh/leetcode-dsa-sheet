import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<Integer> st = new ArrayList<>();
        dfs(0, n - 1, graph, st);
        return res;
    }

    public void dfs(int src, int dest, int[][] graph, List<Integer> st) {
        st.add(src);
        if (src == dest) {
            List<Integer> temp = new ArrayList<>(st);
            res.add(temp);
            st.remove(st.size() - 1);
            return;
        }
        for (int v : graph[src])
            dfs(v, dest, graph, st);

        st.remove(st.size() - 1);

    }
}