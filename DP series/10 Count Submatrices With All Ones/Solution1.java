import java.util.Arrays;

class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length, res = 0;
        for (int up = 0; up < n; up++) {
            int h[] = new int[m];
            Arrays.fill(h, 1);
            for (int down = up; down < m; down++) {
                for (int k = 0; k < m; k++)
                    h[k] &= mat[down][k];
                // count horizontal submatrices
                int len = 0;
                for (int k = 0; k < m; k++) {
                    len = h[k] == 0 ? 0 : len + 1;
                    res += len;
                }
            }
        }
        return res;
    }
}
// Time complexity ; O(n*n*m)