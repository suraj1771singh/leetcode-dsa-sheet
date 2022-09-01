import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
         int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                colors[i] = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next : graph[cur]) {
                        if (colors[next] == -1) {
                            colors[next] = 1 - colors[cur];
                            queue.offer(next);
                        } else if (colors[next] == colors[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}