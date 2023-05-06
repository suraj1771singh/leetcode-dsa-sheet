import java.util.Arrays;


//-----------Give wrong resultes because 2 powers might go above modulu so use precomputed pow
class Solution {
    final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, h = n - 1;
        long ans = 0;
        while (l <= h) {
            if (nums[l] + nums[h] > target)
                h--;
            else {
                ans = (ans + ((long) Math.pow(2L, h - l) % MOD)) % MOD;
                l++;
            }
        }
        return (int) ans;
    }
}
// Time complexit : O(n*log n)