import java.util.*;

//----------ALGO
/*  1) use DFS to mark all first island visited
*   2) use BFS and keep expanding first island untill we hit second island and not visited
*/
class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    found = true;
                    dfs(i, j, visited, grid, q);
                    break;
                }
            }
            if (found)
                break;
        }
        // now use BFS
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int a[] = q.poll();
                for (int[] dir : dirs) {
                    int x = a[0] + dir[0];
                    int y = a[1] + dir[1];
                    if (!isValid(x, y, n, m))
                        continue;
                    if (grid[x][y] == 1 && !visited[x][y])
                        return count;
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new int[] { x, y });
                    }
                }
            }
            count++;
        }
        return count;

    }

    public void dfs(int i, int j, boolean visited[][], int[][] grid, Queue<int[]> q) {
        int n = grid.length, m = grid[0].length;
        if (!isValid(i, j, n, m))
            return;

        if (grid[i][j] == 0 || visited[i][j] == true)
            return;
        visited[i][j] = true;
        q.add(new int[] { i, j });

        dfs(i + 1, j, visited, grid, q);
        dfs(i - 1, j, visited, grid, q);
        dfs(i, j + 1, visited, grid, q);
        dfs(i, j - 1, visited, grid, q);

    }

    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return false;
        return true;
    }
}