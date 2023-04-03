//prefix sum
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int presum[][] = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                presum[i][j] = mat[i][j] + presum[i + 1][j] + presum[i][j + 1] - presum[i + 1][j + 1];
            }
        }

        int res[][] = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res[r][c] = presum[Math.max(0, r - k)][Math.max(0, c - k)] -
                        (presum[Math.min(r + k + 1, m)][Math.max(c - k, 0)]
                                + presum[Math.max(r - k, 0)][Math.min(c + k + 1, n)]
                                - presum[Math.min(r + k + 1, m)][Math.min(c + k + 1, n)]);
            }
        }
        return res;
    }
}
// Time complexity : O(n*m)