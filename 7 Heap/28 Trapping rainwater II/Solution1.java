import java.util.*;

// https://leetcode.com/problems/trapping-rain-water-ii/discuss/1138028/Python3Visualization-BFS-Solution-With-Explanation

//------ALGO
/*NOTE : Law of minimum , minimum will decide the heigth of water above each cell

 * 1) process from border , put all border point in min heap(height) and mark them visited 
 * 2) take minimum , check with non-visited neighbours
 *    three case arise i
 *    case 1) if curr>neigh =>ans+=curr-neigh and  pq.add(neigh) ans mark visited[neigh]=true;(add neigh with updated heigth along with water)
 *    case 2) if curr<=neigh => pq.add(neigh) and mark as visited[neigh]=true;
 */

class Solution {
    int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // put border point into pq
        int n = heightMap.length, m = heightMap[0].length, ans = 0;
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { i, 0, heightMap[i][0] });
            visited[i][0] = true;
            pq.add(new int[] { i, m - 1, heightMap[i][m - 1] });
            visited[i][m - 1] = true;
        }
        for (int j = 0; j < m; j++) {
            pq.add(new int[] { 0, j, heightMap[0][j] });
            visited[0][j] = true;
            pq.add(new int[] { n - 1, j, heightMap[n - 1][j] });
            visited[n - 1][j] = true;
        }
        while (!pq.isEmpty()) {
            int p[] = pq.poll();
            for (int dir[] : dirs) {
                int next_x = p[0] + dir[0];
                int next_y = p[1] + dir[1];
                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m && !visited[next_x][next_y]) {
                    visited[next_x][next_y] = true;
                    if (p[2] > heightMap[next_x][next_y]) {
                        ans += p[2] - heightMap[next_x][next_y];
                        pq.add(new int[] { next_x, next_y, p[2] });
                    } else
                        pq.add(new int[] { next_x, next_y, heightMap[next_x][next_y] });
                }
            }
        }
        return ans;
    }

}
// Time complexity : O(n*mlog(n*m))
// Space complexity : O(m*n)