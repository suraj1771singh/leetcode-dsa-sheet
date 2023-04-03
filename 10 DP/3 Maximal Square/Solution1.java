class Solution {
    public int maximalSquare(char[][] matrix) {
        int area = 0, n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || dp[i][j] == 0) {
                    area = Math.max(area, dp[i][j]);
                    continue;
                }
                dp[i][j] += Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                area = Math.max(area, dp[i][j] * dp[i][j]);

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return area;
    }
}