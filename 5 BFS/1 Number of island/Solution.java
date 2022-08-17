class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFSRecur(i, j, grid);
                }
            }
        }
        return count;

    }

    public void DFSRecur(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;
        if (grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        DFSRecur(i + 1, j, grid);
        DFSRecur(i - 1, j, grid);
        DFSRecur(i, j + 1, grid);
        DFSRecur(i, j - 1, grid);
    }
}
// Time complexity : O(mn)
// Space complexity : O(mn)