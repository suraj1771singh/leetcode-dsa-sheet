
//--------NAIVE APPROACH

class Solution1 {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((time[i] + time[j]) % 60 == 0)
                    ans++;
            }
        }
        return ans;
    }
}
// Time complexity : O(n^2)
// Space complexity : O(1)