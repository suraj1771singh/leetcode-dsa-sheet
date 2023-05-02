//DO best time to sell stocks (easy) first
//additional cndts : with every step maxi is decreasing (penalty) and keep track of maximum

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0] - 1, n = values.length, res = 0;
        for (int i = 1; i < n; i++, --max) {
            res = Math.max(res, max + values[i]);
            max = Math.max(max, values[i]);
        }
        return res;
    }
}
// Time complexity : O(n)