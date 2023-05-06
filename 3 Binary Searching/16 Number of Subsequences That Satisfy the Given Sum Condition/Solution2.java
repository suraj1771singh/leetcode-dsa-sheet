import java.util.Arrays;

//-----------USING PRECOMPUTED POW ARRAY
class Solution {
    final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, h = n - 1;
        int pow[] = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++)
            pow[i] = (pow[i - 1] * 2) % MOD;
        long ans = 0;
        while (l <= h) {
            if (nums[l] + nums[h] > target)
                h--;
            else {
                ans = (ans + pow[h - l]) % MOD;
                l++;
            }
        }
        return (int) ans;
    }
}
// Time complexit : O(n*log n)