class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int indegree[][] = new int[n + 1][2];
        for (int edge[] : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            if (type == 1) {
                indegree[u][0]++;
                indegree[v][0]++;
            } else if (type == 2) {
                indegree[u][1]++;
                indegree[v][1]++;
            } else {
                indegree[u][0]++;
                indegree[v][0]++;
                indegree[u][1]++;
                indegree[v][1]++;
            }
        }
        int cnt = 0;
        for (int edge[] : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            // can i remove it
            if (type == 1) {
                if (indegree[u][0] > 1 && indegree[v][0] > 1) {
                    indegree[u][0]--;
                    indegree[v][0]++;
                    cnt++;
                }
            } else if (type == 2) {
                if (indegree[u][1] > 1 && indegree[v][1] > 1) {
                    indegree[u][1]--;
                    indegree[v][1]++;
                    cnt++;
                }
            } else {
                if (indegree[u][0] > 1 && indegree[u][0] > 1 && indegree[u][1] > 1
                        && indegree[v][1] > 1) {
                    indegree[u][0]--;
                    indegree[v][0]--;
                    indegree[u][1]--;
                    indegree[v][1]--;
                }
            }
        }
        return cnt;
    }
}