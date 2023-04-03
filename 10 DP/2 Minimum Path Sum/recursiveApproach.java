
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return getmin(grid, m - 1, n - 1);
    }

    public int getmin(int[][] grid, int row, int col) {
        System.out.println(row + " " + col);
        if (row == 0 && col == 0) {
            System.out.println("hii");
            return grid[0][0];
        }
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE - 1000;
        }

        int up = grid[row][col] + getmin(grid, row - 1, col);
        int left = grid[row][col] + getmin(grid, row, col - 1);
        return Math.min(up, left);
    }
}
// Time complexity : O(2^(m*n))
// Space complexity : O(path length)