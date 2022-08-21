class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;

    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 1;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            max = Math.max(max, 1 + dfs(matrix, i - 1, j, dp));
        }
        if (i < m - 1 && matrix[i][j] < matrix[i + 1][j]) {
            max = Math.max(max, 1 + dfs(matrix, i + 1, j, dp));
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            max = Math.max(max, 1 + dfs(matrix, i, j - 1, dp));
        }
        if (j < n - 1 && matrix[i][j] < matrix[i][j + 1]) {
            max = Math.max(max, 1 + dfs(matrix, i, j + 1, dp));
        }
        dp[i][j] = max;
        return max;
    }
}