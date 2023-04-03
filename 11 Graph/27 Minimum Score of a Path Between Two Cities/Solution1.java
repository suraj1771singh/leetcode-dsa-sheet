import java.util.*;
//----------------------USING BELLMAN FORD

class Solution {
    public int minScore(int n, int[][] roads) {
        int dis[] = new int[n + 1];
        Arrays.fill(dis, (int) 1e9);
        // dis[1]=0;
        for (int i = 0; i < n; i++) {
            boolean f = false;
            for (int road[] : roads) {
                int u = road[0];
                int v = road[1];
                int w = road[2];
                if (dis[u] > Math.min(dis[v], w)) {
                    dis[u] = Math.min(dis[v], w);
                    f = true;
                }
                if (dis[v] > Math.min(dis[u], w)) {
                    dis[v] = Math.min(dis[u], w);
                    f = true;
                }

            }
            if (!f)
                break;
        }
        return dis[n];
    }
}
// Time complexity : O(V*E)