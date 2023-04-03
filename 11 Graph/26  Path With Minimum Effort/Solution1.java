import java.util.*;

//---------------------DIJKSTRA 
//ALGO
/*
 * Cost function is different compared to actual dijkstra , 
 *  here, the total path cost is the maximum absolute difference, its a different kind of cost function compared to the vanilla adding all costs together along the path
    for Dijkstra, edge weight cannot be negative, but what does that really mean. It effectively means total path cost cannot go down when a new edge joins the path. In the vanilla Dijkstra, it's in the form of negative edge weight. If we translate that to this problem, we can see that the total path cost (maximum absolute difference) will never go down when a new edge joins the path
 */

class Solution {
    int dirs[][] = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int n = heights.length;
        int m = heights[0].length;
        int dis[][] = new int[n][m];
        for (int a[] : dis)
            Arrays.fill(a, (int) 1e9);
        dis[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });// [i, j, effort]

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            for (int dir[] : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m) {

                    int eff = Math.max(curr[2], Math.abs(heights[x][y] - heights[curr[0]][curr[1]]));

                    if (dis[x][y] > eff) {
                        dis[x][y] = eff;
                        pq.add(new int[] { x, y, dis[x][y] });
                    }
                }
            }
        }
        return dis[n - 1][m - 1];
    }
}
// Time complexit : O(V+ ElogV)