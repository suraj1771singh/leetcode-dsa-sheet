// -----------------USING PREFIX AND SUFFIX

class Solution1 {
    public int trap(int[] arr) {
        int res = 0;
        // precalculate prefix max and suffix max array

        // prefix max array
        long[] prefixSum = new long[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], arr[i]);
        }

        // suffix max array
        long[] suffixSum = new long[arr.length];
        suffixSum[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1], arr[i]);
        }

        for (int i = 1; i < arr.length - 1; i++) {
            res += Math.min(prefixSum[i], suffixSum[i]) - arr[i];
        }
        return res;
    }
}
// Time complexity : O(n)
// Space complexity : O(n)