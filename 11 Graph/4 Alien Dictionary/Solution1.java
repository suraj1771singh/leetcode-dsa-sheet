import java.util.*;

//GFG
//---------------USING TOPOLOGICAL SORT
class Solution {
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++)
            adj.add(new ArrayList<>());
        // find edges , (stores in form of number, 0='a',1='b'....)
        for (int i = 0; i < N - 1; i++) {
            String first = dict[i];
            String second = dict[i + 1];
            int limit = Math.min(first.length(), second.length());
            int j = 0;
            while (j < limit && first.charAt(j) == second.charAt(j)) {
                j++;
            }
            if (j < first.length())
                adj.get(first.charAt(j) - 'a').add(second.charAt(j) - 'a');
        }
        int indegree[] = new int[K];
        for (int i = 0; i < K; i++) {
            for (int u : adj.get(i))
                indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        char[] ans = new char[K];
        int ind = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[ind++] = (char) (node + (int) 'a');
            for (int u : adj.get(node)) {
                indegree[u]--;
                if (indegree[u] == 0)
                    q.add(u);
            }

        }
        return new String(ans);

    }
}
// Time complexity :O( N*(avg length of each word) )