import java.util.*;

//HINT : let dp[i] == longest subsequence till now ending at i the index
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {

            int prevind = map.getOrDefault(arr[i] - difference, -1);
            if (prevind != -1)
                dp[i] = Math.max(dp[i], 1 + dp[prevind]);
            map.put(arr[i], i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// Time complexity : O(n)