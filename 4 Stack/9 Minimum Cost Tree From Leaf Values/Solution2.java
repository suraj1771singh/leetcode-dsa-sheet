
//--------------TABULATION

public class Solution2 {

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int l = n - 1; l >= 0; l--) {
                if (l >= r)
                    continue;
                int ans = (int) 1e9;
                for (int i = l + 1; i <= r; i++) {

                    // find max in left
                    int left_max = arr[i - 1];
                    int left = i - 1;
                    while (left-- > l)
                        left_max = Math.max(left_max, arr[left]);
                    // find max in right
                    int right_max = arr[i];
                    int right = i;
                    while (right++ < r)
                        right_max = Math.max(right_max, arr[right]);

                    ans = Math.min(ans, left_max * right_max + dp[l][i - 1] + dp[i][r]);
                }
                dp[l][r] = ans;
            }
        }
        return dp[0][n - 1];
    }
}
// Time complexity : O(n^3)
// Space complexity : O(n^2)
