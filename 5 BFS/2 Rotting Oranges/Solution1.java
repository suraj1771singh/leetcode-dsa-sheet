class Solution {
    int count;

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        boolean flag = false;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && flag)
                    return -1;
                if (grid[i][j] == 2) {
                    flag = true;
                    DFS(i, j, n, m, grid);
                }
            }
        }
        return count;
    }

    private void DFS(int i, int j, int n, int m, int[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return;
        if (grid[i][j] == 0 || grid[i][j] == 3)
            return;
        grid[i][j] = 3;
        count++;
        DFS(i + 1, j, n, m, grid);
        DFS(i - 1, j, n, m, grid);
        DFS(i, j + 1, n, m, grid);
        DFS(i, j - 1, n, m, grid);
    }
}