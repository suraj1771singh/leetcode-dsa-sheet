import java.util.*;

//------------DIJKSTRA ALGO

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1)
                continue;
            adj.get(manager[i]).add(new int[] { i, informTime[manager[i]] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { headID, 0 });
        int dis[] = new int[n];
        Arrays.fill(dis, (int) 1e9);
        dis[headID] = 0;

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            for (int next[] : adj.get(curr[0])) {
                if (dis[next[0]] > curr[1] + next[1]) {
                    dis[next[0]] = curr[1] + next[1];
                    pq.add(new int[] { next[0], dis[next[0]] });
                }
            }
        }
        int max = 0;
        for (int i : dis)
            max = Math.max(max, i);
        return max;
    }
}
// Tim complexity : O(nlogn)