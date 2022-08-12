import java.util.Arrays;

class Solution1 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for (int r[] : dp)
            Arrays.fill(r, -1);
        return f(0, n - 1, arr, dp);

    }

    public int f(int l, int r, int[] arr, int dp[][]) {
        int ans = (int) 1e9;
        if (l >= r)
            return 0;
        if (dp[l][r] != -1)
            return dp[l][r];
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

            ans = Math.min(ans, left_max * right_max + f(l, i - 1, arr, dp) + f(i, r, arr, dp));
        }
        return dp[l][r] = ans;
    }
}

// public int f(int l, int r, int[] arr) {
// int ans = (int) 1e9;
// if (l < r) {
// int mini_ind = l;
// int mini = (int) 1e9;

// for (int i = l + 1; i <= r; i++) {
// // find max in left
// int left_max = arr[i - 1];
// int left = i - 1;
// while (left-- > l)
// left_max = Math.max(left_max, arr[left]);
// // find max in right
// int right_max = arr[i];
// int right = i;
// while (right++ < r)
// right_max = Math.max(right_max, arr[right]);

// if (mini >= left_max * right_max) {
// mini = left_max * right_max;
// mini_ind = i;
// ans = Math.min(ans, mini + f(l, mini_ind - 1, arr) + f(mini_ind, r, arr));
// }
// ans = Math.min(ans, mini + f(l, mini_ind - 1, arr) + f(mini_ind, r, arr));
// }
// }
// return ans == (int) 1e9 ? 0 : ans;

// }