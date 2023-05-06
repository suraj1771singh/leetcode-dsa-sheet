
import java.util.*;

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int n = tiles.length, ans = 0;
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int ind = i, tiles_cov = 0;
            int n_len = tiles[ind][0] + carpetLen;
            while (ind < n) {
                int a[] = tiles[ind++];

                if (a[1] < n_len) {
                    tiles_cov += a[1] - a[0] + 1;
                } else {
                    if (n_len - a[0] > 0)
                        tiles_cov += n_len - a[0];
                    break;
                }
            }

            ans = Math.max(ans, tiles_cov);

        }
        return ans;
    }
}
// Time complexity : O(n^2)