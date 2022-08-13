import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        int next_smaller[] = new int[n];
        int prev_smaller[] = new int[n];

        for (int i = 0; i < n; i++) {
            next_smaller[i] = n - i - 1;
            prev_smaller[i] = i;
        }

        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && arr[s1.peek()] > arr[i]) {
                int ind = s1.pop();
                next_smaller[ind] = i - ind - 1;
            }
            s1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && arr[s2.peek()] >= arr[i]) {
                int ind = s2.pop();
                prev_smaller[ind] = ind - i - 1;
            }
            s2.push(i);
        }
        long ans = 0;
        int MOD = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] * (next_smaller[i] + 1) * (prev_smaller[i] + 1)) % MOD;

        }
        return (int)ans;

    }
}
// Time complexity : O(n)
// Space complexity : O(n)