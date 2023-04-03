class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        int q = Math.min(n, m);

        // calculate the prefix sum grid
        int presum[][] = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                presum[i][j] = mat[i][j] + presum[i + 1][j] + presum[i][j + 1] - presum[i + 1][j + 1];
            }
        }
        int res = 0, l = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                while (i + l <= n && j + l <= m &&
                        (presum[i + l][j + l] - presum[i + l][j] - presum[i][j + l] + presum[i][j] <= threshold)) {
                    res = l++;
                }
            }
        }
        return res;
    }
}
// Time complexity : O(n*m*min(n,m))