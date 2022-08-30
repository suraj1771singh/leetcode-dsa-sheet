
import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    q.add(new int[] { i, j });
                }
            }
        }
        // now doing BFS
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int a[] = q.poll();
                for (int dir[] : dirs) {
                    int x = a[0] + dir[0];
                    int y = a[1] + dir[1];
                    if (isValid(x, y, grid, visited)) {
                        grid[x][y] = 2;
                        visited[x][y] = true;
                        q.add(new int[] { x, y });
                    }
                }

            }
            cnt++;

        }
        // checking if there any fresh orange left or not
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return cnt != 0 ? cnt - 1 : 0;

    }

    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        if (x < 0 || y < 0 || x >= n || y >= m)
            return false;
        if (grid[x][y] != 1)
            return false;
        if (visited[x][y])
            return false;
        return true;
    }

}