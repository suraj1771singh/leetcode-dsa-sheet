class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int ans = 0;
        int[][] prefix1 = new int[m][n];
        int[][] suffix1 = new int[m][n];
        int[][] prefix2 = new int[n][m];
        int[][] suffix2 = new int[n][m];

        for (int i = 0; i < m; i++) {
            prefix1[i][0] = heightMap[i][0];
            suffix1[i][n - 1] = heightMap[i][n - 1];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefix1[i][j] = Math.max(prefix1[i][j - 1], heightMap[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 2; j >= 0; j--) {
                suffix1[i][j] = Math.max(suffix1[i][j + 1], heightMap[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            prefix2[i][0] = heightMap[0][i];
            suffix2[i][m - 1] = heightMap[m - 1][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefix2[i][j] = Math.max(prefix2[i][j - 1], heightMap[j][i]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m - 2; j >= 0; j--) {
                suffix2[i][j] = Math.max(suffix2[i][j + 1], heightMap[j][i]);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n - 1; j++) {
                int mini_x = Math.min(prefix1[i][j], suffix1[i][j]);
                int mini_y = Math.min(prefix2[j][i], suffix2[j][i]);
                ans += Math.min(mini_x, mini_y) - heightMap[i][j];
            }
        }
        return ans;
    }
}