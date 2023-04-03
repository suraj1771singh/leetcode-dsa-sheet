//------USING BELLMANFORD (MODIFIED)

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double dis[] = new double[n];
        dis[start] = 1;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];
                if (dis[v] < dis[u] * prob) {
                    dis[v] = dis[u] * prob;
                    flag = true;
                } else if (dis[u] < dis[v] * prob) {
                    dis[u] = dis[v] * prob;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
        return dis[end];
    }
}

// Time complexity : O(V*E)