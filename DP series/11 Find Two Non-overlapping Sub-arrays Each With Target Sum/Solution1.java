import java.util.Arrays;

//HINT : consider any index i, find the minium len subarrray before it and after it, 
//prefix to store minimum subarray before i , and prefix to store minimum subarray after i 

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, s = 0, sum = arr[0];

        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = sum == target ? 1 : (int) 1e9;
        for (int i = 1; i < n; i++) {
            while (s < i && sum + arr[i] > target) {
                sum -= arr[s];
                s++;
            }
            sum += arr[i];
            if (sum == target)
                prefix[i] = Math.min(prefix[i - 1], i - s + 1);
            else
                prefix[i] = prefix[i - 1];
        }

        int e = n - 1;
        sum = arr[n - 1];
        suffix[n - 1] = sum == target ? 1 : (int) 1e9;

        for (int i = n - 2; i >= 0; i--) {
            while (e > i && sum + arr[i] > target) {
                sum -= arr[e];
                e--;
            }
            sum += arr[i];
            if (sum == target)
                suffix[i] = Math.min(suffix[i + 1], e - i + 1);
            else
                suffix[i] = suffix[i + 1];
        }
        int ans = (int) 1e9;
        for (int i = 1; i < n; i++)
            ans = Math.min(ans, prefix[i - 1] + suffix[i]);

        return ans > n ? -1 : ans;
    }
}
// Time complexity : O(n)