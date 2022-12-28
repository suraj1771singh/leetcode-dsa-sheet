import java.util.*;;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int[] dist = dijkstra(n, roads, n - 1);
        System.out.println(Arrays.toString(dist));
        return 1;

    }

    // dijkstra
    public int[] dijkstra(int n, int[][] roads, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { start, 0 });
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if (visited[curNode])
                continue;
            visited[curNode] = true;
            for (int[] road : roads) {
                if (road[0] == curNode) {
                    int nextNode = road[1];
                    int nextDist = road[2];
                    if (dist[nextNode] > curDist + nextDist) {
                        dist[nextNode] = curDist + nextDist;
                        pq.offer(new int[] { nextNode, dist[nextNode] });
                    }
                }
            }
        }
        return dist;
    }
}